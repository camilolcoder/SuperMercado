package Interfaz.Pos.DialogsP;

import Interfaz.InterfazPrincipal;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrarProductos  extends JDialog implements ActionListener {

    public static  final String PESO = "PESO";
    public static final String AGREGAR = "AGREGAR";
    public static final String FIN = "FIN";

    private InterfazPrincipal principal;

    private List<Producto> productosCliente;// = new ArrayList<>();
    private List<Double> pesosNoEmpaquetado;// = new ArrayList<>();
    private List<Cliente> clientesRegistrados;// = principal.getClientes();

    private JLabel codigoProductoText;
    private JTextField codigoProducto;
    private JLabel agregarText;
    private JButton agregar;
    private JLabel idClienteText;
    private JTextField idCliente;
    private JLabel finalizarCompraText;
    private JButton finalizarCompra;

    public RegistrarProductos(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;

        productosCliente = new ArrayList<>();
        pesosNoEmpaquetado = new ArrayList<>();
        clientesRegistrados = principal.getClientes();

        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 2));
        codigoProductoText = new JLabel("Codigo Producto");
        add(codigoProductoText);

        codigoProducto = new JTextField();
        add(codigoProducto);

        agregarText = new JLabel("Agregar");
        add(agregarText);

        agregar = new JButton("Agregar");
        agregar.setActionCommand("AGREGAR");
        agregar.addActionListener(this);
        add(agregar);

        idClienteText = new JLabel("Id Cliente");
        add(idClienteText);

        idCliente = new JTextField();
        add(idCliente);

        finalizarCompraText = new JLabel("Presione para ");
        add(finalizarCompraText);

        finalizarCompra = new JButton("<html>Finalizar compra<br />y mostrar total</html>");
        finalizarCompra.setActionCommand("FIN");
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
    }
}
