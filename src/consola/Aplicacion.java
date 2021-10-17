package consola;

import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Lote;
import Modelo.Producto;
import Procesamiento.Inventario;
import Procesamiento.LoaderInventario;
import Procesamiento.LoaderPointOfSale;
import Procesamiento.PointOfSale;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Aplicacion {
    //Testing
    private PointOfSale pointOfSale;
    private Inventario inventario;
    private int codigo = 0;
    private int idFactura = 0;

    public void printMenuPrincipal()
    {
        System.out.println("");
        System.out.println("----MENU-PRINCIPAL---------------");
        System.out.println("1. Abrir sistema de point of sale");
        System.out.println("2. Abrir sitema de inventario");
        System.out.println("3. Salir de aplicación");
        System.out.println("");
    }

    public void printMenuPointOfSale()
    {
        System.out.println("");
        System.out.println("----MENU-POINT-OF-SALE------------");
        System.out.println("1. Registar a un cliente nuevo");
        System.out.println("2. Consultar lista de clientes");
        System.out.println("3. Registrar los productos a comprar de un cliente");
        System.out.println("4. Salir del sistema point of sale");
        System.out.println("");
    }

    public void printMenuInventario()
    {
        System.out.println("");
        System.out.println("----MENU-INVENTARIO------------");
        System.out.println("1. Crear categoria");
        System.out.println("2. Ver todas las categorias");
        System.out.println("3. Crear producto");
        System.out.println("4. Obtener todos los productos");
        System.out.println("5. Crear lote");
        System.out.println("6. Obtener todos los lotes");
        System.out.println("7. Eliminar un lote especifico");
        System.out.println("8. Mostrar todos los lotes vencidos");
        System.out.println("9. Eliminar todos los lotes vencidos");
        System.out.println("10. Mostrar informacion de los lotes de un producto por su codigo");
        System.out.println("11. Mostrar el desempeño financiero general de un producto");
        System.out.println("12. Mostrar el desempeño financiero individual de cada lote de un producto");
        System.out.println("13. Mostrar los n productos más vendidos");
        System.out.println("14. Cargar llegada de nuevos lotes desde un csv");
        System.out.println("15. Salir del sistema de inventario");
        System.out.println("");
    }

    public void printMenuCompras()
    {
        System.out.println("1. agregar producto de cliente");
        System.out.println("2. finalizar compra y mostrar total a pagar por el cliente");
        //System.out.println("3. Salir Aplicacion");
    }

    public void ejecutarAplicacion() throws IOException {

        ejecutarCargarPointOfSales();
        ejecutarCargarInventario();

        List<Producto> productos = inventario.getProductos();
        codigo = productos.get(productos.size()-1).getCodigo()+1;
        boolean continuar = true;
        while(continuar)
        {
            try
            {
                printMenuPrincipal();
                int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
                if (opcion_seleccionada == 1)
                    ejecutarAplicacionPointOfSale();
                else if (opcion_seleccionada == 2)
                    ejecutarAplicacionInventario();
                else if (opcion_seleccionada == 3)
                {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }

            }
            catch (NumberFormatException e)
            {
                System.out.println("Por favor seleccione uno de los " +
                        "numeros en el menu");
            }
        }
    }

    public void ejecutarAplicacionPointOfSale()
    {
        boolean continuar = true;
        while(continuar) {
            try {
                printMenuPointOfSale();
                int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
                if (opcion_seleccionada == 1)
                    ejecutarCrearCliente();
                else if (opcion_seleccionada == 2)
                    ejecutarObtenerDatosClientes();
                else if (opcion_seleccionada == 3)
                {
                    ejecutarRegistrarCompras();
                }
                else if (opcion_seleccionada == 4) {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor seleccione uno de los " +
                        "numeros en el menu");
            }
        }
    }

    public void ejecutarAplicacionInventario()
    {
        boolean continuar = true;
        while(continuar) {
            try {
                printMenuInventario();
                int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
                if (opcion_seleccionada == 1)
                    ejecutarCrearCategoria();
                else if (opcion_seleccionada == 2)
                    ejecutarObtenerCategorias();
                else if (opcion_seleccionada == 3)
                    ejecutarCrearProducto();
                else if (opcion_seleccionada == 4)
                    ejecutarObtenerDatosProductos();
                else if (opcion_seleccionada == 5)
                    ejecutarCrearLote();
                else if (opcion_seleccionada == 6)
                    ejecutarObtenerDatosLotes();
                else if (opcion_seleccionada == 7)
                {
                    ejecutarEliminarLoteEspecifico();
                    updateDataLotes();
                }
                else if (opcion_seleccionada == 8)
                    ejecutarMostrarLotesVencidos();
                else if (opcion_seleccionada == 9)
                {
                    ejecutarEliminarLotesVencidos();
                    updateDataLotes();
                }
                else if (opcion_seleccionada == 10)
                    ejecutarMostrarLotesProducto();
                else if (opcion_seleccionada == 11)
                    ejecutarConsultarPerformanceGeneralProducto();
                else if (opcion_seleccionada == 12)
                    ejecutarConsultarPerformanceIndProducto();
                else if (opcion_seleccionada == 15) {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }

            } catch (NumberFormatException | IOException e) {
                System.out.println("Por favor seleccione uno de los " +
                        "numeros en el menu");
            }
        }
    }

    public void ejecutarCrearCliente()
    {
        String nombre = input("Ingrese el nombre del cliente");
        int edad = Integer.parseInt(input("Ingrese la edad del cliente"));
        String sexo = input("Ingrese el sexo del cliente");
        String estadoCivil = input("Ingrese el estado civl del cliente");
        int id = Integer.parseInt(input("Ingrese la id del cliente"));
        String situacionLaboral = input("Ingrese la situacion laboral del cliente");
        //int puntos = Integer.parseInt(input("Ingrese la cantidad de puntos del cliente"));
        pointOfSale.createClient(nombre, edad, sexo, estadoCivil, id, situacionLaboral);
        dataBaseClientes(nombre, edad, sexo, estadoCivil, id, situacionLaboral, 0);

    }

    public void ejecutarCrearLote()
    {
        int id = Integer.parseInt(input("Ingrese la id del lote"));
        String fechaEntrada = input("Ingrese la fehca de entrada del lote(MM/dd/yyyy)");
        String fechaVencimiento = input("Ingrese la fecha de vencimiento del lote(MM/dd/yyyy)");
        int codigoProducto = Integer.parseInt(input("Ingrese el codigo del producto del que va a ser el lote"));
        double precioPagado = Double.parseDouble(input("Ingrese el precio pagado por el lote"));
        double ventaPublico = Double.parseDouble(input("Ingrese el precio para vender al publico del lote"));
        int unidades = Integer.parseInt(input("Ingrese la cantidad de unidades que tiene el lote"));
        inventario.createLote(id, fechaEntrada, fechaVencimiento, codigoProducto, precioPagado,
                ventaPublico, unidades, 0);
        dataBaseLotes(id, fechaEntrada, fechaVencimiento, codigoProducto, precioPagado,
                ventaPublico, unidades, 0);
    }

    public void ejecutarCrearCategoria()
    {
        String categoria = input("Ingrese el nombre de la categoria que desea crear");
        inventario.createCategoria(categoria);
        dataBaseCategorias(categoria);
    }

    public String opcionesTipo()
    {
        String tipo = "";
        System.out.println("1. Gondola");
        System.out.println("2. Congelado");
        System.out.println("3. Refrigerado");
        System.out.println("4. Fresco");
        System.out.println("");
        try {
            int opcion = Integer.parseInt(input("Escriba el tipo de producto"));
            if (opcion == 1)
            {
                tipo = "gondola";
            }
            else if (opcion == 2)
            {
                tipo = "congelado";
            }
            else if (opcion == 3)
            {
                tipo = "refrigerado";
            }
            else if (opcion == 4)
            {
                tipo = "fresco";
            }
        }catch (NumberFormatException e) {
            System.out.println("Por favor seleccione uno de los " +
                    "numeros en el menu");
        }

        return tipo;
    }

    public boolean tipoEmpaquetado()
    {
        boolean confirmar = true;
        System.out.println("1. Sí es empaquetado");
        System.out.println("2. No es empaquetado");
        try {
            int opcion = Integer.parseInt(input("Escriba el tipo de producto"));
            if (opcion == 1)
            {
                confirmar = true;
            }
            else if (opcion == 2)
            {
                confirmar = false;
            }
        }catch (NumberFormatException e) {
            System.out.println("Por favor seleccione uno de los " +
                    "numeros en el menu");
        }

        return confirmar;
    }

    public void ejecutarCrearProducto()
    {
        String nombre = input("Escriba el nombre del producto");
        double precio = Double.parseDouble(input("Escriba el precio del producto"));
        double precioPorUnidad = Double.parseDouble(input("Escriba el precio por unidad del producto"));
        String unidadMedida = input("Escriba la unidad de medida del producto");
        double peso = Double.parseDouble(input("Escriba el peso del producto"));
        String categoria = input("Escriba la categoria del producto");
        String tipo = opcionesTipo();
        boolean empaquetado = tipoEmpaquetado();
        //boolean empaquetado = Boolean.parseBoolean(input("Escriba si es empaquetado"));
        //String codigo = input("Escriba el codigo del producto");
        inventario.createProduct(nombre, precio, precioPorUnidad, unidadMedida,
                peso, categoria, tipo, empaquetado);
        dataBaseProductos(nombre, precio, precioPorUnidad, unidadMedida, peso, categoria, codigo, tipo, empaquetado);
        codigo += 1;
    }

    public Factura ejecutarCrearFactura(List<Producto> productos, int idCliente)
    {
        //int idCliente = Integer.parseInt(input("Escriba la id del cliente"));
        Factura factura = new Factura(productos, idCliente, idFactura);
        pointOfSale.createFactura(productos, idCliente, idFactura);
        double totalPagar = factura.getTotalPagar();
        dataBaseFacturas(productos, idCliente, idFactura, totalPagar);
        idFactura += 1;
        return factura;
    }

    public void ejecutarObtenerDatosClientes()
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\clientes.csv";
        try(Scanner scanner = new Scanner(new File(filepath)))
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                System.out.print(scanner.next() + "|");
            }
            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo de la base de datos");
            e.printStackTrace();
        }
    }

    public void ejecutarObtenerDatosProductos()
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\productos.csv";
        try(Scanner scanner = new Scanner(new File(filepath)))
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                System.out.print(scanner.next() + "|");
            }
            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo de la base de datos");
            e.printStackTrace();
        }
    }

    public void ejecutarObtenerCategorias()
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\categorias.csv";
        try(Scanner scanner = new Scanner(new File(filepath)))
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                System.out.print(scanner.next() + "|");
            }
            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo de la base de datos");
            e.printStackTrace();
        }
    }

    public void ejecutarObtenerDatosLotes()
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\lotes.csv";
        try(Scanner scanner = new Scanner(new File(filepath)))
        {
            scanner.useDelimiter(",");
            while (scanner.hasNext())
            {
                System.out.print(scanner.next() + "|");
            }
            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo de la base de datos");
            e.printStackTrace();
        }
    }

    public void ejecutarMostrarLotesVencidos()
    {
        List<Lote> lotesVencidos = inventario.mostrarLotesVencidos();
        inventario.printInformacionLotes(lotesVencidos);
    }

    public void ejecutarMostrarLotesProducto()
    {
        int codigoProducto = Integer.parseInt(input("Ingrese el codigo del producto del cual desea obtener los lotes"));
        List<Lote> lotesProducto = inventario.getLoteByCodigoProducto(codigoProducto);
        inventario.printInformacionLotes(lotesProducto);
    }

    public void ejecutarEliminarLotesVencidos()
    {
        inventario.eliminarLotesVencidos();
    }

    public void ejecutarConsultarPerformanceGeneralProducto()
    {
        int codigoProducto = Integer.parseInt(input("Ingrese el codigo del producto del cual desea obtener los lotes"));
        inventario.consultarPerformanceLoteProducto(codigoProducto);
        //inventario.printInformePerformanceProducto(informeFinance.get(0).get(0));
    }

    public void ejecutarConsultarPerformanceIndProducto()
    {
        int codigoProducto = Integer.parseInt(input("Ingrese el codigo del producto del cual desea obtener los lotes"));
        System.out.println("");
        System.out.println("---INFORMACION-DETALLADA-DE-CADA-LOTE----");
        inventario.InformeAllLotesProducto(codigoProducto);
    }

    public void ejecutarRegistrarCompras()
    {
        List<Producto> productosCliente = new ArrayList<>();
        List<Cliente> clientesRegistrados = pointOfSale.getClientes();
        boolean continuar = true;
        while(continuar)
        {
            try {
                printMenuCompras();
                int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
                if (opcion_seleccionada == 1) {
                    int codigo = Integer.parseInt(input("Ingrese el codigo del producto"));
                    Producto productoCliente = pointOfSale.getProducto(codigo, inventario.getProductos());
                    if (!productoCliente.isEmpaquetado())
                    {
                        double peso = Double.parseDouble(input("Ingrese el peso que marcó el producto en la vascula"));
                        productoCliente.setPeso(peso);
                    }
                    productosCliente.add(productoCliente);
                }
                else if (opcion_seleccionada == 2)
                {
                    int idCliente = Integer.parseInt(input("Escriba la id del cliente"));
                    boolean confirmacion = pointOfSale.chequearId(idCliente);
                    Factura factura = ejecutarCrearFactura(productosCliente, idCliente);
                    double total = factura.getTotalPagar();
                    if (confirmacion)
                    {
                        int puntosAcumulados = pointOfSale.calcularPuntosAcumulados(total);
                        factura.printInformacionFactura(total, puntosAcumulados);
                        int clienteComprando = pointOfSale.buscarClientePorId(idCliente);
                        clientesRegistrados.get(clienteComprando).sumarPuntos(total);
                        updateDataClientes();
                        //System.out.println(clientesRegistrados.get(clienteComprando).getNombre());
                    }
                    else
                    {
                        factura.printInformacionFactura(total, 0);
                    }
                    updateLotesAfterCompra(productosCliente);
                    updateDataLotes();
                    continuar = false;

                }
                /*else if (opcion_seleccionada == 3) {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }*/
            } catch (NumberFormatException | IOException e) {
                System.out.println("Por favor seleccione uno de los " +
                        "numeros en el menu");
            }
        }
    }

    public String input(String mensaje)
    {
        try
        {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo de la consola");
            e.printStackTrace();
        }
        return null;
    }

    public void dataBaseAddHeaderClientes(String a, String b,String c, String d,
                                  String es, String f, String g, String adress)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\"+adress;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(a).append(",").append(b).append(",").append(c).append(",").append(d).append(",").append(es).append(",").append(f).append(",").append(g).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBaseAddHeaderLotes(String a, String b,String c, String d,
                                          String es, String f, String g, String h,
                                       String adress)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\"+adress;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(a).append(",").append(b).append(",").append(c).append(",").append(d).append(",").append(es).append(",").append(f).append(",").append(g).append(",").append(h).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBaseClientes(String nombre, int edad, String sexo, String estadoCivil, int id, String situacionLaboral, int puntos)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\clientes.csv" ;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(nombre).append(",").append(edad).append(",").append(sexo).append(",").append(estadoCivil).append(",").append(id).append(",").append(situacionLaboral).append(",").append(puntos).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBaseProductos(String nombre, double precio, double precioPorUnidad,
                                  String unidadPorMedida, double peso,
                                  String categoria, int codigo, String tipo, boolean empaquetado)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\productos.csv" ;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(nombre).append(",").append(precio).append(",").append(precioPorUnidad).append(",").append(unidadPorMedida).append(",").append(peso).append(",").append(",").append(categoria).append(",").append(codigo).append(",").append(tipo).append(",").append(empaquetado).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBaseLotes(int id, String fechaEntrada, String fechaVencimiento,
                                  int codigoProducto, double precioPagado, double ventaPublico,
                                  int unidades, int unidadesVendidas)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\lotes.csv" ;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(id).append(",").append(fechaEntrada).append(",").append(fechaVencimiento).append(",").append(codigoProducto).append(",").append(precioPagado).append(",").append(ventaPublico).append(",").append(unidades).append(",").append(unidadesVendidas).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBaseFacturas(List<Producto> productos, int codigoCliente, int idFactura, double totalPagar)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\facturas.csv" ;
        String codigosProductos = codigosProductos(productos);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(codigosProductos).append(",").append(codigoCliente).append(",").append(idFactura).append(",").append(idFactura).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBaseCategorias(String categoria)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\categorias.csv" ;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(categoria).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String codigosProductos(List<Producto> productos)
    {
        String codigosProductos = "";

        for (Producto producto : productos)
        {
            codigosProductos = Integer.toString(producto.getCodigo());
        }
        return codigosProductos;
    }

    public void ejecutarEliminarLoteEspecifico() throws IOException
    {
        int id = Integer.parseInt(input("Ingrese la id del lote que desea eliminar"));
        inventario.deleteLote(id);
    }

    public void dataBaseClientesReset() throws IOException
    {
        String file = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\clientes.csv";
        File inFile = new File(file);
        if (!inFile.delete())
        {
            System.out.println("Ah ocurrido un error actualizando la base de datos");
            return;
        }
        try
        {
            File newFile = new File(file);
            newFile.createNewFile();
        } catch (IOException e)
        {
            System.out.println("Ah ocurrido un error");
            e.printStackTrace();
        }
    }

    public void dataBaseLotesReset() throws IOException
    {
        String file = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\lotes.csv";
        File inFile = new File(file);
        if (!inFile.delete())
        {
            System.out.println("Ah ocurrido un error actualizando la base de datos");
            return;
        }
        try
        {
            File newFile = new File(file);
            newFile.createNewFile();
        } catch (IOException e)
        {
            System.out.println("Ah ocurrido un error");
            e.printStackTrace();
        }
    }

    public void updateDataClientes() throws IOException
    {
        dataBaseClientesReset();
        List<Cliente> clientes = pointOfSale.getClientes();

        dataBaseAddHeaderClientes("Nombre", "Edad", "Sexo", "Estado Civil",
                "Id", "Situacion Laboral", "puntos", "clientes.csv");
        for (Cliente cliente : clientes)
        {
            dataBaseClientes(cliente.getNombre(), cliente.getEdad(),
                    cliente.getSexo(), cliente.getEstadoCivil(), cliente.getId(),
                    cliente.getSituacionLaboral(), cliente.getPuntos());
        }
    }

    public void updateDataLotes() throws IOException
    {
        dataBaseLotesReset();
        List<Lote> lotes = inventario.getLotes();

        dataBaseAddHeaderLotes("Id", "Fecha Entrada", "Fecha Vencimiento", "Codigo Producto",
                "Precio Pagado", "Venta Publico", "Unidades","Unidades Vendidas", "lotes.csv");
        for (Lote lote : lotes)
        {
            dataBaseLotes(lote.getId(), lote.getFechaEntrada(), lote.getFechaVencimiento(),
                    lote.getCodigoProducto(), lote.getPrecioPagado(), lote.getVentaPublico(),
                    lote.getUnidades(), lote.getUnidadesVendidas());
        }
    }

    public void updateLotesAfterCompra(List<Producto> productos)
    {
        for (Producto producto : productos)
        {
            inventario.updateLoteCompra(producto.getCodigo());
        }
    }

    public void ejecutarCargarPointOfSales() throws IOException {
        pointOfSale = LoaderPointOfSale.cargarArchivos();
    }

    public void ejecutarCargarInventario() throws IOException {
        inventario = LoaderInventario.cargarArchivos();
    }

    public static void main(String[] args) throws IOException {
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.ejecutarAplicacion();
    }
}
