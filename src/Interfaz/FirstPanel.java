package Interfaz;

import Interfaz.Inventario.InterfazInventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends JPanel implements ActionListener {

    private InterfazPrincipal principal;

    public final static String POS = "POS";
    public final static String INVENTARIO = "INVENTARIO";

    private JButton pointOfSale;
    private JButton inventario;

    public FirstPanel(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setSize(100, 300);
        setLayout(new GridLayout(2, 1));
        pointOfSale = new JButton("Point of Sale");
        //pointOfSale.setBounds(500, 500, 400, 400);
        pointOfSale.setActionCommand(POS);
        pointOfSale.addActionListener(this);
        //pointOfSale.setBounds(100, 100, 250, 250);
        add(pointOfSale);

        inventario = new JButton("Inventario");
        inventario.setActionCommand(INVENTARIO);
        inventario.addActionListener(this);
        add(inventario);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals("POS"))
        {
            //JFrame jframe2 = new JFrame();
            InterfazPos interfazPos = new InterfazPos();
            interfazPos.show();
            //jframe2.show();

            principal.dispose();
        }
        else if (comando.equals("INVENTARIO"))
        {
            InterfazInventario interfazInventario = new InterfazInventario(principal);
            interfazInventario.show();

            principal.dispose();
        }
    }
}

