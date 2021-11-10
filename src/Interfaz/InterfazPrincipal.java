package Interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazPrincipal extends JFrame {

    private firstPanel panelPrincipal;

    public InterfazPrincipal()
    {
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipal = new firstPanel(this);
        //panelPrincipal.setBounds(500, 500, 500, 500);
        //panelPrincipal.setSize(300, 300);
        //panelPrincipal.setOpaque(false);
        //panelPrincipal.setBackground(Color.BLUE);
        add(panelPrincipal, BorderLayout.CENTER);
    }

    public static void main(String[] args)
    {
        InterfazPrincipal ventana = new InterfazPrincipal();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
