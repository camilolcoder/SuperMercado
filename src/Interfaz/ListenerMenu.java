package Interfaz;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ListenerMenu implements ActionListener
{

    public static final String ABRIR_LIBROS = "ABRIR_LIBROS";

    private InterfazPrincipal ventana;

    public ListenerMenu(InterfazPrincipal interfazPrincipal)
    {
        ventana = interfazPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String comando = e.getActionCommand();
        if (ABRIR_LIBROS.equals(comando))
        {
            File archivos_lotes = null;
            JFileChooser fc = new JFileChooser("./data");
            fc.setDialogTitle("Seleccione el archivo csv con la informacion de los Lotes");
            fc.setFileFilter(new FiltroCSV());
            int resultado = fc.showOpenDialog(ventana);
            if (resultado == JFileChooser.APPROVE_OPTION)
            {
                archivos_lotes = fc.getSelectedFile();

                File archivo_libros = null;
                fc = new JFileChooser();//"./data");
                fc.setDialogTitle("Seleccione el archivo con los libros");
                fc.setFileFilter(new FiltroCSV());
                resultado = fc.showOpenDialog(ventana);
                if (resultado == JFileChooser.APPROVE_OPTION)
                {
                    archivo_libros = fc.getSelectedFile();

                    //ventana.ejecutarCargarNuevosLotesCsv(archivos_lotes);
                }
            }
        }

    }

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
