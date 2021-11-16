package Interfaz.Inventario.Dialogs;

import Interfaz.InterfazPrincipal;
import Modelo.Lote;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
        setSize(350, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1));
        lotesVencidosText = new JLabel("Lotes vencidos");
        add(lotesVencidosText);

        List<Lote> displayLotesVencidos = principal.ejecutarMostrarLotesVencidos();

        JPanel infoLotesVencidos = new JPanel();
        GridLayout gl = new GridLayout(displayLotesVencidos.size()*7, 1);
        infoLotesVencidos.setLayout(gl);

        infoLotesVencidos.add(new JLabel("LOTES VENCIDOS : "));

        for (Lote lote : displayLotesVencidos)
        {
            infoLotesVencidos.add(new JLabel("LOTE : "+lote.getId()));
            infoLotesVencidos.add(new JLabel("fecha entrada : "+lote.getFechaEntrada()));
            infoLotesVencidos.add(new JLabel("fecha vencimiento: "+lote.getFechaVencimiento()));
            infoLotesVencidos.add(new JLabel("Codigo producto : "+lote.getCodigoProducto()));
            infoLotesVencidos.add(new JLabel("Unidades : "+lote.getUnidades()));
            infoLotesVencidos.add(new JLabel(" "));
        }

        /*for (int i = 0; i < 100; i++)
        {
            infoLotesVencidos.add(new JLabel("Lote 2222|2344|323|134355|236466|productos pesados|informacion pesada"));
        }*/

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
