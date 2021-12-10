package Interfaz.Inventario.Dialogs;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisaualizarVenta extends JDialog implements ActionListener {


    public static final String VISUALIZAR = "VISUALIZAR";

    private InterfazPrincipal principal;

    private JLabel codigoProductoText;
    private JTextField codigoProducto;
    private JLabel mostrarText;
    private JButton mostrar;

    public VisaualizarVenta(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setBackground(new Color(217, 217, 217));
        Border padding = BorderFactory.createEmptyBorder(0, 30, 0, 0);
        setVisible(true);
        setSize(300, 200);
        setTitle("Visualizar producto");
        setLocationRelativeTo(null);

        codigoProductoText = new JLabel("Ingrese codigo producto");
        codigoProductoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        codigoProductoText.setOpaque(true);
        codigoProductoText.setBackground(new Color(115, 115, 115));
        codigoProductoText.setForeground(Color.WHITE);
        add(codigoProducto);

        Color coolGray = new Color(115, 115, 115);

        codigoProducto = new JTextField();
        codigoProducto.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(codigoProducto);

        mostrarText = new JLabel("Presione para");
        codigoProductoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        codigoProductoText.setOpaque(true);
        codigoProductoText.setBackground(new Color(115, 115, 115));
        codigoProductoText.setForeground(Color.WHITE);
        add(mostrarText);

        mostrar = new JButton("Visualizar ventas");
        mostrar.setActionCommand("VISUALIZAR");
        mostrar.setBackground(new Color(115, 115, 115));
        mostrar.setFont(new Font("Comic Sans", Font.BOLD, 15));
        mostrar.setForeground(Color.WHITE);
        mostrar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        mostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mostrar.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mostrar.setBackground(new Color(115, 115, 115));
            }
        });
        mostrar.addActionListener(this);
        add(mostrar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("VISUALIZAR"))
        {
            System.out.println("WORKING");
        }
    }
}
