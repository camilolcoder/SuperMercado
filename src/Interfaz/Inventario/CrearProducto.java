package Interfaz.Inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearProducto extends JPanel implements ActionListener {

    public final static String CREARCLI = "CREARCLI";

    private JLabel nombreProductoText;
    private JTextField nombreProducto;
    private JLabel crearProductoTexto;
    private JButton crearProducto;
    private JLabel precioTexto;
    private JTextField precioProducto;
    private JLabel precioPorUnidad;
    private JComboBox unidadMedida;
    private JLabel pesoTexto;
    private JTextField pesoProducto;
    private JLabel categoriasTexto;
    private JComboBox categorias;
    private JLabel tipoEmpaquetadoTexto;
    private JComboBox tipoEmpaquetado;

    public CrearProducto()
    {
        String unidadesMedida[] = {"mg", "g", "Kg", "T"};
        String categoriasLista[] = {"frutas", "verduras", "aseo personal"};
        //TODO la lista de categorias para el combo box debe provenir de las previamente creadas
        String tipos[] = {"Empaquetado", "Congelado", "Refrigerado", "Fresco"};

        setLayout(new GridLayout(7, 2));
        nombreProductoText = new JLabel("Nombre producto");
        add(nombreProductoText);

        nombreProducto = new JTextField();
        add(nombreProducto);

        precioTexto = new JLabel("Ingrese el precio");
        add(precioTexto);

        precioProducto = new JTextField();
        add(precioProducto);

        precioPorUnidad = new JLabel("Precio por unidad");
        add(precioPorUnidad);

        unidadMedida = new JComboBox(unidadesMedida);
        add(unidadMedida);

        pesoTexto = new JLabel("Peso producto");
        add(pesoTexto);

        pesoProducto = new JTextField();
        add(pesoProducto);

        categoriasTexto = new JLabel("Categorias");
        add(categoriasTexto);

        categorias = new JComboBox(categoriasLista);
        add(categorias);

        tipoEmpaquetadoTexto = new JLabel("Tipo de empaquetado");
        add(tipoEmpaquetadoTexto);

        tipoEmpaquetado = new JComboBox(tipos);
        add(tipoEmpaquetado);

        //----------------------------------
        crearProductoTexto = new JLabel();
        add(crearProductoTexto);

        crearProducto = new JButton("Crear producto");
        crearProducto.setActionCommand("CREARCLI");
        crearProducto.addActionListener(this);
        add(crearProducto);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("CREARCLI"))
        {
            System.out.println(nombreProducto.getText());
        }
    }
}
