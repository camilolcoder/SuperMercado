package Interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazInventario extends JFrame {

    private PanelOpcionesInventario panelPrincipalInventario;

    public InterfazInventario()
    {
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipalInventario = new PanelOpcionesInventario(this);
        add(panelPrincipalInventario, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
