package Interfaz.Pos.DialogsP;

import Interfaz.InterfazPrincipal;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
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
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistrarProductos  extends JDialog implements ActionListener {

    public static final String INFO = "INFO";
    public static  final String PESO = "PESO";
    public static final String AGREGAR = "AGREGAR";
    public static final String FIN = "FIN";

    private InterfazPrincipal principal;

    private List<Producto> productosCliente;// = new ArrayList<>();
    private List<Double> pesosNoEmpaquetado;// = new ArrayList<>();
    private List<Cliente> clientesRegistrados;// = principal.getClientes();

    private JLabel codigoProductoText;
    private JTextField codigoProducto;
    private JLabel mostrarImgText;
    private JButton mostrarImg;
    private JLabel infoProductoText;
    private JLabel productoImg;
    private JLabel agregarText;
    private JButton agregar;
    private JLabel idClienteText;
    private JTextField idCliente;
    private JLabel infoClienteText;
    private JButton infoCliente;
    private JLabel finalizarCompraText;
    private JButton finalizarCompra;

    public RegistrarProductos(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;

        productosCliente = new ArrayList<>();
        pesosNoEmpaquetado = new ArrayList<>();
        clientesRegistrados = principal.getClientes();

        setBackground(new Color(217, 217, 217));
        Border padding = BorderFactory.createEmptyBorder(0, 30, 0, 0);
        setVisible(true);
        setSize(400, 350);
        setTitle("Canjear compras");
        setLocationRelativeTo(null);

        //setLayout(new GridLayout(4, 2));
        GridLayout gl = new GridLayout(7, 2);
        setLayout(gl);//new GridLayout(5, 2));
        gl.setHgap(1);
        gl.setVgap(5);
        codigoProductoText = new JLabel("Codigo Producto", SwingConstants.CENTER);
        codigoProductoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        codigoProductoText.setOpaque(true);
        codigoProductoText.setBackground(new Color(115, 115, 115));
        codigoProductoText.setForeground(Color.WHITE);
        //codigoProductoText.setBorder(padding);
        add(codigoProductoText);

        Color coolGray = new Color(115, 115, 115);

        codigoProducto = new JTextField();
        codigoProducto.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(codigoProducto);

        mostrarImgText = new JLabel("Presione para: ", SwingConstants.CENTER);
        mostrarImgText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        mostrarImgText.setOpaque(true);
        mostrarImgText.setBackground(new Color(115, 115, 115));
        mostrarImgText.setForeground(Color.WHITE);
        add(mostrarImgText);

        mostrarImg = new JButton("Mostrar img del producto");
        mostrarImg.setActionCommand("MOSTRARIMG");
        mostrarImg.setBackground(new Color(115, 115, 115));
        mostrarImg.setFont(new Font("Comic Sans", Font.BOLD, 15));
        mostrarImg.setForeground(Color.WHITE);
        mostrarImg.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        mostrarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mostrarImg.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mostrarImg.setBackground(new Color(115, 115, 115));
            }
        });
        mostrarImg.addActionListener(this);
        add(mostrarImg);

        infoProductoText = new JLabel("Imagen Producto", SwingConstants.CENTER);
        infoProductoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        infoProductoText.setOpaque(true);
        infoProductoText.setBackground(new Color(115, 115, 115));
        infoProductoText.setForeground(Color.WHITE);
        add(infoProductoText);

        productoImg = new JLabel();
        productoImg.setBackground(new Color(115, 115, 115));
        //ImageIcon imgPro = new ImageIcon(direccion);
        add(productoImg);

        agregarText = new JLabel("Agregar Producto", SwingConstants.CENTER);
        agregarText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        agregarText.setOpaque(true);
        agregarText.setBackground(new Color(115, 115, 115));
        agregarText.setForeground(Color.WHITE);
        add(agregarText);

        agregar = new JButton("Agregar");
        agregar.setActionCommand("AGREGAR");
        agregar.setBackground(new Color(115, 115, 115));
        agregar.setFont(new Font("Comic Sans", Font.BOLD, 15));
        agregar.setForeground(Color.WHITE);
        agregar.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregar.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregar.setBackground(new Color(115, 115, 115));
            }
        });
        agregar.addActionListener(this);
        add(agregar);

        idClienteText = new JLabel("Id Cliente", SwingConstants.CENTER);
        idClienteText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        idClienteText.setOpaque(true);
        idClienteText.setBackground(new Color(115, 115, 115));
        idClienteText.setForeground(Color.WHITE);
        add(idClienteText);

        idCliente = new JTextField();
        idCliente.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(idCliente);

        infoClienteText = new JLabel("Informacion cliente", SwingConstants.CENTER);
        infoClienteText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        infoClienteText.setOpaque(true);
        infoClienteText.setBackground(new Color(115, 115, 115));
        infoClienteText.setForeground(Color.WHITE);
        add(infoClienteText);

        infoCliente = new JButton("Obtener informacion");
        infoCliente.setActionCommand("INFO");
        infoCliente.setBackground(new Color(115, 115, 115));
        infoCliente.setFont(new Font("Comic Sans", Font.BOLD, 15));
        infoCliente.setForeground(Color.WHITE);
        infoCliente.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        infoCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                infoCliente.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                infoCliente.setBackground(new Color(115, 115, 115));
            }
        });
        infoCliente.addActionListener(this);
        add(infoCliente);

        finalizarCompraText = new JLabel("Presione para ", SwingConstants.CENTER);
        finalizarCompraText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        finalizarCompraText.setOpaque(true);
        finalizarCompraText.setBackground(new Color(115, 115, 115));
        finalizarCompraText.setForeground(Color.WHITE);
        add(finalizarCompraText);

        finalizarCompra = new JButton("<html>Finalizar compra<br />y mostrar total</html>");
        finalizarCompra.setActionCommand("FIN");
        finalizarCompra.setBackground(new Color(115, 115, 115));
        finalizarCompra.setFont(new Font("Comic Sans", Font.BOLD, 15));
        finalizarCompra.setForeground(Color.WHITE);
        finalizarCompra.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        finalizarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finalizarCompra.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                finalizarCompra.setBackground(new Color(115, 115, 115));
            }
        });
        finalizarCompra.addActionListener(this);
        add(finalizarCompra);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("AGREGAR"))
        {
            Producto productoCliente = principal.getProducto(Integer.parseInt(codigoProducto.getText()), principal.getProductos());
            System.out.println(productoCliente.getPrecio());
            if (!productoCliente.isEmpaquetado())
            {
                JDialog dialog = new JDialog();
                dialog.setTitle("Ingresar peso producto");
                dialog.setVisible(true);
                dialog.setSize(300, 100);
                dialog.setLocationRelativeTo(this);
                JPanel displayInput = new JPanel();
                displayInput.setVisible(true);
                GridLayout gl = new GridLayout(2, 2);
                displayInput.setLayout(gl);
                displayInput.add(new JLabel("Ingresar peso producto"));
                JTextField pesoProducto = new JTextField();
                displayInput.add(pesoProducto);
                displayInput.add(new JLabel("Presionar para"));
                JButton agregarPeso = new JButton("Agregar peso");
                agregarPeso.setActionCommand("PESO");
                agregarPeso.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String comandoEspecial = e.getActionCommand();
                        if (comandoEspecial.equals("PESO"))
                        {
                            productoCliente.setPeso(Double.parseDouble(pesoProducto.getText()));
                            pesosNoEmpaquetado.add(Double.parseDouble(pesoProducto.getText()));
                            dialog.dispose();
                        }
                    }
                });
                displayInput.add(agregarPeso);
                dialog.add(displayInput);
            }
            productosCliente.add(productoCliente);
        }
        else if (comando.equals("FIN"))
        {
            boolean confirmacion = principal.chequerId(Integer.parseInt(idCliente.getText()));
            Factura factura = principal.ejecutarCrearFactura(productosCliente, Integer.parseInt(idCliente.getText()));
            double total = factura.getTotalPagar();

            List<Producto> productosFactura = factura.getProductos();

            JDialog dialogFactura = new JDialog();
            dialogFactura.setVisible(true);
            dialogFactura.setSize(350, 350);
            dialogFactura.setLocationRelativeTo(this);
            JPanel displayFactura = new JPanel();
            displayFactura.setVisible(true);
            GridLayout df = new GridLayout(productosFactura.size()+8, 1);
            displayFactura.setLayout(df);
            displayFactura.add(new JLabel("FACTURA"));
            displayFactura.add(new JLabel("Id factura"));
            displayFactura.add(new JLabel("Codigo cliente : "+idCliente.getText()));
            for (Producto productoF : productosFactura)
            {
                if (!productoF.isEmpaquetado())
                {
                    displayFactura.add(new JLabel(productoF.getNombre()+" : "+
                            productoF.getPrecioPorUnidad()*productoF.getPeso()));
                }
                else
                {
                    displayFactura.add(new JLabel(productoF.getNombre()+" : "+
                            productoF.getPrecio()));
                }
            }
            displayFactura.add(new JLabel("TOTAL A PAGAR : "+total));
            if (confirmacion) {
                double puntosAcumulados = principal.calcularPuntosAcumulados(total);
                int clienteComprando = principal.buscarClientePorId(Integer.parseInt(idCliente.getText()));
                clientesRegistrados.get(clienteComprando).sumarPuntos(total);
                String now = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                clientesRegistrados.get(clienteComprando).addHistory(total, now);
                try {
                    principal.updateDataClientes();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                displayFactura.add(new JLabel("Puntos acumulados : " + puntosAcumulados));
            }
            else
            {
                displayFactura.add(new JLabel("Puntos acumulados : " + 0));
            }
            JScrollPane displayInfo = new JScrollPane(displayFactura, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            dialogFactura.add(displayInfo);
            principal.updateLotesAfterCompra(productosCliente, pesosNoEmpaquetado);
            try {
                principal.updateDataLotes();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            //System.out.println(total);
            dispose();
        }
        else if (comando.equals("INFO"))
        {
            JDialog dialogInfo = new JDialog();
            dialogInfo.setVisible(true);
            dialogInfo.setSize(700, 400);
            dialogInfo.setLocationRelativeTo(this);
            JPanel displayFactura = new JPanel();
            displayFactura.setVisible(true);
            GridLayout df = new GridLayout(1, 1);
            displayFactura.setLayout(df);

            int clienteComprando = principal.buscarClientePorId(Integer.parseInt(idCliente.getText()));
            List<List<String>> historialCliente = clientesRegistrados.get(clienteComprando).getHistorialTipoLista();
            //System.out.println(historialCliente.get(0).get(0)+" "+historialCliente.get(0).get(1));
            //System.out.println(historialCliente.get(1).get(0)+" "+historialCliente.get(0).get(1));
            //System.out.println(historialCliente.get(2).get(0)+" "+historialCliente.get(0).get(1));
            //System.out.println(historialCliente.get(3).get(0)+" "+historialCliente.get(0).get(1));
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            int counter = 0;
            for (List<String> secciones : historialCliente)
            {
                System.out.println(secciones.get(0)+" "+secciones.get(1));
                data.setValue(Double.parseDouble(secciones.get(0)), "Gastos", secciones.get(1)+"-"+String.valueOf(counter));
                counter += 1;
            }

            /*data.setValue(122700, "Marks", "9/11/16");
            data.setValue(122700, "Marks", "10/11/16");
            data.setValue(58700, "Marks", "11/16/2021");*/

            JFreeChart jchart = ChartFactory.createBarChart("Historial compras cliente "+idCliente.getText(),
                    "Fecha", "Dinero Gastado", data, PlotOrientation.VERTICAL,
                    false, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);

            ChartPanel chartPanel = new ChartPanel(jchart);
            dialogInfo.add(chartPanel);

            //chartPanel.setVisible(true);
            //chartPanel.setSize(400,400);
            //chartPanel.setLocationRelativeTo(null);

        }
    }
}
