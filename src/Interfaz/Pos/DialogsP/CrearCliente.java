package Interfaz.Pos.DialogsP;

import Interfaz.InterfazPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearCliente extends JDialog implements ActionListener {

    public final static String CREARCLI = "CREARCLI";
    private InterfazPrincipal principal;

    private JLabel nombreText;
    private JTextField nombre;
    private JLabel edadText;
    private JTextField edad;
    private JLabel sexoText;
    private JComboBox sexo;
    private JLabel estadoCivilText;
    private JTextField estadoCivil;
    private JLabel iDText;
    private JTextField iD;
    private JLabel situacionLaboralText;
    private JComboBox situacionLaboral; //Estudiante, Independiente, Empleado, Desempleado
    private JLabel crearClienteText;
    private JButton crearCliente;

    public  CrearCliente(InterfazPrincipal Pprincipal)
    {
        principal = Pprincipal;
        setVisible(true);
        setSize(350, 350);
        setBackground(new Color(217, 217, 217));
        setTitle("Crear cliente");
        setLocationRelativeTo(null);

        String sexoOps[] = {"Masculino", "Femenino", "Otro"};
        String situacionLaboralOps[] = {"Estudiante", "Independiente", "Empleado", "Desempleado"};

        //setLayout(new GridLayout(7,2));
        GridLayout gl = new GridLayout(7, 2);
        setLayout(gl);//new GridLayout(5, 2));
        gl.setHgap(1);
        gl.setVgap(5);

        Color coolGray = new Color(115, 115, 115);

        nombreText = new JLabel("Nombre del texto", SwingConstants.CENTER);
        nombreText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        nombreText.setOpaque(true);
        nombreText.setBackground(new Color(115, 115, 115));
        nombreText.setForeground(Color.WHITE);
        add(nombreText);

        nombre = new JTextField();
        nombre.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(nombre);

        edadText = new JLabel("Edad", SwingConstants.CENTER);
        edadText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        edadText.setOpaque(true);
        edadText.setBackground(new Color(115, 115, 115));
        edadText.setForeground(Color.WHITE);
        add(edadText);

        edad = new JTextField();
        edad.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(edad);

        sexoText = new JLabel("Sexo", SwingConstants.CENTER);
        sexoText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        sexoText.setOpaque(true);
        sexoText.setBackground(new Color(115, 115, 115));
        sexoText.setForeground(Color.WHITE);
        add(sexoText);

        sexo = new JComboBox(sexoOps);
        sexo.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        sexo.setBackground(new Color(115, 115, 115));
        sexo.setFont(new Font("Comic Sans", Font.BOLD, 12));
        sexo.setForeground(Color.WHITE);
        add(sexo);

        estadoCivilText = new JLabel("Estado civil", SwingConstants.CENTER);
        estadoCivilText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        estadoCivilText.setOpaque(true);
        estadoCivilText.setBackground(new Color(115, 115, 115));
        estadoCivilText.setForeground(Color.WHITE);
        add(estadoCivilText);

        estadoCivil = new JTextField();
        estadoCivil.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(estadoCivil);

        iDText = new JLabel("Id", SwingConstants.CENTER);
        iDText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        iDText.setOpaque(true);
        iDText.setBackground(new Color(115, 115, 115));
        iDText.setForeground(Color.WHITE);
        add(iDText);

        iD = new JTextField();
        iD.setBorder(BorderFactory.createLineBorder(coolGray, 3));
        add(iD);

        situacionLaboralText = new JLabel("Situacion laboral", SwingConstants.CENTER);
        situacionLaboralText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        situacionLaboralText.setOpaque(true);
        situacionLaboralText.setBackground(new Color(115, 115, 115));
        situacionLaboralText.setForeground(Color.WHITE);
        add(situacionLaboralText);

        situacionLaboral = new JComboBox(situacionLaboralOps);
        situacionLaboral.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        situacionLaboral.setBackground(new Color(115, 115, 115));
        situacionLaboral.setFont(new Font("Comic Sans", Font.BOLD, 12));
        situacionLaboral.setForeground(Color.WHITE);
        add(situacionLaboral);

        crearClienteText = new JLabel("Presione para", SwingConstants.CENTER);
        crearClienteText.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearClienteText.setOpaque(true);
        crearClienteText.setBackground(new Color(115, 115, 115));
        crearClienteText.setForeground(Color.WHITE);
        add(crearClienteText);

        crearCliente = new JButton("Crear cliente");
        crearCliente.setActionCommand("CREARCLI");
        crearCliente.setBackground(new Color(115, 115, 115));
        crearCliente.setFont(new Font("Comic Sans", Font.BOLD, 15));
        crearCliente.setForeground(Color.WHITE);
        crearCliente.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        crearCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                crearCliente.setBackground(new Color(84, 84, 84));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                crearCliente.setBackground(new Color(115, 115, 115));
            }
        });
        crearCliente.addActionListener(this);
        add(crearCliente);
    }

    //TODO agregarBoton void method para ahorrar codigo,
    // relizar esto en todas las clases de interfaz

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("CREARCLI"))
        {
            String nombreIn = nombre.getText();
            int edadIn = Integer.parseInt(edad.getText());
            String sexoIn = (String) sexo.getItemAt(sexo.getSelectedIndex());
            String estadoCivilIn = estadoCivil.getText();
            int idIn = Integer.parseInt(iD.getText());
            String situacionLaboralIn = (String) situacionLaboral.getItemAt(situacionLaboral.getSelectedIndex());

            principal.ejecutarCrearCliente(nombreIn, edadIn, sexoIn, estadoCivilIn, idIn, situacionLaboralIn);

            dispose();
        }
    }
}
