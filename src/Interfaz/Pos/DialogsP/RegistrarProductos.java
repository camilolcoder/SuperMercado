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
    public static final String PUNTOS = "PUNTOS";
    public static final String PUNTOSIN = "PUNTOSIN";
    public static final String FIN = "FIN";

    private InterfazPrincipal principal;

    private List<Producto> productosCliente;// = new ArrayList<>();
    private List<Double> pesosNoEmpaquetado;// = new ArrayList<>();
    private List<Cliente> clientesRegistrados;// = principal.getClientes();
    private int descuentoPorPuntos;

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
    private JLabel pagarPuntosText;
    private JButton pagarPuntos;
    private JLabel finalizarCompraText;
    private JButton finalizarCompra;

    private JDialog pagarPuntosD;
    private JTextField puntosGastar;

    private Color coolGray;

    public RegistrarProductos(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;

        productosCliente = new ArrayList<>();
        pesosNoEmpaquetado = new ArrayList<>();
        clientesRegistrados = principal.getClientes();

        setBackground(new Color(217, 217, 217));
        Border padding = BorderFactory.createEmptyBorder(0, 30, 0, 0);
        setVisible(true);
        setSize(450, 350);
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

        coolGray = new Color(115, 115, 115);

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

        /*infoProductoText = new JLabel("Imagen Producto", SwingConstants.CENTER);
        infoProductoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        infoProductoText.setOpaque(true);
        infoProductoText.setBackground(new Color(115, 115, 115));
        infoProductoText.setForeground(Color.WHITE);
        add(infoProductoText);

        productoImg = new JLabel();
        productoImg.setBackground(new Color(115, 115, 115));
        //ImageIcon imgPro = new ImageIcon(direccion);
        add(productoImg);*/

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

        pagarPuntosText = new JLabel("Presione para", SwingConstants.CENTER);
        pagarPuntosText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        pagarPuntosText.setOpaque(true);
        pagarPuntosText.setBackground(new Color(115, 115, 115));
        pagarPuntosText.setForeground(Color.WHITE);
        add(pagarPuntosText);

        pagarPuntos = new JButton("Pagar con puntos");
        pagarPuntos.setActionCommand("PUNTOS");
        pagarPuntos.setBackground(new Color(115, 115, 115));
        pagarPuntos.setFont(new Font("Comic Sans", Font.BOLD, 15));
        pagarPuntos.setForeground(Color.WHITE);
        pagarPuntos.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        pagarPuntos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pagarPuntos.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                pagarPuntos.setBackground(new Color(115, 115, 115));
            }
        });
        pagarPuntos.addActionListener(this);
        add(pagarPuntos);

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
        else if (comando.equals("PUNTOS"))
        {
            boolean confirmacion = principal.chequerId(Integer.parseInt(idCliente.getText()));
            Factura factura = principal.ejecutarCrearFactura(productosCliente, Integer.parseInt(idCliente.getText()));
            double total = factura.getTotalPagar();

            int clienteComprando = principal.buscarClientePorId(Integer.parseInt(idCliente.getText()));
            Cliente actualCliente = clientesRegistrados.get(clienteComprando);

            if (confirmacion) {
                pagarPuntosD = new JDialog();
                pagarPuntosD.setVisible(true);
                pagarPuntosD.setSize(450, 200);
                pagarPuntosD.setLocationRelativeTo(this);

                JPanel displayFactura = new JPanel();
                displayFactura.setVisible(true);
                GridLayout df = new GridLayout(4, 2);
                df.setVgap(5);
                displayFactura.setLayout(df);

                JLabel totalPagarText = new JLabel("El total a pagar es", SwingConstants.CENTER);
                totalPagarText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                totalPagarText.setOpaque(true);
                totalPagarText.setBackground(new Color(115, 115, 115));
                totalPagarText.setForeground(Color.WHITE);

                JLabel totalPagar = new JLabel(String.valueOf(total), SwingConstants.CENTER);
                totalPagar.setFont(new Font("Comic Sans", Font.BOLD, 15));
                totalPagar.setOpaque(true);
                totalPagar.setBackground(new Color(115, 115, 115));
                totalPagar.setForeground(Color.WHITE);

                JLabel totalPuntosText = new JLabel("Total puntos del cliente", SwingConstants.CENTER);
                totalPuntosText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                totalPuntosText.setOpaque(true);
                totalPuntosText.setBackground(new Color(115, 115, 115));
                totalPuntosText.setForeground(Color.WHITE);

                JLabel totalPuntos = new JLabel(String.valueOf(actualCliente.getPuntos()), SwingConstants.CENTER);
                totalPuntos.setFont(new Font("Comic Sans", Font.BOLD, 15));
                totalPuntos.setOpaque(true);
                totalPuntos.setBackground(new Color(115, 115, 115));
                totalPuntos.setForeground(Color.WHITE);

                JLabel puntosGastarText = new JLabel("Cantidad de puntos a gastar", SwingConstants.CENTER);
                puntosGastarText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                puntosGastarText.setOpaque(true);
                puntosGastarText.setBackground(new Color(115, 115, 115));
                puntosGastarText.setForeground(Color.WHITE);

                puntosGastar = new JTextField();
                puntosGastar.setBorder(BorderFactory.createLineBorder(coolGray, 3));

                JLabel usarPuntosText = new JLabel("Presione para", SwingConstants.CENTER);
                usarPuntosText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                usarPuntosText.setOpaque(true);
                usarPuntosText.setBackground(new Color(115, 115, 115));
                usarPuntosText.setForeground(Color.WHITE);

                JButton usarPuntos = new JButton("Gastar puntos");
                usarPuntos.setActionCommand("PUNTOSIN");
                usarPuntos.setBackground(new Color(115, 115, 115));
                usarPuntos.setFont(new Font("Comic Sans", Font.BOLD, 15));
                usarPuntos.setForeground(Color.WHITE);
                usarPuntos.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
                usarPuntos.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        usarPuntos.setBackground(new Color(84, 84, 84));
                    }

                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        usarPuntos.setBackground(new Color(115, 115, 115));
                    }
                });
                usarPuntos.addActionListener(this);

                displayFactura.add(totalPagarText);
                displayFactura.add(totalPagar);
                displayFactura.add(totalPuntosText);
                displayFactura.add(totalPuntos);
                displayFactura.add(puntosGastarText);
                displayFactura.add(puntosGastar);
                displayFactura.add(usarPuntosText);
                displayFactura.add(usarPuntos);

                pagarPuntosD.add(displayFactura);

                //usarPuntos.setActionCommand();
            }
            else
            {
                JOptionPane.showMessageDialog(this,
                        "El cliente no esta registrado en el sistema de puntos",
                        "Error cliente no registrado",
                        JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (comando.equals("PUNTOSIN"))
        {
            //System.out.println("Funciona el cambio");
            int clienteComprando = principal.buscarClientePorId(Integer.parseInt(idCliente.getText()));
            clientesRegistrados.get(clienteComprando).restarPuntos(Integer.parseInt(puntosGastar.getText()));
            descuentoPorPuntos = Integer.parseInt(puntosGastar.getText());
            pagarPuntosD.dispose();
        }

        else if (comando.equals("FIN"))
        {
            boolean confirmacion = principal.chequerId(Integer.parseInt(idCliente.getText()));
            Factura factura = principal.ejecutarCrearFactura(productosCliente, Integer.parseInt(idCliente.getText()));
            double total = factura.getTotalPagar();

            List<Producto> productosFactura = factura.getProductos();

            JDialog dialogFactura = new JDialog();
            dialogFactura.setVisible(true);
            dialogFactura.setSize(500, 400);
            dialogFactura.setLocationRelativeTo(this);
            JPanel displayFactura = new JPanel();
            displayFactura.setVisible(true);
            GridLayout df = new GridLayout(productosFactura.size()+13, 1);
            displayFactura.setLayout(df);

            JLabel facturaText = new JLabel("FACTURA", SwingConstants.CENTER);
            facturaText.setFont(new Font("Comic Sans", Font.BOLD, 20));
            facturaText.setOpaque(true);
            facturaText.setBackground(new Color(115, 115, 115));
            facturaText.setForeground(Color.WHITE);
            displayFactura.add(facturaText);

            JLabel facturaIdText = new JLabel("Id Factura", SwingConstants.CENTER);
            facturaIdText.setFont(new Font("Comic Sans", Font.BOLD, 15));
            facturaIdText.setOpaque(true);
            facturaIdText.setBackground(new Color(115, 115, 115));
            facturaIdText.setForeground(Color.WHITE);
            displayFactura.add(facturaIdText);

            JLabel idClienteText = new JLabel("Codigo cliente : "+idCliente.getText(), SwingConstants.CENTER);
            idClienteText.setFont(new Font("Comic Sans", Font.BOLD, 15));
            idClienteText.setOpaque(true);
            idClienteText.setBackground(new Color(115, 115, 115));
            idClienteText.setForeground(Color.WHITE);
            displayFactura.add(idClienteText);

            for (Producto productoF : productosFactura)
            {
                double precio =  0;
                if (!productoF.isEmpaquetado())
                {
                    precio = productoF.getPrecioPorUnidad()*productoF.getPeso();
                }
                else
                {
                    precio = productoF.getPrecio();
                }
                productoF.updateHistorial();
                JLabel productoText = new JLabel(productoF.getNombre()+" : "+ precio);
                productoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                productoText.setOpaque(true);
                productoText.setBackground(new Color(115, 115, 115));
                productoText.setForeground(Color.WHITE);
                displayFactura.add(productoText);
            }
            JLabel totalPagarText = new JLabel("TOTAL A PAGAR : "+total, SwingConstants.CENTER);
            totalPagarText.setFont(new Font("Comic Sans", Font.BOLD, 15));
            totalPagarText.setOpaque(true);
            totalPagarText.setBackground(new Color(115, 115, 115));
            totalPagarText.setForeground(Color.WHITE);
            displayFactura.add(totalPagarText);

            if (confirmacion) {
                double puntosAcumulados = principal.calcularPuntosAcumulados(total-15*descuentoPorPuntos);
                int clienteComprando = principal.buscarClientePorId(Integer.parseInt(idCliente.getText()));
                Cliente clienteActual = clientesRegistrados.get(clienteComprando);
                clienteActual.sumarPuntos(total-15*descuentoPorPuntos);
                String now = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                clientesRegistrados.get(clienteComprando).addHistory(total, now);
                try {
                    principal.updateDataClientes();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                double totalDescuento = total - 15*descuentoPorPuntos;
                JLabel totalConPuntos = new JLabel("TOTAL A PAGAR DESCONTANDO PUNTOS USADOS : "+totalDescuento, SwingConstants.CENTER);
                totalConPuntos.setFont(new Font("Comic Sans", Font.BOLD, 15));
                totalConPuntos.setOpaque(true);
                totalConPuntos.setBackground(new Color(115, 115, 115));
                totalConPuntos.setForeground(Color.WHITE);
                displayFactura.add(totalConPuntos);

                JLabel reportePuntosText = new JLabel("--------------REPORTE-DE-PUNTOS--------------", SwingConstants.CENTER);
                reportePuntosText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                reportePuntosText.setOpaque(true);
                reportePuntosText.setBackground(new Color(115, 115, 115));
                reportePuntosText.setForeground(Color.WHITE);
                displayFactura.add(reportePuntosText);

                int puntosTotalesAntes = clienteActual.getPuntos()+descuentoPorPuntos-(int)puntosAcumulados;
                JLabel puntosTotalesAntesText = new JLabel("Puntos totales antes de compra : "+ puntosTotalesAntes);
                puntosTotalesAntesText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                puntosTotalesAntesText.setOpaque(true);
                puntosTotalesAntesText.setBackground(new Color(115, 115, 115));
                puntosTotalesAntesText.setForeground(Color.WHITE);
                displayFactura.add(puntosTotalesAntesText);

                JLabel puntosRedimAntesText = new JLabel("Puntos usados en la compra : "+ descuentoPorPuntos);
                puntosRedimAntesText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                puntosRedimAntesText.setOpaque(true);
                puntosRedimAntesText.setBackground(new Color(115, 115, 115));
                puntosRedimAntesText.setForeground(Color.WHITE);
                displayFactura.add(puntosRedimAntesText);

                JLabel puntosAcumuladosText = new JLabel("Puntos acumulados por compra: "+ puntosAcumulados);
                puntosAcumuladosText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                puntosAcumuladosText.setOpaque(true);
                puntosAcumuladosText.setBackground(new Color(115, 115, 115));
                puntosAcumuladosText.setForeground(Color.WHITE);
                displayFactura.add(puntosAcumuladosText);

                JLabel puntosTotalesDespText = new JLabel("Puntos totales despues de compra : "+ clienteActual.getPuntos());
                puntosTotalesDespText.setFont(new Font("Comic Sans", Font.BOLD, 15));
                puntosTotalesDespText.setOpaque(true);
                puntosTotalesDespText.setBackground(new Color(115, 115, 115));
                puntosTotalesDespText.setForeground(Color.WHITE);
                displayFactura.add(puntosTotalesDespText);
            }
            else
            {
                JLabel noInscrito = new JLabel("--No-obtiene-beneficios-del-sistema-de-puntos");
                noInscrito.setFont(new Font("Comic Sans", Font.BOLD, 15));
                noInscrito.setOpaque(true);
                noInscrito.setBackground(new Color(115, 115, 115));
                noInscrito.setForeground(Color.WHITE);
                displayFactura.add(noInscrito);
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
        else if (comando.equals("MOSTRARIMG"))
        {
            //ImageIcon img = new ImageIcon("..\\SuperMercado\\src\\DataBase\\Images\\froot_loops.jpg");
            Producto productInfo =  principal.getProducto(Integer.parseInt(codigoProducto.getText()), principal.getProductos());
            String direccionImg = productInfo.getDireccionImg();
            productoImg = new JLabel();
            //direccionTestImg = "..\\SuperMercado\\src\\DataBase\\Images\\froot_loops.jpg"
            //3, 19
            //TODO mostrar más informacion sobre los productos
            //TODO mostrar cuando no existe imagen asociada al producto
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(direccionImg).getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT));
            productoImg.setIcon(imageIcon);
            JOptionPane.showMessageDialog(null, productoImg, "About", JOptionPane.PLAIN_MESSAGE, null);
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
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            int counter = 0;
            for (List<String> secciones : historialCliente)
            {
                System.out.println(secciones.get(0)+" "+secciones.get(1));
                data.setValue(Double.parseDouble(secciones.get(0)), "Gastos", secciones.get(1)+"-"+String.valueOf(counter));
                counter += 1;
            }


            JFreeChart jchart = ChartFactory.createBarChart("Historial compras cliente "+idCliente.getText(),
                    "Fecha", "Dinero Gastado", data, PlotOrientation.VERTICAL,
                    false, true, false);
            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);

            ChartPanel chartPanel = new ChartPanel(jchart);
            dialogInfo.add(chartPanel);
        }
    }
}
