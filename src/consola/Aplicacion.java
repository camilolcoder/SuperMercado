package consola;

import Modelo.Cliente;
import Procesamiento.PointOfSale;

import java.io.*;
import java.util.*;

public class Aplicacion {

    private PointOfSale pointOfSale;

    public void printMenuPrincipal()
    {
        System.out.println("1. Abrir sistema de point of sale");
        System.out.println("2. Abrir sitema de inventario");
    }

    public void printMenuPointOfSale()
    {
        System.out.println("");
        System.out.println("----MENU-POINT-OF-SALE------------");
        System.out.println("1. Crear nuevo cliente");
        System.out.println("2. Consultar lista de clientes");
        System.out.println("");
    }

    public void printMenuInventario()
    {
        System.out.println("1. Consultar lotes");
        System.out.println("2. Consulat otra cosa xd");
    }

    public void ejecutarAplicacion()
    {
        boolean continuar = true;
        while(continuar)
        {
            try
            {
                printMenuPrincipal();
                int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
                if (opcion_seleccionada == 1)
                    ejecutarAplicacionPointOfSale();
                else if (opcion_seleccionada == 2)
                    ejecutarAplicacionInventario();
                else if (opcion_seleccionada == 3)
                {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }

            }
            catch (NumberFormatException e)
            {
                System.out.println("Por favor seleccione uno de los " +
                        "numeros en el menu");
            }
        }
    }

    public void ejecutarAplicacionPointOfSale()
    {
        ArrayList<Cliente> clientes = new ArrayList<>();
        pointOfSale = new PointOfSale(clientes);
        boolean continuar = true;
        while(continuar) {
            try {
                printMenuPointOfSale();
                int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
                if (opcion_seleccionada == 1)
                {
                    ejecutarCrearCliente();
                }
                else if (opcion_seleccionada == 2)
                {
                    ejecutarObtenerDatosClientes();
                }
                else if (opcion_seleccionada == 3) {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor seleccione uno de los " +
                        "numeros en el menu");
            }
        }
    }

    public void ejecutarAplicacionInventario()
    {
        boolean continuar = true;
        while(continuar) {
            try {
                printMenuInventario();
                int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opcion"));
                if (opcion_seleccionada == 1)
                    System.out.print("");
                else if (opcion_seleccionada == 2)
                    System.out.print("");
                else if (opcion_seleccionada == 3) {
                    System.out.println("Saliendo apliacacion ....");
                    continuar = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor seleccione uno de los " +
                        "numeros en el menu");
            }
        }
    }

    public void ejecutarCrearCliente()
    {
        String nombre = input("Ingrese el nombre del cliente");
        int edad = Integer.parseInt(input("Ingrese la edad del cliente"));
        String sexo = input("Ingrese el sexo del cliente");
        String estadoCivil = input("Ingrese el estado civl del cliente");
        int id = Integer.parseInt(input("Ingrese la id del cliente"));
        String situacionLaboral = input("Ingrese la situacion laboral del cliente");
        //int puntos = input("Ingrese la id del cliente");
        pointOfSale.createClient(nombre, edad, sexo, estadoCivil, id, situacionLaboral);
        dataBase(nombre, edad, sexo, estadoCivil, id, situacionLaboral);

    }

    public void ejecutarObtenerDatosClientes()
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\clientes.csv";
        try(Scanner scanner = new Scanner(new File(filepath)))
        {
            scanner.useDelimiter(",");

            while (scanner.hasNext())
            {
                System.out.print(scanner.next() + "|");
            }
            scanner.close();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo el archivo de la base de datos");
            e.printStackTrace();
        }
    }

    public String input(String mensaje)
    {
        try
        {
            System.out.print(mensaje + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println("Error leyendo de la consola");
            e.printStackTrace();
        }
        return null;
    }

    public void dataBase(String nombre, int edad, String sexo, String estadoCivil, int id, String situacionLaboral)
    {
        String filepath = "C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\DataBase\\clientes.csv" ;
        String simpleFile = "clientes.csv";
        //File csvFile = new File(simpleFile);


        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Name").append(",").append("Age").append(",").append("Sex").append("\n");
        stringBuilder.append(nombre).append(",").append(edad).append(",").append(sexo).append(",").append(estadoCivil).append(",").append(id).append(",").append(situacionLaboral).append("\n");
        try (FileWriter fileWriter = new FileWriter(filepath, true)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Aplicacion aplicacion = new Aplicacion();
        aplicacion.ejecutarAplicacion();
    }
}
