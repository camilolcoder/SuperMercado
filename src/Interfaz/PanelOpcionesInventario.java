package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpcionesInventario extends JPanel implements ActionListener {

    private InterfazInventario principalInventario;

    private JButton crearCategoria;
    private JButton crearProducto;
    private JButton crearLote;
    private JButton elimLoteEsp;
    private JButton mostrarLotesVencidos;

    public PanelOpcionesInventario(InterfazInventario PprincipalInventario)
    {
        principalInventario = PprincipalInventario;

        setLayout(new GridLayout(5, 1));
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
