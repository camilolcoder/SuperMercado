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
        setSize(300, 300);
        setLocationRelativeTo(null);

        String sexoOps[] = {"Masculino", "Femenino", "Otro"};
        String situacionLaboralOps[] = {"Estudiante", "Independiente", "Empleado", "Desempleado"};

        setLayout(new GridLayout(7,2));
        nombreText = new JLabel("Nombre del texto");
        add(nombreText);

        nombre = new JTextField();
        add(nombre);

        edadText = new JLabel("Edad");
        add(edadText);

        edad = new JTextField();
        add(edad);

        sexoText = new JLabel("Sexo");
        add(sexoText);

        sexo = new JComboBox(sexoOps);
        add(sexo);

        estadoCivilText = new JLabel("Estado civil");
        add(estadoCivilText);

        estadoCivil = new JTextField();
        add(estadoCivil);

        iDText = new JLabel("Id");
        add(iDText);

        iD = new JTextField();
        add(iD);

        situacionLaboralText = new JLabel("Situacion laboral");
        add(situacionLaboralText);

        situacionLaboral = new JComboBox(situacionLaboralOps);
        add(situacionLaboral);

        crearClienteText = new JLabel("Presione para");
        add(crearClienteText);

        crearCliente = new JButton("Crear cliente");
        crearCliente.setActionCommand("CREARCLI");
        crearCliente.addActionListener(this);
        add(crearCliente);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("CREARCLI"))
        {
            dispose();
        }
    }
}
