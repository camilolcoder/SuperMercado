package Procesamiento;

import Modelo.Lote;
import Modelo.Producto;

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
                              String categoria, String codigo)
    {
        Producto producto = new Producto(nombre, precio, precioPorUnidad, unidadMedida,
                peso, fresco, categoria, codigo);
        productos.add(producto);
    }

    public void createLote(int id, String fechaEntrada, String fechaVencimiento,
                           Producto producto, double precioPagado, double ventaPublico,
                           int unidades)
    {
        Lote lote = new Lote(id, fechaEntrada, fechaVencimiento, producto, precioPagado,
                ventaPublico, unidades);
        lotes.add(lote);
    }

}
