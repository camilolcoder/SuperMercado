package Interfaz;

import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Lote;
import Modelo.Producto;
import Procesamiento.LoaderInventario;
import Procesamiento.LoaderPointOfSale;
import Procesamiento.PointOfSale;
import consola.Aplicacion;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

//TODO añandir boton para manual de usuario

public class InterfazPrincipal extends JFrame {

    private Aplicacion aplicacion;

    private FirstPanel panelPrincipal;

    private JMenuBar barraMenu;

    private JMenu menuArchivo;

    private JMenuItem menuAbrir;

    private JMenuItem menuSalir;

    public InterfazPrincipal() throws IOException {
        aplicacion = new Aplicacion();
        aplicacion.ejecutarAplicacion();
        //aplicacion.ejecutarCargarPointOfSales();
        //aplicacion.ejecutarCargarInventario();
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        barraMenu = new JMenuBar();
        setJMenuBar(barraMenu);

        menuArchivo = new JMenu("Archivo");
        barraMenu.add(menuArchivo);

        // Setting the accelerator:
        menuAbrir = new JMenuItem("Abrir", KeyEvent.VK_A);
        menuAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        menuAbrir.setActionCommand(ListenerMenu.ABRIR_LIBROS);
        menuAbrir.addActionListener(new ListenerMenu(this));
        menuArchivo.add(menuAbrir);

        menuSalir = new JMenuItem("Salir", KeyEvent.VK_Q);
        menuSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        menuSalir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        menuArchivo.add(menuSalir);

        //getContentPane().setBackground(new Color(0, 0, 0));//178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipal = new FirstPanel(this);
        Border padding = BorderFactory.createEmptyBorder(30, 30, 30, 30);
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
                                      boolean empaquetado, String direccionImg)
    {
        aplicacion.ejecutarCrearProducto(nombre, precio, precioPorUnidad, unidadMedida, peso, categoria,
                tipo, empaquetado, direccionImg);
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

    public void ejecutarCrearCliente(String nombre, int edad, String sexo, String estadoCivil,
                                     int id, String situacionLaboral)
    {
        aplicacion.ejecutarCrearCliente(nombre, edad, sexo, estadoCivil, id, situacionLaboral);
    }

    public void ejecutarRegistarCompras()
    {
        aplicacion.ejecutarRegistrarCompras();
    }

    public List<Cliente> getClientes()
    {
        return aplicacion.getClientes();
    }

    public Producto getProducto(int codigo, List<Producto> productos)
    {
        return aplicacion.getProducto(codigo, productos);
    }

    public List<Producto> getProductos()
    {
        return aplicacion.getProductos();
    }

    public boolean chequerId(int idCliente)
    {
        return aplicacion.chequearId(idCliente);
    }

    public Factura ejecutarCrearFactura(List<Producto> productos, int idCliente)
    {
        return aplicacion.ejecutarCrearFactura(productos, idCliente);
    }

    public double calcularPuntosAcumulados(double total)
    {
        return aplicacion.calcularPuntosAcumulados(total);
    }

    public int buscarClientePorId(int idCliente)
    {
        return aplicacion.buscarClientePorId(idCliente);
    }

    public void updateDataLotes() throws IOException {
        aplicacion.updateDataLotes();
    }

    public void updateDataClientes() throws IOException {
        aplicacion.updateDataClientes();
    }

    public void updateLotesAfterCompra(List<Producto> productos, List<Double> pesos)
    {
        aplicacion.updateLotesAfterCompra(productos, pesos);
    }

    public void updateDataProductos() throws IOException {
        aplicacion.updateDataProductos();
    }

    public void asociarImagenProducto(String direccionImg)
    {
        aplicacion.asociarImagenProducto(direccionImg);
    }

    public static void main(String[] args) throws IOException {
        InterfazPrincipal ventana = new InterfazPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
