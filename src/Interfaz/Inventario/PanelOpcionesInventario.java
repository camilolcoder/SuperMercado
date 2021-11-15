package Interfaz.Inventario;

import Interfaz.InterfazPos;
import Interfaz.InterfazPrincipal;
import Interfaz.Inventario.InterfazInventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

//TODO cada vez que se preciona el boton que abre el JDialog se cierra la interfaz de invetario,
// Eso es algo que puede llegar a ser molesto para el usuario

public class PanelOpcionesInventario extends JPanel implements ActionListener {

    private InterfazInventario principalInventario;
    private InterfazPrincipal principal;

    public final static String CREARPRO = "CREARPRO";
    public final static String CREARCAT = "CREARCAT";
    public final static String CREATLOT = "CREARLOT";
    public final static String ELIMLOTESP = "ELIMLOTESP";
    public final static String MOSTRARLOTS = "MOSTRARLOTS";
    public final static String MENUPRIN = "MENUPRIN";

    private JButton crearCategoria;
    private JButton crearProducto;
    private JButton crearLote;
    private JButton elimLoteEsp;
    private JButton mostrarLotesVencidos;
    private JButton menuPrincipal;

    public PanelOpcionesInventario(InterfazInventario PprincipalInventario, InterfazPrincipal Pprincipal)
    {
        principalInventario = PprincipalInventario;
        principal = Pprincipal;

        setLayout(new GridLayout(4, 2));
        crearCategoria = new JButton("Crear categoria");
        crearCategoria.setActionCommand("CREARCAT");
        crearCategoria.addActionListener(this);
        add(crearCategoria);

        crearProducto = new JButton("Crear producto");
        crearProducto.setActionCommand("CREARPRO");
        crearProducto.addActionListener(this);
        add(crearProducto);

        crearLote = new JButton("Crear Lote");
        crearLote.setActionCommand("CREARLOT");
        crearLote.addActionListener(this);
        add(crearLote);

        elimLoteEsp = new JButton("Eliminar lote especifico");
        elimLoteEsp.setActionCommand("ELIMLOTESP");
        elimLoteEsp.addActionListener(this);
        add(elimLoteEsp);

        mostrarLotesVencidos = new JButton("Mostrar lotes vencidos");
        mostrarLotesVencidos.setActionCommand("MOSTRARLOTS");
        mostrarLotesVencidos.addActionListener(this);
        add(mostrarLotesVencidos);

        menuPrincipal = new JButton("Volver al menu principal");
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
        else if (comando.equals("MENUPRIN"))//BOTON DE SALIR
        {
            /*System.out.println("MENU PRINCIPAL");
            InterfazPos principalPos = new InterfazPos();
            principalPos.show();
            principalInventario.dispose();*/
        }
    }
}
