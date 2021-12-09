package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InterfazInventario extends JFrame {

    private PanelOpcionesInventario panelPrincipalInventario;
    private InterfazPrincipal principal;

    public InterfazInventario(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setTitle("Inventario");
        setSize(650, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipalInventario = new PanelOpcionesInventario(this, principal);
        Border padding = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        panelPrincipalInventario.setBorder(padding);
        add(panelPrincipalInventario);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
