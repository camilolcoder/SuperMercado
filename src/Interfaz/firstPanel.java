package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class firstPanel extends JPanel implements ActionListener {

    private InterfazPrincipal principal;

    public final static String POS = "POS";

    private JButton pointOfSale;
    private JButton inventario;

    public firstPanel(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setSize(100, 300);
        setLayout(new GridLayout(2, 1));
        pointOfSale = new JButton("Point of Sale");
        //pointOfSale.setBounds(500, 500, 400, 400);
        pointOfSale.setActionCommand(POS);
        pointOfSale.addActionListener(this);
        add(pointOfSale);

        inventario = new JButton("Inventario");
        pointOfSale.setBounds(100, 100, 250, 250);
        add(inventario);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals("POS"))
        {
            //JFrame jframe2 = new JFrame();
            InterfazPos jframe2 = new InterfazPos();
            jframe2.show();
            //jframe2.show();

            principal.dispose();
        }
    }
}
