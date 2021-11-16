package Interfaz.Pos.DialogsP;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrarProductos  extends JDialog implements ActionListener {

    public static final String AGREGAR = "AGREGAR";
    public static final String FIN = "FIN";

    private InterfazPrincipal principal;

    private JLabel codigoProductoText;
    private JTextField codigoProducto;
    private JLabel agregarText;
    private JButton agregar;
    private JLabel idClienteText;
    private JTextField idCliente;
    private JLabel finalizarCompraText;
    private JButton finalizarCompra;

    public RegistrarProductos(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2));
        codigoProductoText = new JLabel("Codigo Producto");
        add(codigoProductoText);

        codigoProducto = new JTextField();
        add(codigoProducto);

        agregarText = new JLabel("Agregar");
        add(agregarText);

        agregar = new JButton("Agregar");
        add(agregar);

        idClienteText = new JLabel("Id Cliente");
        add(idClienteText);

        idCliente = new JTextField();
        add(idCliente);

        finalizarCompraText = new JLabel("Presione para ");
        add(finalizarCompraText);

        finalizarCompra = new JButton("Finalizar compra y mostrar total");
        finalizarCompra.setActionCommand("FIN");
        finalizarCompra.addActionListener(this);
        add(finalizarCompra);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("FIN"))
        {
            dispose();
        }
    }
}
