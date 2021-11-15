package Interfaz;

import Modelo.Producto;
import Procesamiento.LoaderInventario;
import Procesamiento.LoaderPointOfSale;
import Procesamiento.PointOfSale;
import consola.Aplicacion;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class InterfazPrincipal extends JFrame {

    private Aplicacion aplicacion;

    private FirstPanel panelPrincipal;

    public InterfazPrincipal() throws IOException {
        aplicacion = new Aplicacion();
        aplicacion.ejecutarAplicacion();
        //aplicacion.ejecutarCargarPointOfSales();
        //aplicacion.ejecutarCargarInventario();
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

    public void ejecutarCrearCategoria(String categoria)
    {
        aplicacion.ejecutarCrearCategoria(categoria);
    }

    public String[] obtenerCategorias() throws IOException {
        return aplicacion.ejecutarObtenerCategorias();
    }

    public void updateCodigo()
    {
        aplicacion.updateCodigo();
    }

    public static void main(String[] args) throws IOException {
        InterfazPrincipal ventana = new InterfazPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
