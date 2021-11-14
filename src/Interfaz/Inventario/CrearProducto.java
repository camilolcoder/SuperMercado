package Interfaz.Inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProducto extends JPanel implements ActionListener {

    private JLabel nombreProductoText;
    private JTextField nombreProducto;
    private JButton crearCliente;

    public CrearProducto()
    {
        setLayout(new GridLayout(2, 2));
        nombreProductoText = new JLabel("Nombre producto");
        add(nombreProductoText);

        nombreProducto = new JTextField();
        add(nombreProducto);

        crearCliente = new JButton("Crear cliente");
        add(crearCliente);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
