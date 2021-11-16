package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;
import Interfaz.Inventario.Dialogs.*;

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
    private JButton menuPrincipal;

    public PanelOpcionesInventario(InterfazInventario PprincipalInventario, InterfazPrincipal Pprincipal)
    {
        principalInventario = PprincipalInventario;
        principal = Pprincipal;
        //setSize(400, 400);
        setBackground(new Color(217, 217, 217));

        GridLayout gl = new GridLayout(5, 2);
        setLayout(gl);//new GridLayout(5, 2));
        gl.setHgap(15);
        gl.setVgap(15);

        crearCategoria = new JButton("Crear categoria");
        crearCategoria.setBackground(new Color(115, 115, 115));
        crearCategoria.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearCategoria.setForeground(Color.WHITE);
        crearCategoria.setActionCommand("CREARCAT");
        crearCategoria.addActionListener(this);
        add(crearCategoria);

        crearProducto = new JButton("Crear producto");
        crearProducto.setBackground(new Color(115, 115, 115));
        crearProducto.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearProducto.setForeground(Color.WHITE);
        crearProducto.setActionCommand("CREARPRO");
        crearProducto.addActionListener(this);
        add(crearProducto);

        crearLote = new JButton("Crear Lote");
        crearLote.setBackground(new Color(115, 115, 115));
        crearLote.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearLote.setForeground(Color.WHITE);
        crearLote.setActionCommand("CREARLOT");
        crearLote.addActionListener(this);
        add(crearLote);

        elimLoteEsp = new JButton("Eliminar lote especifico");
        elimLoteEsp.setBackground(new Color(115, 115, 115));
        elimLoteEsp.setFont(new Font("Comic Sans", Font.BOLD, 15));
        elimLoteEsp.setForeground(Color.WHITE);
        elimLoteEsp.setActionCommand("ELIMLOTESP");
        elimLoteEsp.addActionListener(this);
        add(elimLoteEsp);

        mostrarLotesVencidos = new JButton("Mostrar lotes vencidos");
        mostrarLotesVencidos.setBackground(new Color(115, 115, 115));
        mostrarLotesVencidos.setFont(new Font("Comic Sans", Font.BOLD, 15));
        mostrarLotesVencidos.setForeground(Color.WHITE);
        mostrarLotesVencidos.setActionCommand("MOSTRARLOTS");
        mostrarLotesVencidos.addActionListener(this);
        add(mostrarLotesVencidos);

        eliminarTodosLosLotesVencidos = new JButton("Eliminar lotes vencidos");
        eliminarTodosLosLotesVencidos.setBackground(new Color(115, 115, 115));
        eliminarTodosLosLotesVencidos.setFont(new Font("Comic Sans", Font.BOLD, 15));
        eliminarTodosLosLotesVencidos.setForeground(Color.WHITE);
        eliminarTodosLosLotesVencidos.setActionCommand("ELIMTODO");
        eliminarTodosLosLotesVencidos.addActionListener(this);
        add(eliminarTodosLosLotesVencidos);

        desempenoFinancieroGeneral = new JButton("Desempeno financiero general");
        desempenoFinancieroGeneral.setBackground(new Color(115, 115, 115));
        desempenoFinancieroGeneral.setFont(new Font("Comic Sans", Font.BOLD, 15));
        desempenoFinancieroGeneral.setForeground(Color.WHITE);
        desempenoFinancieroGeneral.setActionCommand("DESEMPGEN");
        desempenoFinancieroGeneral.addActionListener(this);
        add(desempenoFinancieroGeneral);

        desempenoFinancieroInd = new JButton("Desempeno financiero individual");
        desempenoFinancieroInd.setBackground(new Color(115, 115, 115));
        desempenoFinancieroInd.setFont(new Font("Comic Sans", Font.BOLD, 15));
        desempenoFinancieroInd.setForeground(Color.WHITE);
        desempenoFinancieroInd.setActionCommand("DESEMPIND");
        desempenoFinancieroInd.addActionListener(this);
        add(desempenoFinancieroInd);

        cargarCSV = new JButton("Cargar Csv");
        cargarCSV.setBackground(new Color(115, 115, 115));
        cargarCSV.setFont(new Font("Comic Sans", Font.BOLD, 15));
        cargarCSV.setForeground(Color.WHITE);
        cargarCSV.setActionCommand("CARGARCSV");
        cargarCSV.addActionListener(this);
        add(cargarCSV);

        menuPrincipal = new JButton("Volver al menu principal");
        menuPrincipal.setBackground(new Color(115, 115, 115));
        menuPrincipal.setFont(new Font("Comic Sans", Font.BOLD, 15));
        menuPrincipal.setForeground(Color.WHITE);
        menuPrincipal.setActionCommand("MENUPRIN");
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
        else if (comando.equals("CARGARCSV"))
        {
            String direccion = JOptionPane.showInputDialog(this, "Ingrese la direccion del csv con nuevos lotes");
            try {
                principal.ejecutarCargarNuevosLotesCsv(direccion);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (comando.equals("MENUPRIN"))//BOTON DE SALIR
        {
            /*System.out.println("MENU PRINCIPAL");
            InterfazPos principalPos = new InterfazPos();
            principalPos.show();
            principalInventario.dispose();*/
        }
    }
}
