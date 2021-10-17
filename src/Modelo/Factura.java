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
            if(!producto.isEmpaquetado())
            {
                total += producto.getPeso()*producto.getPrecioPorUnidad();
            }
            else
            {
                total += producto.getPrecio();
            }
        }
        return total;
    }

    public void printInformacionFactura(double totalPagar, int puntosAcumualdos)
    {
        System.out.println("");
        System.out.println("---------FACTURA---------");
        System.out.println("Id factura : "+id);
        System.out.println("Codigo cliente : "+codigoCliente);
        for (Producto producto : productos)
        {
            if (!producto.isEmpaquetado())
            {
                System.out.println(producto.getNombre()+" : "+producto.getPrecioPorUnidad()*producto.getPeso());
            }
            else{
                System.out.println(producto.getNombre()+" : "+producto.getPrecio());
            }

        }
        System.out.println("TOTAL A PAGAR : "+totalPagar);
        System.out.println("Puntos acumulados : "+puntosAcumualdos);
        System.out.println("-------------------------");
        System.out.println("");
    }
}
