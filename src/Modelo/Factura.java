package Modelo;

import java.util.List;

public class Factura {

    private List<Producto> productos;
    private int codigoCliente;
    private int id;

    public Factura(List<Producto> productos, int codigoCliente, int id) {
        this.productos = productos;
        this.codigoCliente = codigoCliente;
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getCliente() {
        return codigoCliente;
    }

    public void setCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPagar()
    {
        int total = 0;
        for(Producto producto: productos)
        {
            total += producto.getPrecio();
        }
        return total;
    }
}
