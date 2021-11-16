package Interfaz;

import Interfaz.Inventario.InterfazInventario;
import Interfaz.Pos.InterfazPos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends JPanel implements ActionListener {

    private InterfazPrincipal principal;

    public final static String POS = "POS";
    public final static String INVENTARIO = "INVENTARIO";

    private JButton pointOfSale;
    private JButton inventario;

    public FirstPanel(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setSize(100, 300);
        setBackground(new Color(217, 217, 217));

        GridLayout gl = new GridLayout(2, 1);
        gl.setHgap(10);
        gl.setVgap(30);

        setLayout(gl);//new GridLayout(2, 1));
        ImageIcon inventarioIcon = new ImageIcon("C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\Interfaz\\Diseno\\2test.jpg");
        ImageIcon posIcon = new ImageIcon("C:\\Users\\juank\\IdeaProjects\\SuperMercado\\src\\Interfaz\\Diseno\\posIcon.jpg");
        pointOfSale = new JButton("Point of Sale");
        //pointOfSale.setBounds(500, 500, 400, 400);
        pointOfSale.setBackground(new Color(115, 115, 115));
        //pointOfSale.setBorder(new RoundBtn(30));
        //int offset = pointOfSale.getInsets().left;
        //pointOfSale.setIcon(resizeIcon(inventarioIcon, pointOfSale.getWidth()-offset,
        //        pointOfSale.getHeight()-offset));
        pointOfSale.setIcon(posIcon);
        pointOfSale.setFont(new Font("Comic Sans", Font.BOLD, 25));
        pointOfSale.setForeground(Color.WHITE);
        pointOfSale.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        pointOfSale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pointOfSale.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                pointOfSale.setBackground(new Color(115, 115, 115));
            }
        });
        pointOfSale.setActionCommand(POS);
        pointOfSale.addActionListener(this);
        //pointOfSale.setBounds(100, 100, 250, 250);
        add(pointOfSale);

        inventario = new JButton("Inventario");
        inventario.setBackground(new Color(115, 115, 115));
        inventario.setActionCommand(INVENTARIO);
        inventario.setIcon(inventarioIcon);
        inventario.setFont(new Font("Comic Sans", Font.BOLD, 25));
        inventario.setForeground(Color.WHITE);
        inventario.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        inventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventario.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventario.setBackground(new Color(115, 115, 115));
            }
        });
        inventario.addActionListener(this);
        add(inventario);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String comando = e.getActionCommand();

        if (comando.equals("POS"))
        {
            //JFrame jframe2 = new JFrame();
            InterfazPos interfazPos = new InterfazPos();
            interfazPos.show();
            //jframe2.show();

            principal.dispose();
        }
        else if (comando.equals("INVENTARIO"))
        {
            InterfazInventario interfazInventario = new InterfazInventario(principal);
            interfazInventario.show();

            principal.dispose();
        }
    }
    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
}

