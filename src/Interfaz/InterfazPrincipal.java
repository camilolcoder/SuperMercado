package Interfaz;

import Modelo.Lote;
import Modelo.Producto;
import Procesamiento.LoaderInventario;
import Procesamiento.LoaderPointOfSale;
import Procesamiento.PointOfSale;
import consola.Aplicacion;

import javax.swing.*;
import javax.swing.border.Border;
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
        //getContentPane().setBackground(new Color(0, 0, 0));//178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipal = new FirstPanel(this);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panelPrincipal.setBorder(padding);
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

    public void ejecutarCrearLote(int id, String fechaEntrada, String fechaVencimiento, int codigoProducto,
                                  double precioPagado, double ventaPublico, int unidades,
                                  double peso)
    {
        aplicacion.ejecutarCrearLote(id, fechaEntrada, fechaVencimiento, codigoProducto, precioPagado,
                ventaPublico, unidades, peso);
    }

    public void ejecutarEliminarLotesVencidos() throws IOException {
        aplicacion.ejecutarEliminarLotesVencidos();
        aplicacion.updateDataLotes();
    }

    public List<String> ejecutarConsulatarPerformanceGeneral(int codigoProducto)
    {
        return aplicacion.ejecutarConsultarPerformanceGeneralProducto(codigoProducto);
    }

    public List<List<String>> ejecutarConsultarPerformanceInd(int codigoProducto)
    {
        return aplicacion.ejecutarConsultarPerformanceIndProducto(codigoProducto);
    }

    public List<Lote> ejecutarMostrarLotesVencidos()
    {
        return aplicacion.ejecutarMostrarLotesVencidos();
    }

    public void ejecutarEliminarLoteEspecifico(int id) throws IOException {
        aplicacion.ejecutarEliminarLoteEspecifico(id);
        aplicacion.updateDataLotes();
    }

    public void ejecutarCargarNuevosLotesCsv(String direccion) throws IOException {
        aplicacion.ejecutarCargarNuevosLotesCsv(direccion);
    }

    public static void main(String[] args) throws IOException {
        InterfazPrincipal ventana = new InterfazPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
