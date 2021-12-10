package Procesamiento;

import Modelo.Lote;
import Modelo.Producto;
import Modelo.Promocion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Inventario {

    private List<Producto> productos;
    private List<Lote> lotes;
    private List<String> categorias;
    private Map<Integer, Promocion> promociones;

    public Inventario(List<Producto> productos, List<Lote> lotes, List<String>categorias, Map<Integer, Promocion>promociones) {
        this.productos = productos;
        this.lotes = lotes;
        this.categorias = categorias;
        this.promociones = promociones;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public Map<Integer, Promocion> getPromociones()
    {
        return promociones;
    }

    public void createProduct(String nombre, double precio, double precioPorUnidad,
                              String unidadMedida, double peso,
                              String categoria, String tipo, boolean empaquetado)
    {
        Producto producto = new Producto(nombre, precio, precioPorUnidad, unidadMedida,
                peso, categoria, tipo, empaquetado);
        productos.add(producto);
    }

    public void createLote(int id, String fechaEntrada, String fechaVencimiento,
                           int codigoProducto, double precioPagado, double ventaPublico,
                           int unidades, int unidadesVendidas, double peso, double pesoComprado)
    {
        Lote lote = new Lote(id, fechaEntrada, fechaVencimiento, codigoProducto, precioPagado,
                ventaPublico, unidades, unidadesVendidas, peso, pesoComprado);
        lotes.add(lote);
    }

    public void createCategoria(String categoria)
    {
        categorias.add(categoria);
    }

    public boolean chequearFechaVencimiento(String fechaVencimiento)
    {
        boolean chequeo = true;
        List<String> fechas = Arrays.asList(fechaVencimiento.split("/"));
        String now = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        List<String> fechasHoy = Arrays.asList(now.split("/"));
        int anoProducto = Integer.parseInt(fechas.get(2));
        int anoHoy = Integer.parseInt(fechasHoy.get(2));
        int mesProducto = Integer.parseInt(fechas.get(1));
        int mesHoy = Integer.parseInt(fechasHoy.get(1));
        int diaProducto = Integer.parseInt(fechas.get(0));
        int diaHoy = Integer.parseInt(fechasHoy.get(0));
        //System.out.println(anoProducto +" "+ anoHoy +" "+ mesProducto +" "+mesHoy +" "+diaProducto+" "+diaHoy);
        if (anoProducto < anoHoy)
        {
            chequeo = false;
            //System.out.println("UNO");
        }
        else if (mesProducto < mesHoy && anoProducto == anoHoy)
        {
            chequeo = false;
            //System.out.println("DOS");
        }
        else if (diaProducto < diaHoy && mesProducto >= mesHoy && anoProducto == anoHoy)
        {
            chequeo = false;
            //System.out.println("TRES");
        }
        return chequeo;
    }

    public boolean chequearFechaInicio(String fechaVencimiento)
    {
        boolean chequeo = true;
        List<String> fechas = Arrays.asList(fechaVencimiento.split("/"));
        String now = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        List<String> fechasHoy = Arrays.asList(now.split("/"));
        int anoProducto = Integer.parseInt(fechas.get(2));
        int anoHoy = Integer.parseInt(fechasHoy.get(2));
        int mesProducto = Integer.parseInt(fechas.get(1));
        int mesHoy = Integer.parseInt(fechasHoy.get(1));
        int diaProducto = Integer.parseInt(fechas.get(0));
        int diaHoy = Integer.parseInt(fechasHoy.get(0));
        //System.out.println(anoProducto +" "+ anoHoy +" "+ mesProducto +" "+mesHoy +" "+diaProducto+" "+diaHoy);
        if (anoProducto > anoHoy)
        {
            chequeo = false;
            //System.out.println("UNO");
        }
        else if (mesProducto > mesHoy && anoProducto == anoHoy)
        {
            chequeo = false;
            //System.out.println("DOS");
        }
        else if (diaProducto > diaHoy && mesProducto >= mesHoy && anoProducto == anoHoy)
        {
            chequeo = false;
            //System.out.println("TRES");
        }
        return chequeo;
    }

    public boolean estaVigente(Promocion promocion)
    {
        boolean chequeo = true;
        String fechaInicio = promocion.getFechaInicial();
        String fechaFinal = promocion.getFechaFinal();

        if(!chequearFechaVencimiento(fechaFinal) | !chequearFechaInicio(fechaInicio))
        {
            chequeo = false;
        }

        return chequeo;
    }

    public Producto getProductoByCodigo(int codigoProducto)
    {
        Producto productoCodigo = null;
        for (Producto producto : productos)
        {
            if (producto.getCodigo() == codigoProducto)
            {
                return producto;
            }
        }
        return productoCodigo;
    }

    public List<Lote> getLoteByCodigoProducto(int codigoProducto)
    {
        List<Lote> lotesProducto = new ArrayList<>();
        for (Lote lote : lotes)
        {
            if (lote.getCodigoProducto() == codigoProducto)
            {
                lotesProducto.add(lote);
            }
        }
        return lotesProducto;
    }

    public void deleteLote(int id)
    {
        //lotes.removeIf(lote -> lote.getId() == id);
        lotes.removeIf(lote -> lote.getId() == id);
    }

    public List<Lote> mostrarLotesVencidos()
    {
        List<Lote> lotesVencidos = new ArrayList<>();
        for (Lote lote : lotes)
        {
            if (!chequearFechaVencimiento(lote.getFechaVencimiento()))
            {
                lotesVencidos.add(lote);
            }
        }
        return lotesVencidos;
    }

    public void eliminarLotesVencidos()
    {
        //lotes.removeIf(lote -> !chequearFechaVencimiento(lote.getFechaVencimiento()));
        lotes.removeIf(lote -> !chequearFechaVencimiento(lote.getFechaVencimiento()));
    }

    public void updateLoteCompra(int codigoProduco)
    {
        //Lote loteEncontrado = null;
        for (Lote lote : lotes)
        {
            if (lote.getCodigoProducto() == codigoProduco)
            {
                lote.updateUnidades();
                return;
            }
        }
    }

    public void updateLoteNoEmpaquetadoCompra(int codigoProducto, double peso)
    {
        for (Lote lote : lotes)
        {
            if (lote.getCodigoProducto() == codigoProducto)
            {
                lote.updateNoEmpaquetado(peso);
                return;
            }
        }
    }

    public void printInformacionLotes(List<Lote> lotesToPrint)
    {
        for(Lote lote : lotesToPrint)
        {
            System.out.println(lote.getId()+"|"+lote.getFechaEntrada()+"|"+lote.getFechaVencimiento()+"|"+
                    lote.getCodigoProducto()+"|"+lote.getPrecioPagado()+"|"+lote.getVentaPublico()+"|"+
                    lote.getUnidades());
        }
    }

    public List<String> consultarPerformanceLoteProducto(int codigoProducto)
    {
        List<String> performanceData = new ArrayList<>();
        double precioLote = 0, precioVenta = 0, unidadesVendidas = 0, pesoComprado = 0,
        ganancias = 0, retornoInversion = 0;
        String puntoEquilibrio;
        List<Lote> lotesProducto = getLoteByCodigoProducto(codigoProducto);
        boolean prueba = getProductoByCodigo(codigoProducto).isEmpaquetado();
        for (Lote lote : lotesProducto)
        {
            precioLote += lote.getPrecioPagado();
            precioVenta = lote.getVentaPublico();
            if (!prueba)
            {
                pesoComprado += lote.getPesoComprado();
            }
            else
            {
                unidadesVendidas += lote.getUnidadesVendidas();
            }
        }
        if (!prueba)
        {
            ganancias = (precioVenta*pesoComprado)-precioLote;
        }
        else
        {
            ganancias = (precioVenta*unidadesVendidas)-precioLote;
        }
        //la formula del ROI = (netProfit/costOfInvestment)*100
        retornoInversion = Math.round((ganancias/precioLote)*100);
        if (ganancias >= 0)
        {
            puntoEquilibrio = "Punto de equilibrio alcanzado";
        }
        else
        {
            puntoEquilibrio = "Punto de equilibrio no alcanzado";
        }
        performanceData = Arrays.asList(String.valueOf(ganancias),
                String.valueOf(retornoInversion), puntoEquilibrio);
        //printInformePerformanceProducto(String.valueOf(ganancias),
        //                String.valueOf(retornoInversion), puntoEquilibrio);
        return performanceData;
    }

    public void printInformePerformanceProducto(String ganancias, String retornoInversion,
                                                String puntoEquilibrio)
    {
        //FeedBack de ideas
        //decir si ya se alcanzó el punto de
        //equilibrio o decir cuanto falta para llegar a este
        //además dar ideas de descuentos o remates teniendo
        //en cuenta cuanto los días que faltan para que se
        //venza un producto

        System.out.println("");
        System.out.println("---INFORMACION-FINANCIERA----");
        System.out.println("");
        System.out.println("---INFORMACION-GENERAL----");
        System.out.println("Ganancias : "+ganancias);
        System.out.println("Retorno de inversión: "+retornoInversion+"%");
        System.out.println("Punto de equilibrio: "+puntoEquilibrio);
        System.out.println("");
    }

    public void printInformePerformanceVariosLotes(String idLote, String ganancias,
                                                   String retornoInversion, String puntoEquilibrio)
    {
        System.out.println("");
        System.out.println("LOTE-"+idLote+"-----------------------");
        System.out.println("Ganancias : "+ganancias);
        System.out.println("Retorno de inversión: "+retornoInversion+"%");
        System.out.println("Punto de equilibrio: "+puntoEquilibrio);
        System.out.println("");
    }

    public List<List<String>> InformeAllLotesProducto(int codigoProducto)
    {
        List<List<String>> performanceDataGeneral = new ArrayList<>();
        List<String> performanceDataInd = new ArrayList<>();
        double precioLote = 0, precioVenta = 0, unidadesVendidas = 0, pesoComprado = 0,
                ganancias = 0, retornoInversion = 0;
        String puntoEquilibrio;
        List<Lote> lotesProducto = getLoteByCodigoProducto(codigoProducto);
        boolean prueba = getProductoByCodigo(codigoProducto).isEmpaquetado();
        for (Lote lote : lotesProducto)
        {
            precioLote = lote.getPrecioPagado();
            precioVenta = lote.getVentaPublico();
            if (!prueba)
            {
                pesoComprado = lote.getPesoComprado();
                ganancias = (precioVenta*pesoComprado)-precioLote;
            }
            else
            {
                unidadesVendidas = lote.getUnidadesVendidas();
                ganancias = (precioVenta*unidadesVendidas)-precioLote;
            }
            //la formula del ROI = (netProfit/costOfInvestment)*100
            retornoInversion = Math.round((ganancias/precioLote)*100);
            if (ganancias >= 0)
            {
                puntoEquilibrio = "Punto de equilibrio alcanzado";
            }
            else
            {
                puntoEquilibrio = "Punto de equilibrio no alcanzado";
            }
            performanceDataInd = Arrays.asList(String.valueOf(lote.getId()),
                    String.valueOf(ganancias), String.valueOf(retornoInversion),
                    puntoEquilibrio);
            performanceDataGeneral.add(performanceDataInd);
            //printInformePerformanceVariosLotes(String.valueOf(lote.getId()),
            //        String.valueOf(ganancias),String.valueOf(retornoInversion),
            //        puntoEquilibrio);
        }
        return performanceDataGeneral;
    }
    public boolean chequearExistenciaCategoria(String categoria)
    {
        boolean confirmacion = false;
        for (String test : categorias)
        {
            if (test.equals(categoria))
            {
                confirmacion = true;
            }
        }
        return confirmacion;
    }

    public void cargarNuevosLotesCsv(String filepath) throws IOException {

        //System.out.println("test");
        BufferedReader brl7 = new BufferedReader(new FileReader(filepath));
        String lineal = brl7.readLine();
        //lineal = brl.readLine();
        //System.out.println("test");
        while (lineal != null)
        {
            //System.out.println("test");
            String[] partesl = lineal.split(",");
            Lote lote = new Lote(Integer.parseInt(partesl[0]), partesl[1], partesl[2],
                    Integer.parseInt(partesl[3]), Double.parseDouble(partesl[4]), Double.parseDouble(partesl[5]),
                    Integer.parseInt(partesl[6]), Integer.parseInt(partesl[7]), Double.parseDouble(partesl[8]),
                    Double.parseDouble(partesl[9]));
            //lote.setUnidadesVendidas(Integer.parseInt(partesl[7]));
            //System.out.println("test");
            lotes.add(lote);
            lineal = brl7.readLine();
        }
        brl7.close();
        //System.out.println("test");
    }

    public int getRegalo(List<Producto> productos, int codigoProducto, String operacion)
    {
        String[] regalos = operacion.split("/");
        int cantidadFinal = 0;
        int cantidadNecesaria = Integer.parseInt(regalos[0]);
        int cantidadRegalar = cantidadNecesaria - Integer.parseInt(regalos[1]);

        int totalProductos = 0;
        for (Producto producto : productos)
        {
            if (producto.getCodigo() == codigoProducto)
            {
                totalProductos += 1;
            }
        }
        if (totalProductos >= cantidadNecesaria)
        {
            cantidadFinal =  totalProductos/cantidadNecesaria;
        }
        return cantidadFinal*cantidadRegalar;
    }

    public String getCombo(List<Producto> productos, int codigoProducto, String operacion)
    {
        String[] datos = operacion.split("-");
        double porcentajeDescuento = Double.parseDouble(datos[0]);
        String[] datosProductosCombo = datos[1].split("_");
        double valorTotal = 0;
        for (String comboDatos : datosProductosCombo)
        {
            String[] datosEspc = comboDatos.split("/");
            int codigProducto = Integer.parseInt(datosEspc[0]);
            double precioProducto = 0;
            for (Producto producto : productos)
            {
                if (codigProducto == producto.getCodigo())
                {
                    precioProducto = producto.getPrecio();
                }
            }
            valorTotal += precioProducto*Integer.parseInt(datosEspc[1]);
        }

        return "";
    }

    public void asociarImagenProducto(String direccionImg)
    {
        //TODO se podria asociar una imagen a un producto después de haberlo creado
    }

}
