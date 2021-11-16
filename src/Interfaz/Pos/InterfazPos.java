package Interfaz.Pos;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class InterfazPos extends JFrame {

    private InterfazPrincipal principal;
    private PanelOpcionesPos panelPrincipalPos;

    public InterfazPos(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipalPos = new PanelOpcionesPos(this, principal);
        Border padding = BorderFactory.createEmptyBorder(30, 30, 30, 30);
        panelPrincipalPos.setBorder(padding);
        add(panelPrincipalPos, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
