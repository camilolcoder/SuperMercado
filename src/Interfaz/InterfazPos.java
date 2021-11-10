package Interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazPos extends JFrame {

    private PanelOpcionesPos panelPrincipalPos;

    public InterfazPos()
    {
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipalPos = new PanelOpcionesPos(this);
        add(panelPrincipalPos, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
