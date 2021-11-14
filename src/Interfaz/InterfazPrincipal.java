package Interfaz;

import Procesamiento.LoaderInventario;
import Procesamiento.LoaderPointOfSale;
import Procesamiento.PointOfSale;
import consola.Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class InterfazPrincipal extends JFrame {

    private Aplicacion aplicacion;

    private FirstPanel panelPrincipal;

    public InterfazPrincipal() throws IOException {
        aplicacion = new Aplicacion();
        aplicacion.ejecutarCargarPointOfSales();
        aplicacion.ejecutarCargarInventario();
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipal = new FirstPanel(this);
        //panelPrincipal.setBounds(500, 500, 500, 500);
        //panelPrincipal.setSize(300, 300);
        //panelPrincipal.setOpaque(false);
        //panelPrincipal.setBackground(Color.BLUE);
        add(panelPrincipal, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
        //Posible solucion al problema de no poder regresar a la
        //interfaz pricipal seria crear un Interfaz con
        //constructor, de este modo si podriamos volver a esta
        //Y ponemos que esta interfaz solo tenga un boton
        //que seria como iniciar programa y yap
    }

    public void ejecutarCrearProducto(String nombre, double precio, double precioPorUnidad,
                                      String unidadMedida, double peso, String categoria, String tipo,
                                      boolean empaquetado)
    {
        aplicacion.ejecutarCrearProducto(nombre, precio, precioPorUnidad, unidadMedida, peso, categoria,
                tipo, empaquetado);
    }


    // Estas dos funciones permiten cargar los archivos de las
    // bases de datos
    /*public void ejecutarCargarPointOfSales() throws IOException {
        pointOfSale = LoaderPointOfSale.cargarArchivos();
    }

    public void ejecutarCargarInventario() throws IOException {
        inventario = LoaderInventario.cargarArchivos();
    }*/

    public static void main(String[] args) throws IOException {
        InterfazPrincipal ventana = new InterfazPrincipal();
    }
}
