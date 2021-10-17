package Procesamiento;

import Modelo.Cliente;
import Modelo.Lote;
import Modelo.Producto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoaderInventario {

    public static Inventario cargarArchivos() throws FileNotFoundException, IOException
    {
        String filepathProductos = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\productos.csv";

        List<Producto> productos = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filepathProductos));
        String linea = br.readLine();
        linea = br.readLine();
        while (linea != null)
        {
            String[] partes = linea.split(",");
            Producto producto = new Producto(partes[0], Double.parseDouble(partes[1]), Double.parseDouble(partes[2]),
                    partes[3], Double.parseDouble(partes[4]), partes[5], partes[6]);
            producto.setCodigo(Integer.parseInt(partes[7]));
            productos.add(producto);
            linea = br.readLine();

        }
        br.close();
        //----------------------------------------------------------------------------------------
        String filepathLotes = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\lotes.csv";

        List<Lote> lotes = new ArrayList<>();
        BufferedReader brl = new BufferedReader(new FileReader(filepathLotes));
        String lineal = brl.readLine();
        lineal = brl.readLine();
        while (lineal != null)
        {
            String[] partesl = lineal.split(",");
            Lote lote = new Lote(Integer.parseInt(partesl[0]), partesl[1], partesl[2],
                    Integer.parseInt(partesl[3]), Double.parseDouble(partesl[4]), Double.parseDouble(partesl[5]),
                    Integer.parseInt(partesl[6]));
                    lote.setUnidadesVendidas(Integer.parseInt(partesl[7]));
            lotes.add(lote);
            lineal = brl.readLine();

        }
        brl.close();

        Inventario inventario = new Inventario(productos, lotes);
        return inventario;
    }

}
