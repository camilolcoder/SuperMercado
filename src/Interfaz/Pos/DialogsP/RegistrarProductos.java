package Interfaz.Pos.DialogsP;

import Interfaz.InterfazPrincipal;
import Modelo.Cliente;
import Modelo.Factura;
import Modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            System.out.println(total);
            dispose();
        }
    }
}
