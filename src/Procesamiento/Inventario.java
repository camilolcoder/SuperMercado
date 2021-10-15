package Procesamiento;

import Modelo.Lote;
import Modelo.Producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventario {

    private List<Producto> productos;
    private List<Lote> lotes;
    private List<String> categorias;

    public Inventario(List<Producto> productos, List<Lote> lotes) {
        this.productos = productos;
        this.lotes = lotes;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void createProduct(String nombre, double precio, double precioPorUnidad,
                              String unidadMedida, double peso, String fresco,
                              String categoria)
    {
        Producto producto = new Producto(nombre, precio, precioPorUnidad, unidadMedida,
                peso, fresco, categoria);
        productos.add(producto);
    }

    public void createLote(int id, String fechaEntrada, String fechaVencimiento,
                           int codigoProducto, double precioPagado, double ventaPublico,
                           int unidades)
    {
        Lote lote = new Lote(id, fechaEntrada, fechaVencimiento, codigoProducto, precioPagado,
                ventaPublico, unidades);
        lotes.add(lote);
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

    public void printInformacionLotes(List<Lote> lotesToPrint)
    {
        for(Lote lote : lotesToPrint)
        {
            System.out.println(lote.getId()+"|"+lote.getFechaEntrada()+"|"+lote.getFechaVencimiento()+"|"+
                    lote.getCodigoProducto()+"|"+lote.getPrecioPagado()+"|"+lote.getVentaPublico()+"|"+
                    lote.getUnidades());
        }
    }

    public void consultarPerformanceLotes()
    {
        //Lo que me piden es el desempeño de los productos, por ende, debemos buscar
        // todos los lotes del mismo producto y revisar su desempeño de manera conjunta
    }
}
