package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesempenoProducto extends JDialog implements ActionListener {

    private InterfazPrincipal principal;
    private int tipoDesempeno;

    private JLabel productoText;
    private JTextField codigoProducto;
    private JButton mostrarDesempeno;

    public DesempenoProducto(InterfazPrincipal Pprincipal, int PtipoDesempeno)
    {
        principal = Pprincipal;
        tipoDesempeno = PtipoDesempeno;
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3,1));
        if (tipoDesempeno == 1)
        {

        }
        else if(tipoDesempeno == 2)
        {

        }

        productoText = new JLabel("Codigo del producto");
        add(productoText);

        codigoProducto = new JTextField();
        add(codigoProducto);

        mostrarDesempeno = new JButton("Mostrar desempeño producto");
        add(mostrarDesempeno);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando =  e.getActionCommand();
    }
}
