package Interfaz.Inventario;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CrearCategoria extends JPanel implements ActionListener {

    public final static String CREARCAT = "CREARCAT";
    private InterfazPrincipal principal;

    private JLabel nombreCategoriaText;
    private JTextField nombreCategoria;
    private JLabel crearCategoriaText;
    private JButton createCategoria;

    public CrearCategoria() throws IOException {
        principal = new InterfazPrincipal();

        setLayout(new GridLayout(2,2));
        nombreCategoriaText = new JLabel("Nueva categoria");
        add(nombreCategoriaText);

        nombreCategoria = new JTextField();
        add(nombreCategoria);

        crearCategoriaText = new JLabel("Presionar para : ");
        add(crearCategoriaText);

        createCategoria = new JButton("Crear categoria");
        createCategoria.setActionCommand("CREARCAT");
        createCategoria.addActionListener(this);
        add(createCategoria);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("CREARCAT"))
        {
            String categoria = nombreCategoria.getText();
            System.out.println(categoria);
            principal.ejecutarCrearCategoria(categoria);
            try {
                principal.obtenerCategorias();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
