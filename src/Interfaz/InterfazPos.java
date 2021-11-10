package Interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazPos extends JFrame {

    public InterfazPos()
    {
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(0, 177, 185));
        //setLayout( new BorderLayout() );
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
