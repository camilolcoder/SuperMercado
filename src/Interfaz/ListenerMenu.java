package Interfaz;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ListenerMenu implements ActionListener
{

    // ************************************************************************
    // Constantes
    // ************************************************************************

    public static final String ABRIR_LIBROS = "ABRIR_LIBROS";

    // ************************************************************************
    // Atributos
    // ************************************************************************

    private InterfazPrincipal ventana;

    // ************************************************************************
    // Constructores
    // ************************************************************************

    public ListenerMenu(InterfazPrincipal interfazLibreria)
    {
        ventana = interfazLibreria;
    }

    // ************************************************************************
    // MÃ©todos implementados de la interfaz
    // ************************************************************************

    /**
     * Este mÃ©todo le pide al usuario el archivo con la informaciÃ³n de las
     * categorÃ­as y el archivo con la informaciÃ³n de los libros de la librerÃ­a. Si
     * todo sale bien con la selecciÃ³n de los archivos, se invoca al mÃ©todo
     * cargarArchivos de la ventana principal de la aplicaciÃ³n.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        if (ABRIR_LIBROS.equals(comando))
        {
            File archivo_categorias = null;
            JFileChooser fc = new JFileChooser("./data");
            fc.setDialogTitle("Seleccione el archivo con las categorÃ­as");
            fc.setFileFilter(new FiltroCSV());
            int resultado = fc.showOpenDialog(ventana);
            if (resultado == JFileChooser.APPROVE_OPTION)
            {
                archivo_categorias = fc.getSelectedFile();

                File archivo_libros = null;
                fc = new JFileChooser("./data");
                fc.setDialogTitle("Seleccione el archivo con los libros");
                fc.setFileFilter(new FiltroCSV());
                resultado = fc.showOpenDialog(ventana);
                if (resultado == JFileChooser.APPROVE_OPTION)
                {
                    archivo_libros = fc.getSelectedFile();

                    //ventana.cargarArchivos(archivo_categorias, archivo_libros);
                }
            }
        }

    }

    // ************************************************************************
    // Clases anidadas
    // ************************************************************************

    private final class FiltroCSV extends FileFilter
    {
        @Override
        public String getDescription()
        {
            return "Archivo CSV";
        }

        @Override
        public boolean accept(File f)
        {
            return f.isDirectory() || f.getName().toLowerCase().endsWith(".csv");
        }
    }

}
