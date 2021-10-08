package Procesamiento;

import Modelo.Cliente;
import Modelo.Factura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

public class LoaderPointOfSale {

    public static PointOfSale cargarArchivos() throws FileNotFoundException, IOException
    {
        String filepathClientes = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\clientes.csv";
        ArrayList<Cliente> clientes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filepathClientes));
        String linea = br.readLine();
        linea = br.readLine();
        while (linea != null)
        {
            String[] partes = linea.split(",");
            Cliente cliente = new Cliente(partes[0], Integer.parseInt(partes[1]), partes[2],
                    partes[3], Integer.parseInt(partes[4]), partes[5]);
            clientes.add(cliente);
            linea = br.readLine();

        }
        //-------------------------------------------------------------------
        String filepathFacturas = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\facturas.csv";
        ArrayList<Factura> facturas = new ArrayList<>();

        BufferedReader brf = new BufferedReader(new FileReader(filepathFacturas));
        String lineaf = brf.readLine();
        lineaf = brf.readLine();
        while (lineaf != null)
        {
            String[] partes = lineaf.split(",");
            //Factura factura = new Factura(partes[0], Integer.parseInt(partes[1]), partes[2],
             //      partes[3], Integer.parseInt(partes[4]), partes[5]);
            //facturas.add(facturas);
            lineaf = brf.readLine();

        }

        brf.close();
        System.out.println(clientes.get(0).getNombre());
        PointOfSale pointOfSale = new PointOfSale(clientes, facturas);
        return pointOfSale;
    }
}
