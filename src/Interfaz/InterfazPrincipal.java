package Interfaz;

import javax.swing.*;
import java.awt.*;

public class InterfazPrincipal extends JFrame {

    private FirstPanel panelPrincipal;

    public InterfazPrincipal()
    {
        setTitle("LightsOut");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(178, 177, 185));
        //setLayout( new BorderLayout() );

        panelPrincipal = new FirstPanel(this);
        //panelPrincipal.setBounds(500, 500, 500, 500);
        //panelPrincipal.setSize(300, 300);
        //panelPrincipal.setOpaque(false);
        //panelPrincipal.setBackground(Color.BLUE);
        add(panelPrincipal, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
        //Posible solucion al problema de no poder regresar a la
        //interfaz pricipal seria crear un Interfaz con
        //constructor, de este modo si podriamos volver a esta
        //Y ponemos que esta interfaz solo tenga un boton
        //que seria como iniciar programa y yap
    }

    public static void main(String[] args)
    {
        InterfazPrincipal ventana = new InterfazPrincipal();
    }
}
