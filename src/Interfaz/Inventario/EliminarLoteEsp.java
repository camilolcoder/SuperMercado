package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarLoteEsp extends JDialog implements ActionListener {

    public final static String ELIMINARLOT = "ELIMINARLOT";
    private InterfazPrincipal principal;

    private JLabel idLoteText;
    private JTextField idLote;
    private JLabel eliminarLoteText;
    private JButton eliminarLote;

    public EliminarLoteEsp(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setVisible(true);
        setSize(300, 100);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(2, 2));
        idLoteText = new JLabel("Id Lote");
        add(idLoteText);

        idLote = new JTextField();
        add(idLote);

        eliminarLoteText = new JLabel("Presione para: ");
        add(eliminarLoteText);

        eliminarLote = new JButton("Eliminar Lote");
        eliminarLote.setActionCommand("ELIMINARLOT");
        eliminarLote.addActionListener(this);
        add(eliminarLote);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("ELIMINARLOT"))
        {

            dispose();
        }
    }
}
