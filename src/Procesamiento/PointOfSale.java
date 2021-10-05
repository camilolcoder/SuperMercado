package Procesamiento;

import Modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class PointOfSale {

    private List<Cliente> clientes;

    public PointOfSale(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void createClient(String nombre, int edad, String sexo,
    String estadoCivil, int id, String situacionLaboral)
    {
        Cliente cliente = new Cliente(nombre, edad, sexo, estadoCivil,
        id, situacionLaboral);
        clientes.add(cliente);
    }

    public List<Cliente> getClientes()
    {
        return clientes;
    }

    public void checkProduct()
    {

    }
}
