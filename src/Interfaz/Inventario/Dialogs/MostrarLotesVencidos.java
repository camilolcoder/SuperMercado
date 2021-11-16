package Interfaz.Inventario.Dialogs;

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

        JPanel infoLotesVencidos = new JPanel();
        GridLayout gl = new GridLayout(120, 1);
        infoLotesVencidos.setLayout(gl);
        for (int i = 0; i < 100; i++)
        {
            infoLotesVencidos.add(new JLabel("Lote 2222|2344|323|134355|236466|productos pesados|informacion pesada"));
        }

        lotesVencidos = new JScrollPane(infoLotesVencidos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
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
