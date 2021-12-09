package Interfaz.Inventario.Dialogs;

import Interfaz.InterfazPrincipal;
import Modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AsociarImg extends JDialog implements ActionListener {

    public final static String ASOCIAR = "ASOCIAR";
    private InterfazPrincipal principal;

    private JLabel codigoProductoText;
    private JTextField codigoProducto;
    private JLabel direccionImgText;
    private JTextField direccionImg;
    private JLabel confirmarText;
    private JButton confirmar;

    public AsociarImg(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setVisible(true);
        setSize(400, 200);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(3, 2));
        codigoProductoText = new JLabel("Ingrese codigo del producto");
        add(codigoProductoText);

        codigoProducto = new JTextField();
        add(codigoProducto);

        direccionImgText = new JLabel("Ingrese la direccion de la Imagen");
        add(direccionImgText);

        direccionImg = new JTextField();
        add(direccionImg);

        confirmarText = new JLabel("Presione para: ");
        add(confirmarText);

        confirmar = new JButton("Confirmar");
        confirmar.setActionCommand("ASOCIAR");
        confirmar.addActionListener(this);
        add(confirmar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals("ASOCIAR"))
        {
            Producto productoAsociar =  principal.getProducto(Integer.parseInt(codigoProducto.getText()), principal.getProductos());
            //String direccionImg = productInfo.getDireccionImg();
            productoAsociar.setDireccionImg(direccionImg.getText());
            try {
                principal.updateDataProductos();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            dispose();
        }
    }
}
