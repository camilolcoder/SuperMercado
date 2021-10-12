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
        System.out.println("1. Crear nuevo cliente");
        System.out.println("2. Consultar lista de clientes");
        System.out.println("3. Registrar los productos a comprar de un cliente");
        System.out.println("4. Salir del sistema point of sale");
        System.out.println("");
    }

    public void printMenuInventario()
    {
        System.out.println("");
        System.out.println("----MENU-INVENTARIO------------");
        System.out.println("1. Crear producto");
        System.out.println("2. Obtener todos los productos");
        System.out.println("3. Crear lote");
        System.out.println("4. Obtener todos los lotes");
        System.out.println("5. Eliminar un lote especifico");
        System.out.println("6. Mostrar todos los lotes vencidos");
        System.out.println("7. Eliminar todos los lotes vencidos");
        System.out.println("8. Mostrar el desempeño financiero de los lotes");
        System.out.println("9. Cargar llegada de nuevos lotes desde un csv");
        System.out.println("9. Salir del sistema de inventario");
        System.out.println("");
    }

    public void printMenuCompras()
    {
        System.out.println("1. agregar producto de cliente");
        System.out.println("2. finalizar compra y mostrar total a pagar por el cliente");
        System.out.println("3. Salir Aplicacion");
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
                    /*boolean test = inventario.chequearFechaVencimiento("11/8/2018");
                    if (!test)
                    {
                        System.out.println("El lote esta vencido");
                    }
                    else
                    {
                        System.out.println("El lote NO esta vencido");
                    }
                    /*String now = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
                    System.out.println(now);
                    if(now.equals("10-11-2021"))
                    {
                        System.out.println("Fecha correcta");
                    }*/
                    //updateDataClientes();
                    //updateDataLotes();
                    //csvTest("C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\testing.csv");
                    //updateCSV("C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\testing.csv",
                    //        "ferrai", 1, 1);
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
                    ejecutarCrearProducto();
                else if (opcion_seleccionada == 2)
                    ejecutarObtenerDatosProductos();
                else if (opcion_seleccionada == 3)
                    ejecutarCrearLote();
                else if (opcion_seleccionada == 4)
                    ejecutarObtenerDatosLotes();
                else if (opcion_seleccionada == 5)
                {
                    ejecutarEliminarLoteEspecifico();
                    updateDataLotes();
                }
                else if (opcion_seleccionada == 6)
                    ejecutarMostrarLotesVencidos();
                else if (opcion_seleccionada == 7)
                {
                    ejecutarEliminarLotesVencidos();
                    updateDataLotes();
                }
                else if (opcion_seleccionada == 9) {
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
        String codigoProducto = input("Ingrese el codigo del producto del que va a ser el lote");
        double precioPagado = Double.parseDouble(input("Ingrese el precio pagado por el lote"));
        double ventaPublico = Double.parseDouble(input("Ingrese el precio para vender al publico del lote"));
        int unidades = Integer.parseInt(input("Ingrese la cantidad de unidades que tiene el lote"));
        inventario.createLote(id, fechaEntrada, fechaVencimiento, codigoProducto, precioPagado,
                ventaPublico, unidades);
        dataBaseLotes(id, fechaEntrada, fechaVencimiento, codigoProducto, precioPagado,
                ventaPublico, unidades);
    }

    public void ejecutarCrearProducto()
    {
        String nombre = input("Escriba el nombre del producto");
        double precio = Double.parseDouble(input("Escriba el precio del producto"));
        double precioPorUnidad = Double.parseDouble(input("Escriba el precio por unidad del producto"));
        String unidadMedida = input("Escriba la unidad de medida del producto");
        double peso = Double.parseDouble(input("Escriba el peso del producto"));
        String fresco = input("Escriba si el producto es o no es fresco");
        String categoria = input("Escriba la categoria del producto");
        //String codigo = input("Escriba el codigo del producto");
        inventario.createProduct(nombre, precio, precioPorUnidad, unidadMedida,
                peso, fresco, categoria);
        dataBaseProductos(nombre, precio, precioPorUnidad, unidadMedida, peso, fresco, categoria, codigo);
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
        //inventario.mostrarLotesVencidos();
    }

    public void ejecutarEliminarLotesVencidos()
    {
        inventario.eliminarLotesVencidos();
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

                }
                else if (opcion_seleccionada == 3) {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }
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

    public void dataBaseAddHeader(String a, String b,String c, String d,
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
                                  String unidadPorMedida, double peso, String fresco,
                                  String categoria, int codigo)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\productos.csv" ;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(nombre).append(",").append(precio).append(",").append(precioPorUnidad).append(",").append(unidadPorMedida).append(",").append(peso).append(",").append(fresco).append(",").append(categoria).append(",").append(codigo).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataBaseLotes(int id, String fechaEntrada, String fechaVencimiento,
                                  String codigoProducto, double precioPagado, double ventaPublico,
                                  int unidades)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\lotes.csv" ;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(id).append(",").append(fechaEntrada).append(",").append(fechaVencimiento).append(",").append(codigoProducto).append(",").append(precioPagado).append(",").append(ventaPublico).append(",").append(unidades).append("\n");
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

    public String codigosProductos(List<Producto> productos)
    {
        String codigosProductos = "";

        for (Producto producto : productos)
        {
            codigosProductos = Integer.toString(producto.getCodigo());
        }
        return codigosProductos;
    }

    public void updateCSV(String fileToUpdate, String replace,
                                 int row, int col) throws IOException, CsvException {

        File inputFile = new File(fileToUpdate);

// Read existing file
        CSVReader reader = new CSVReader(new FileReader(inputFile));
        List<String[]> csvBody = reader.readAll();
// get CSV row column  and replace with by using row and column
        csvBody.get(row)[col] = replace;
        reader.close();

// Write to CSV file which is open
        CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
        writer.writeAll(csvBody);
        writer.flush();
        writer.close();
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

        dataBaseAddHeader("Nombre", "Edad", "Sexo", "Estado Civil",
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

        dataBaseAddHeader("Id", "Fecha Entrada", "Fecha Vencimiento", "Codigo Producto",
                "Precio Pagado", "Venta Publico", "Unidades", "lotes.csv");
        for (Lote lote : lotes)
        {
            dataBaseLotes(lote.getId(), lote.getFechaEntrada(), lote.getFechaVencimiento(),
                    lote.getCodigoProducto(), lote.getPrecioPagado(), lote.getVentaPublico(),
                    lote.getUnidades());
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
