package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpcionesInventario extends JPanel implements ActionListener {

    private InterfazInventario principalInventario;

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
        add(crearCategoria);

        crearProducto = new JButton("Crear producto");
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
        if (comando.equals("MENUPRIN"))
        {
            System.out.println("MENU PRINCIPAL");
            InterfazPos principalPos = new InterfazPos();
            principalPos.show();
            principalInventario.dispose();
        }
    }
}
