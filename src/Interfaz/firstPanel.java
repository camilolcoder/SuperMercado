package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class firstPanel extends JPanel implements ActionListener {

    private InterfazPrincipal principal;

    private JButton pointOfSale;
    private JButton inventario;

    public firstPanel(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setSize(100, 300);
        setLayout(new GridLayout(2, 1));
        pointOfSale = new JButton("Point of Sale");
        pointOfSale.setBounds(500, 500, 400, 400);
        add(pointOfSale);

        inventario = new JButton("Inventario");
        pointOfSale.setBounds(100, 100, 250, 250);
        add(inventario);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
