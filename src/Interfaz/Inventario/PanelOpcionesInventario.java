package Interfaz.Inventario;

import Interfaz.InterfazPos;
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

    public final static String CREARPRO = "CREARPRO";
    public final static String CREARCAT = "CREARCAT";
    public final static String MENUPRIN = "MENUPRIN";

    private JButton crearCategoria;
    private JButton crearProducto;
    private JButton crearLote;
    private JButton elimLoteEsp;
    private JButton mostrarLotesVencidos;
    private JButton menuPrincipal;

    public PanelOpcionesInventario(InterfazInventario PprincipalInventario)
    {
        principalInventario = PprincipalInventario;

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
        add(crearLote);

        elimLoteEsp = new JButton("Eliminar lote especifico");
        add(elimLoteEsp);

        mostrarLotesVencidos = new JButton("Mostrar lotes vencidos");
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
                categoria = new CrearCategoria();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JDialog dialog = new JDialog();
            dialog.setVisible(true);
            dialog.setSize(300, 180);
            dialog.setLocationRelativeTo(this);
            dialog.add(categoria);

        }
        else if (comando.equals("CREARPRO"))//CREAR PRODUCTO
        {
            CrearProducto producto = null;
            try {
                producto = new CrearProducto();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            JDialog dialog = new JDialog();
            dialog.setVisible(true);
            dialog.setSize(300, 300);
            dialog.setLocationRelativeTo(this);
            dialog.add(producto);
            /*int commandNum = producto.closeDialog();
            System.out.println(commandNum);
            if (commandNum == 1)
            {
                dialog.dispose();
                System.out.println(commandNum);
            }*/
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
