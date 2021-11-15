package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TODO Cuando se crea un producto se debe borrar lo del anterior o
// cerrar el JDialog

//TODO Cuando se crea un producto se debe poder agregar una imagen
// a ese producto
// -ideas: podemos permitir asociar una imagen a la hora de crearlo
//        -podemos crear un boton aparte para asociar imagenes a los
//         a los productos

public class CrearProducto extends JDialog implements ActionListener {

    public final static String CREARCLI = "CREARCLI";
    private InterfazPrincipal principal;
    private int commandClose = 0;

    private JLabel nombreProductoText;
    private JTextField nombreProducto;
    private JLabel precioTexto;
    private JTextField precioProducto;
    private JLabel precioPorUnidadText;
    private JTextField precioPorUnidad;
    private JLabel unidadMedidaText;
    private JComboBox unidadMedida;
    private JLabel pesoTexto;
    private JTextField pesoProducto;
    private JLabel categoriasTexto;
    private JComboBox categorias;
    private JLabel tipoEmpaquetadoTexto;
    private JComboBox tipoEmpaquetado;
    private JLabel boolEmpaquetadoText;
    private JComboBox boolEmpaquetado;
    private JLabel crearProductoTexto;
    private JButton crearProducto;

    public CrearProducto(InterfazPrincipal Pprincipal) throws IOException {
        principal = Pprincipal;
        setVisible(true);
        setSize(300, 300);
        setLocationRelativeTo(null);
        String unidadesMedida[] = {"mg", "g", "Kg", "T"};
        //String categoriasLista[] = {"frutas", "verduras", "aseo personal"};
        String categoriasLista[] = principal.obtenerCategorias();
        //DONE la lista de categorias para el combo box debe provenir de las previamente creadas
        String tipos[] = {"Gondola", "Congelado", "Refrigerado", "Fresco"};
        String bools[] = {"Si", "No"};

        setLayout(new GridLayout(9, 2));
        nombreProductoText = new JLabel("Nombre producto");
        add(nombreProductoText);

        nombreProducto = new JTextField();
        add(nombreProducto);

        precioTexto = new JLabel("Ingrese el precio");
        add(precioTexto);

        precioProducto = new JTextField();
        add(precioProducto);

        precioPorUnidadText = new JLabel("Precio por unidad");
        add(precioPorUnidadText);

        precioPorUnidad = new JTextField();
        add(precioPorUnidad);

        unidadMedidaText = new JLabel("Unidad de medida");
        add(unidadMedidaText);

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

        tipoEmpaquetadoTexto = new JLabel("Clase de empaquetado");
        add(tipoEmpaquetadoTexto);

        tipoEmpaquetado = new JComboBox(tipos);
        add(tipoEmpaquetado);

        boolEmpaquetadoText = new JLabel("Esta empaquetado");
        add(boolEmpaquetadoText);

        boolEmpaquetado = new JComboBox(bools);
        add(boolEmpaquetado);

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
            String nombre = nombreProducto.getText(); //NOMBRE
            double precio = Double.parseDouble(precioProducto.getText());// PRECIO
            double precioUnidad = Double.parseDouble(precioPorUnidad.getText());//PRECIO X UNIDAD
            String uniMedida =  (String) unidadMedida.getItemAt(unidadMedida.getSelectedIndex()); //UNIDAD MEDIDA
            double peso = Double.parseDouble(pesoProducto.getText()); //PESO
            String categoriaSeleccionada = (String) categorias.getItemAt(categorias.getSelectedIndex()); // CATEGORIA
            String tipoEmpaquetadoSeleccionado = (String) tipoEmpaquetado.getItemAt(tipoEmpaquetado.getSelectedIndex());//TIPO EMPAQUETADO
            String seleccionBool = (String) boolEmpaquetado.getItemAt(boolEmpaquetado.getSelectedIndex());
            boolean empaquetadoSeleccionado = tipoEmpaquetadoBool(seleccionBool);//BOOL DE EMPAQUETADO
            System.out.println(nombreProducto.getText());
            System.out.println(precioProducto.getText());
            System.out.println(uniMedida);
            System.out.println(pesoProducto.getText());
            System.out.println(categoriaSeleccionada);
            System.out.println(tipoEmpaquetadoSeleccionado);
            //commandClose = 1;
            principal.ejecutarCrearProducto(nombre, precio, precioUnidad, uniMedida, peso,
                    categoriaSeleccionada, tipoEmpaquetadoSeleccionado, empaquetadoSeleccionado);
        }
    }
    public int closeDialog()
    {
        return commandClose;
        //TODO Close dialog when press create client
    }

    public boolean tipoEmpaquetadoBool(String seleccion)
    {
        boolean confirmar = true;
        if (seleccion.equals("Si"))
        {
            confirmar = true;
        }
        else if (seleccion.equals("No"))
        {
            confirmar = false;
        }
        return confirmar;
    }
}
