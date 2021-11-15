package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarLotesVencidos extends JDialog implements ActionListener {

    public final static String SALIR = "SALIR";
    private InterfazPrincipal principal;

    private JLabel lotesVencidosText;
    private JScrollPane lotesVencidos;
    private JButton cerrarDialog;

    public MostrarLotesVencidos(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));
        lotesVencidosText = new JLabel("Lotes vencidos");
        add(lotesVencidosText);

        lotesVencidos = new JScrollPane();
        add(lotesVencidos);

        cerrarDialog = new JButton("Cerrar");
        cerrarDialog.setActionCommand("SALIR");
        cerrarDialog.addActionListener(this);
        add(cerrarDialog);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("SALIR"))
        {
            dispose();
        }
    }
}
