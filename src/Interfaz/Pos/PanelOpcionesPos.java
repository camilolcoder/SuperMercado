package Interfaz.Pos;

import Interfaz.InterfazPrincipal;
import Interfaz.Pos.DialogsP.CrearCliente;
import Interfaz.Pos.DialogsP.RegistrarProductos;
import Interfaz.Pos.InterfazPos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class PanelOpcionesPos extends JPanel implements ActionListener {

    private InterfazPrincipal principal;
    private InterfazPos principalPos;

    public final static String CREATECLIENT = "CREATECLIENT";
    public final static String CANJEO = "CANJEO";
    public final static String SALIR = "SALIR";

    private JButton createClient;
    private JButton canjearCompras;
    private JButton salir;

    public PanelOpcionesPos(InterfazPos PprincipalPos, InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        principalPos = PprincipalPos;
        setBackground(new Color(217, 217, 217));

        GridLayout gl = new GridLayout(3, 1);
        setLayout(gl);//new GridLayout(5, 2));
        gl.setHgap(15);
        gl.setVgap(15);
        //setLayout(new GridLayout(3, 1));

        createClient = new JButton("Crear cliente");
        createClient.setActionCommand("CREATECLIENT");
        createClient.setBackground(new Color(115, 115, 115));
        createClient.setFont(new Font("Comic Sans", Font.BOLD, 25));
        createClient.setForeground(Color.WHITE);
        createClient.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        createClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createClient.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                createClient.setBackground(new Color(115, 115, 115));
            }
        });
        createClient.addActionListener(this);
        add(createClient);

        canjearCompras = new JButton("Canjear compras");
        canjearCompras.setActionCommand("CANJEO");
        canjearCompras.setBackground(new Color(115, 115, 115));
        canjearCompras.setFont(new Font("Comic Sans", Font.BOLD, 25));
        canjearCompras.setForeground(Color.WHITE);
        canjearCompras.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        canjearCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                canjearCompras.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                canjearCompras.setBackground(new Color(115, 115, 115));
            }
        });
        canjearCompras.addActionListener(this);
        add(canjearCompras);

        salir = new JButton("Salir");
        salir.setActionCommand("SALIR");
        salir.setBackground(new Color(115, 115, 115));
        salir.setFont(new Font("Comic Sans", Font.BOLD, 25));
        salir.setForeground(Color.WHITE);
        salir.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salir.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                salir.setBackground(new Color(115, 115, 115));
            }
        });
        salir.addActionListener(this);
        add(salir);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();
        if (comando.equals("CREATECLIENT"))
        {
            CrearCliente cliente = null;
            cliente = new CrearCliente(principal);
            //System.out.println("WORKING BRO");
        }
        else if (comando.equals("CANJEO"))
        {
            RegistrarProductos registrarProductos = null;
            registrarProductos = new RegistrarProductos(principal);
            //System.out.println("WORKING 2!");
        }
        else if (comando.equals("SALIR"))
        {
            try {
                InterfazPrincipal Iprincipal = new InterfazPrincipal();
                Iprincipal.show();
                Iprincipal.setLocationRelativeTo(null);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            principalPos.dispose();

            //System.out.println("WORKING 3!");
        }
    }
}
