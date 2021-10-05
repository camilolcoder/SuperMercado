package Procesamiento;

import Modelo.Cliente;

import java.util.List;

public class PointOfSale {

    private List<Cliente> clientes;

    public PointOfSale(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void createClient(String nombre, String edad, String sexo,
    String estadoCivil, int id, String situacionLaboral, int puntos)
    {
        Cliente cliente = new Cliente(nombre, edad, sexo, estadoCivil,
        id, situacionLaboral, puntos);
        clientes.add(cliente);
    }
}
