package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpcionesPos extends JPanel implements ActionListener {

    private InterfazPos principalPos;

    public final static String CREATECLIENT = "CREATECLIENT";
    public final static String CANJEO = "CANJEO";
    public final static String SALIR = "SALIR";

    private JButton createClient;
    private JButton canjearCompras;
    private JButton salir;

    public PanelOpcionesPos(InterfazPos PprincipalPos)
    {
        principalPos = PprincipalPos;
        setLayout(new GridLayout(3, 1));

        createClient = new JButton("Crear cliente");
        createClient.setActionCommand("CREATECLIENT");
        createClient.addActionListener(this);
        add(createClient);

        canjearCompras = new JButton("Canjear compras");
        canjearCompras.setActionCommand("CANJEO");
        canjearCompras.addActionListener(this);
        add(canjearCompras);

        salir = new JButton("Salir");
        salir.setActionCommand("SALIR");
        salir.addActionListener(this);
        add(salir);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        if (comando.equals("CREATECLIENT"))
        {
            System.out.println("WORKING BRO");
        }
        else if (comando.equals("CANJEO"))
        {
            System.out.println("WORKING 2!");
        }
        else if (comando.equals("SALIR"))
        {
            System.out.println("WORKING 3!");
        }
    }
}
