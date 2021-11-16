package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DesempenoProducto extends JDialog implements ActionListener {

    public final static String OP1 = "OP1";

    private InterfazPrincipal principal;
    private int tipoDesempeno;

    private JLabel productoText;
    private JTextField codigoProducto;
    private JButton mostrarDesempeno;

    public DesempenoProducto(InterfazPrincipal Pprincipal, int PtipoDesempeno)
    {
        principal = Pprincipal;
        tipoDesempeno = PtipoDesempeno;
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4,1));

        productoText = new JLabel("Codigo del producto");
        add(productoText);

        codigoProducto = new JTextField();
        add(codigoProducto);

        mostrarDesempeno = new JButton("Mostrar desempeño producto");
        mostrarDesempeno.setActionCommand("OP1");
        mostrarDesempeno.addActionListener(this);
        add(mostrarDesempeno);

        /*if (tipoDesempeno == 1)
        {
            JPanel displayPerformance = new JPanel();
            GridLayout gl = new GridLayout(3, 1);
            displayPerformance.setLayout(gl);
            List<String> performanceData = principal.ejecutarConsulatarPerformanceGeneral(Integer.parseInt(codigoProducto.getText()));
            displayPerformance.add(new JLabel("Ganancias : "+performanceData.get(0)));
            displayPerformance.add(new JLabel("Retorno de inversión : "+performanceData.get(1)));
            displayPerformance.add(new JLabel("Punto de equilibrio : "+performanceData.get(2)));
            add(displayPerformance);
        }
        else if(tipoDesempeno == 2)
        {

        }*/

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando =  e.getActionCommand();
        if (comando.equals("OP1"))
        {
            if (tipoDesempeno == 1)
            {
                JDialog dialog = new JDialog();
                dialog.setVisible(true);
                dialog.setSize(350, 100);
                dialog.setLocationRelativeTo(this);
                JPanel displayPerformance = new JPanel();
                displayPerformance.setVisible(true);
                GridLayout gl = new GridLayout(3, 1);
                displayPerformance.setLayout(gl);
                List<String> performanceData = principal.ejecutarConsulatarPerformanceGeneral(Integer.parseInt(codigoProducto.getText()));
                displayPerformance.add(new JLabel("Ganancias : " + performanceData.get(0)));
                displayPerformance.add(new JLabel("Retorno de inversión : " + performanceData.get(1) + " %"));
                displayPerformance.add(new JLabel("Punto de equilibrio : " + performanceData.get(2)));
                //add(displayPerformance);
                dialog.add(displayPerformance);
                dispose();
            }
            else if(tipoDesempeno == 2)
            {
                dispose();
            }
        }
    }
}
