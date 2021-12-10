package Interfaz.Inventario.Dialogs;

import Interfaz.InterfazPrincipal;
import Modelo.Producto;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VisaualizarVenta extends JDialog implements ActionListener {


    public static final String VISUALIZAR = "VISUALIZAR";

    private InterfazPrincipal principal;

    private JLabel codigoProductoText;
    private JTextField codigoProducto;
    private JLabel fechaInicialText;
    private JTextField fechaInicial;
    private JLabel fechaFinalText;
    private JTextField fechaFinal;
    private JLabel mostrarText;
    private JButton mostrar;

    public VisaualizarVenta(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setBackground(new Color(217, 217, 217));
        Border padding = BorderFactory.createEmptyBorder(0, 30, 0, 0);
        setVisible(true);
        setSize(400, 250);
        setTitle("Visualizar producto");
        setLocationRelativeTo(null);

        GridLayout gl = new GridLayout(4, 2);
        setLayout(gl);
        gl.setVgap(5);

        codigoProductoText = new JLabel("Ingrese codigo producto", SwingConstants.CENTER);
        codigoProductoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        codigoProductoText.setOpaque(true);
        codigoProductoText.setBackground(new Color(115, 115, 115));
        codigoProductoText.setForeground(Color.WHITE);
        add(codigoProductoText);

        Color coolGray = new Color(115, 115, 115);

        codigoProducto = new JTextField();
        codigoProducto.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(codigoProducto);

        fechaInicialText = new JLabel("Ingrese la fecha inicial", SwingConstants.CENTER);
        fechaInicialText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        fechaInicialText.setOpaque(true);
        fechaInicialText.setBackground(new Color(115, 115, 115));
        fechaInicialText.setForeground(Color.WHITE);
        add(fechaInicialText);

        fechaInicial = new JTextField();
        fechaInicial.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(fechaInicial);

        fechaFinalText = new JLabel("Ingrese la fecha final", SwingConstants.CENTER);
        fechaFinalText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        fechaFinalText.setOpaque(true);
        fechaFinalText.setBackground(new Color(115, 115, 115));
        fechaFinalText.setForeground(Color.WHITE);
        add(fechaFinalText);

        fechaFinal = new JTextField();
        fechaFinal.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(fechaFinal);

        mostrarText = new JLabel("Presione para", SwingConstants.CENTER);
        mostrarText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        mostrarText.setOpaque(true);
        mostrarText.setBackground(new Color(115, 115, 115));
        mostrarText.setForeground(Color.WHITE);
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
            JDialog dialogInfo = new JDialog();
            dialogInfo.setVisible(true);
            dialogInfo.setSize(700, 400);
            dialogInfo.setLocationRelativeTo(this);
            JPanel displayFactura = new JPanel();
            displayFactura.setVisible(true);
            GridLayout df = new GridLayout(1, 1);
            displayFactura.setLayout(df);

            List<Producto> productos = principal.getProductos();
            Producto producto = principal.getProducto(Integer.parseInt(codigoProducto.getText()), productos);
            List<List<String>> historialProductos = producto.getHistorialProductoLista();

            //System.out.println("WORKING");
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            int counter = 0;
            for (List<String> secciones : historialProductos)
            {
                if (principal.dentroDeRango(secciones.get(1)));
                {
                    System.out.println(secciones.get(0) + " " + secciones.get(1));
                    data.setValue(Double.parseDouble(secciones.get(0)), "Gastos", secciones.get(1) + "-" + String.valueOf(counter));
                    counter += 1;
                }
            }


            JFreeChart jchart = ChartFactory.createBarChart("Historial unidades vendidas de "+producto.getNombre(),
                    "Fecha", "Productos adquiridos", data, PlotOrientation.VERTICAL,
                    false, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);

            ChartPanel chartPanel = new ChartPanel(jchart);
            dialogInfo.add(chartPanel);
        }
    }
}
