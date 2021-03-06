package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;
import Interfaz.Inventario.Dialogs.*;
import Interfaz.ListenerMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//DONE cada vez que se preciona el boton que abre el JDialog se cierra la interfaz de invetario,
// Eso es algo que puede llegar a ser molesto para el usuario

public class PanelOpcionesInventario extends JPanel implements ActionListener {

    private InterfazInventario principalInventario;
    private InterfazPrincipal principal;

    public final static String CREARPRO = "CREARPRO";
    public final static String CREARCAT = "CREARCAT";
    public final static String CREATLOT = "CREARLOT";
    public final static String ELIMLOTESP = "ELIMLOTESP";
    public final static String MOSTRARLOTS = "MOSTRARLOTS";
    public final static String ELIMTODO = "ELIMTODO";
    public final static String DESEMPGEN = "DESEMPGEN";
    public final static String DESEMPIND = "DESEMPIND";
    public final static String CARGARCSV = "CARGARCSV";
    public final static String ADDIMG = "ADDIMG";
    public final static String VENTAS = "VENTAS";
    public final static String MENUPRIN = "MENUPRIN";

    private JButton crearCategoria;
    private JButton crearProducto;
    private JButton crearLote;
    private JButton elimLoteEsp;
    private JButton mostrarLotesVencidos;
    private JButton eliminarTodosLosLotesVencidos;
    private JButton desempenoFinancieroGeneral;
    private JButton desempenoFinancieroInd;
    private JButton cargarCSV;
    private JButton asociarImagenProducto;
    private JButton visualizarVentasProducto;
    private JButton menuPrincipal;

    public PanelOpcionesInventario(InterfazInventario PprincipalInventario, InterfazPrincipal Pprincipal)
    {
        principalInventario = PprincipalInventario;
        principal = Pprincipal;
        //setSize(400, 500);
        setBackground(new Color(217, 217, 217));

        GridLayout gl = new GridLayout(6, 2);
        setLayout(gl);//new GridLayout(5, 2));
        gl.setHgap(15);
        gl.setVgap(15);

        crearCategoria = new JButton("Crear categoria");
        crearCategoria.setBackground(new Color(115, 115, 115));
        crearCategoria.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearCategoria.setForeground(Color.WHITE);
        crearCategoria.setActionCommand("CREARCAT");
        crearCategoria.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        crearCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearCategoria.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearCategoria.setBackground(new Color(115, 115, 115));
            }
        });
        crearCategoria.addActionListener(this);
        add(crearCategoria);

        crearProducto = new JButton("Crear producto");
        crearProducto.setBackground(new Color(115, 115, 115));
        crearProducto.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearProducto.setForeground(Color.WHITE);
        crearProducto.setActionCommand("CREARPRO");
        crearProducto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        crearProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearProducto.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearProducto.setBackground(new Color(115, 115, 115));
            }
        });
        crearProducto.addActionListener(this);
        add(crearProducto);

        crearLote = new JButton("Crear Lote");
        crearLote.setBackground(new Color(115, 115, 115));
        crearLote.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearLote.setForeground(Color.WHITE);
        crearLote.setActionCommand("CREARLOT");
        crearLote.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        crearLote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearLote.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearLote.setBackground(new Color(115, 115, 115));
            }
        });
        crearLote.addActionListener(this);
        add(crearLote);

        elimLoteEsp = new JButton("Eliminar lote especifico");
        elimLoteEsp.setBackground(new Color(115, 115, 115));
        elimLoteEsp.setFont(new Font("Comic Sans", Font.BOLD, 15));
        elimLoteEsp.setForeground(Color.WHITE);
        elimLoteEsp.setActionCommand("ELIMLOTESP");
        elimLoteEsp.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        elimLoteEsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                elimLoteEsp.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                elimLoteEsp.setBackground(new Color(115, 115, 115));
            }
        });
        elimLoteEsp.addActionListener(this);
        add(elimLoteEsp);

        mostrarLotesVencidos = new JButton("Mostrar lotes vencidos");
        mostrarLotesVencidos.setBackground(new Color(115, 115, 115));
        mostrarLotesVencidos.setFont(new Font("Comic Sans", Font.BOLD, 15));
        mostrarLotesVencidos.setForeground(Color.WHITE);
        mostrarLotesVencidos.setActionCommand("MOSTRARLOTS");
        mostrarLotesVencidos.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        mostrarLotesVencidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mostrarLotesVencidos.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mostrarLotesVencidos.setBackground(new Color(115, 115, 115));
            }
        });
        mostrarLotesVencidos.addActionListener(this);
        add(mostrarLotesVencidos);

        eliminarTodosLosLotesVencidos = new JButton("Eliminar lotes vencidos");
        eliminarTodosLosLotesVencidos.setBackground(new Color(115, 115, 115));
        eliminarTodosLosLotesVencidos.setFont(new Font("Comic Sans", Font.BOLD, 15));
        eliminarTodosLosLotesVencidos.setForeground(Color.WHITE);
        eliminarTodosLosLotesVencidos.setActionCommand("ELIMTODO");
        eliminarTodosLosLotesVencidos.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        eliminarTodosLosLotesVencidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarTodosLosLotesVencidos.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarTodosLosLotesVencidos.setBackground(new Color(115, 115, 115));
            }
        });
        eliminarTodosLosLotesVencidos.addActionListener(this);
        add(eliminarTodosLosLotesVencidos);

        desempenoFinancieroGeneral = new JButton("Desempeno financiero general");
        desempenoFinancieroGeneral.setBackground(new Color(115, 115, 115));
        desempenoFinancieroGeneral.setFont(new Font("Comic Sans", Font.BOLD, 15));
        desempenoFinancieroGeneral.setForeground(Color.WHITE);
        desempenoFinancieroGeneral.setActionCommand("DESEMPGEN");
        desempenoFinancieroGeneral.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        desempenoFinancieroGeneral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                desempenoFinancieroGeneral.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                desempenoFinancieroGeneral.setBackground(new Color(115, 115, 115));
            }
        });
        desempenoFinancieroGeneral.addActionListener(this);
        add(desempenoFinancieroGeneral);

        desempenoFinancieroInd = new JButton("Desempeno financiero individual");
        desempenoFinancieroInd.setBackground(new Color(115, 115, 115));
        desempenoFinancieroInd.setFont(new Font("Comic Sans", Font.BOLD, 15));
        desempenoFinancieroInd.setForeground(Color.WHITE);
        desempenoFinancieroInd.setActionCommand("DESEMPIND");
        desempenoFinancieroInd.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        desempenoFinancieroInd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                desempenoFinancieroInd.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                desempenoFinancieroInd.setBackground(new Color(115, 115, 115));
            }
        });
        desempenoFinancieroInd.addActionListener(this);
        add(desempenoFinancieroInd);

        asociarImagenProducto = new JButton("Asociar una imagen a un producto");
        asociarImagenProducto.setBackground(new Color(115, 115, 115));
        asociarImagenProducto.setFont(new Font("Comic Sans", Font.BOLD, 15));
        asociarImagenProducto.setForeground(Color.WHITE);
        asociarImagenProducto.setActionCommand("ADDIMG");
        asociarImagenProducto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        asociarImagenProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asociarImagenProducto.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                asociarImagenProducto.setBackground(new Color(115, 115, 115));
            }
        });
        asociarImagenProducto.addActionListener(this);
        add(asociarImagenProducto);

        visualizarVentasProducto = new JButton("Visualizar ventas producto");
        visualizarVentasProducto.setBackground(new Color(115, 115, 115));
        visualizarVentasProducto.setFont(new Font("Comic Sans", Font.BOLD, 15));
        visualizarVentasProducto.setForeground(Color.WHITE);
        visualizarVentasProducto.setActionCommand("VENTAS");
        visualizarVentasProducto.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        visualizarVentasProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                visualizarVentasProducto.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                visualizarVentasProducto.setBackground(new Color(115, 115, 115));
            }
        });
        visualizarVentasProducto.addActionListener(this);
        add(visualizarVentasProducto);

        cargarCSV = new JButton("Cargar Csv");
        cargarCSV.setBackground(new Color(115, 115, 115));
        cargarCSV.setFont(new Font("Comic Sans", Font.BOLD, 15));
        cargarCSV.setForeground(Color.WHITE);
        cargarCSV.setActionCommand("CARGARCSV");
        cargarCSV.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        cargarCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cargarCSV.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargarCSV.setBackground(new Color(115, 115, 115));
            }
        });
        cargarCSV.addActionListener(this);
        add(cargarCSV);

        menuPrincipal = new JButton("Volver al menu principal");
        menuPrincipal.setBackground(new Color(115, 115, 115));
        menuPrincipal.setFont(new Font("Comic Sans", Font.BOLD, 15));
        menuPrincipal.setForeground(Color.WHITE);
        menuPrincipal.setActionCommand("MENUPRIN");
        menuPrincipal.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        menuPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuPrincipal.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuPrincipal.setBackground(new Color(115, 115, 115));
            }
        });
        menuPrincipal.addActionListener(this);
        add(menuPrincipal);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        if (comando.equals("CREARCAT"))//CREAR CATEGORIA
        {
            CrearCategoria categoria = null;
            try {
                categoria = new CrearCategoria(principal);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        else if (comando.equals("CREARPRO"))//CREAR PRODUCTO
        {
            CrearProducto producto = null;
            try {
                producto = new CrearProducto(principal);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        else if (comando.equals("CREARLOT"))//CREAR LOTE
        {
            CrearLote lote = null;
            try {
                lote = new CrearLote(principal);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        else if (comando.equals("ELIMLOTESP"))
        {
            EliminarLoteEsp eliminarLoteEsp = null;
            eliminarLoteEsp = new EliminarLoteEsp(principal);

        }
        else if (comando.equals("MOSTRARLOTS"))
        {
            MostrarLotesVencidos mostrarLotesVencidos = null;
            mostrarLotesVencidos = new MostrarLotesVencidos(principal);
        }
        else if (comando.equals("ELIMTODO"))
        {
            int seguro = JOptionPane.showConfirmDialog(this,"Esta seguro de querer eliminar todos los lote?");
            if (seguro == JOptionPane.YES_OPTION)
            {
                try {
                    principal.ejecutarEliminarLotesVencidos();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else if (comando.equals("DESEMPGEN"))
        {
            DesempenoProducto desempenoProductoGen = null;
            desempenoProductoGen = new DesempenoProducto(principal, 1);
        }
        else if (comando.equals("DESEMPIND"))
        {
            DesempenoProducto desempenoProductoInd = null;
            desempenoProductoInd = new DesempenoProducto(principal, 2);
        }
        else if (comando.equals("ADDIMG"))
        {
            AsociarImg asociarImg = null;
            asociarImg = new AsociarImg(principal);
        }
        else if (comando.equals("VENTAS"))
        {
            VisaualizarVenta visualizarVenta = null;
            visualizarVenta = new VisaualizarVenta(principal);
        }
        else if (comando.equals("CARGARCSV"))
        {
            String direccion = JOptionPane.showInputDialog(this, "Ingrese la direccion del csv con nuevos lotes");
            try {
                //cargarCSV.setActionCommand(ListenerMenu.ABRIR_LIBROS);
                //cargarCSV.addActionListener(new ListenerMenu(this));
                principal.ejecutarCargarNuevosLotesCsv(direccion);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (comando.equals("MENUPRIN"))//BOTON DE SALIR
        {
            {
                try {
                    InterfazPrincipal Iprincipal = new InterfazPrincipal();
                    Iprincipal.show();
                    Iprincipal.setLocationRelativeTo(null);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                principalInventario.dispose();

                //System.out.println("WORKING 3!");
            }
        }
    }
}
