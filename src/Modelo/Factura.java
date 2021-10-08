package Modelo;

import java.util.List;

public class Factura {

    private List<Producto> productos;
    private Cliente cliente;
    private int id;

    public Factura(List<Producto> productos, Cliente cliente, int id) {
        this.productos = productos;
        this.cliente = cliente;
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
