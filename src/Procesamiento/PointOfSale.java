package Procesamiento;

import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class PointOfSale {

    private List<Cliente> clientes;
    private List<Factura> facturas;

    public PointOfSale(List<Cliente> clientes, List<Factura> facturas) {
        this.clientes = clientes;
        this.facturas = facturas;
    }

    public void createClient(String nombre, int edad, String sexo,
    String estadoCivil, int id, String situacionLaboral)
    {
        Cliente cliente = new Cliente(nombre, edad, sexo, estadoCivil,
        id, situacionLaboral);
        clientes.add(cliente);
    }

    public void createFactura(List<Producto> productos, int codigoCliente, int id)
    {
        Factura factura = new Factura(productos, codigoCliente, id);
        facturas.add(factura);
    }

    public List<Cliente> getClientes()
    {
        return clientes;
    }

    public Producto getProducto(int codigo, List<Producto> productos)
    {
        boolean continuar = true;
        int counter = 0;
        while(continuar)
        {
            if (productos.get(counter).getCodigo() == codigo)
            {
                continuar = false;
            }
            counter += 1;
        }
        return productos.get(counter-1);
    }

}
