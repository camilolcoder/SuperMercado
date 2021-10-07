package Procesamiento;

import Modelo.Cliente;

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
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\clientes.csv";
        ArrayList<Cliente> clientes = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filepath));
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

        br.close();
        System.out.println(clientes.get(0).getNombre());
        PointOfSale pointOfSale = new PointOfSale(clientes);
        return pointOfSale;
    }
}
