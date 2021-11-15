package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;

public class InterfazInventario extends JFrame {

    private PanelOpcionesInventario panelPrincipalInventario;
    private InterfazPrincipal principal;

    public InterfazInventario(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setTitle("Inventario");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipalInventario = new PanelOpcionesInventario(this, principal);
        add(panelPrincipalInventario, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
