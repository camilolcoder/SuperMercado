package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CrearLote extends JDialog implements ActionListener {

    public final static String CREARLOT = "CREARLOT";
    private InterfazPrincipal principal;
    //private PanelOpcionesInventario panelOpciones;

    private JLabel idLoteText;
    private JTextField idLote;
    private JLabel fechaEntradaText;
    private JTextField fechaEntrada;
    private JLabel fechaVencimientoTexto;
    private JTextField fechaVencimiento;
    private JLabel idProductoText;
    private JTextField idProducto;
    private JLabel precioPagadoText;
    private JTextField precioPagado;
    private JLabel precioAVenderTexto;
    private JTextField precioAVender;
    private JLabel cantidadUnidadesText;
    private JTextField cantidadUnidades;
    private JLabel pesoTotalText;
    private JTextField pesoTotal;
    private JLabel crearLoteText;
    private JButton crearLote;

    public CrearLote(InterfazPrincipal Pprincipal) throws IOException {
        principal = Pprincipal;
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(9, 2));
        idLoteText = new JLabel("Ingrese Id Lote");
        add(idLoteText);

        idLote = new JTextField();
        add(idLote);

        fechaEntradaText = new JLabel("Ingrese la fecha de entrada MM/dd/yy");
        add(fechaEntradaText);

        fechaEntrada = new JTextField();
        add(fechaEntrada);

        fechaVencimientoTexto = new JLabel("Ingrese la fecha de vencimiento MM/dd/yy");
        add(fechaVencimientoTexto);

        fechaVencimiento = new JTextField();
        add(fechaVencimiento);

        idProductoText = new JLabel("Ingrese Id producto");
        add(idProductoText);

        idProducto = new JTextField();
        add(idProducto);

        precioPagadoText = new JLabel("Precio pagado");
        add(precioPagadoText);

        precioPagado = new JTextField();
        add(precioPagado);

        precioAVenderTexto = new JLabel("Precio a vender");
        add(precioAVenderTexto);

        precioAVender = new JTextField();
        add(precioAVender);

        cantidadUnidadesText = new JLabel("Cantidad de unidades");
        add(cantidadUnidadesText);

        cantidadUnidades = new JTextField();
        add(cantidadUnidades);

        pesoTotalText = new JLabel("Peso total");
        add(pesoTotalText);

        pesoTotal = new JTextField();
        add(pesoTotal);

        crearLoteText = new JLabel("Presione para: ");
        add(crearLoteText);

        crearLote = new JButton("Crear Lote");
        crearLote.setActionCommand("CREARLOT");
        crearLote.addActionListener(this);
        add(crearLote);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("CREARLOT"))
        {
            dispose();
        }
    }
}
