package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Producto {

    private String nombre;
    private double precio;
    private double precioPorUnidad;
    private String unidadMedida;
    private double peso;
    private String categoria;
    private int codigo;
    private String tipo; // 1. Gondola, 2. Congelado, 3. Refrigerado, 4. Fresco
    private boolean empaquetado; // true = empaquetado ; false = NO empaquetado
    private String direccionImg;
    private List<List<String>> historial;

    public Producto(String nombre, double precio, double precioPorUnidad,
                    String unidadMedida, double peso,String categoria,
                    String tipo, boolean empaquetado
                    ) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioPorUnidad = precioPorUnidad;
        this.unidadMedida = unidadMedida;
        this.peso = peso;
        this.categoria = categoria;
        this.tipo = tipo;
        this.empaquetado = empaquetado;
        //this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public void setPrecioPorUnidad(double precioPorUnidad) {
        this.precioPorUnidad = precioPorUnidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isEmpaquetado() {
        return empaquetado;
    }

    public void setEmpaquetado(boolean empaquetado) {
        this.empaquetado = empaquetado;
    }

    public String getDireccionImg()
    {
        return direccionImg;
    }

    public void setDireccionImg(String nuevaDireccion)
    {
        direccionImg = nuevaDireccion;
    }

    public void addHistoryProducto(int cantidad, String day)
    {
        boolean adicional = false;
        for (List<String> data : historial)
        {
            if(data.get(1).equals(day))
            {
                int cantidadActual = Integer.parseInt(data.get(0));
                data.set(0, String.valueOf(cantidadActual+1));
                adicional = true;
            }
        }
        if(!adicional)
        {
            List<String> historialDay = new ArrayList<>();
            historialDay.add(String.valueOf(cantidad));
            historialDay.add(day);
            historial.add(historialDay);
        }
    }

    public void setHistorialProducto(String Phistorial)
    {
        List<List<String>> historialCompleto = new ArrayList<>();
        String[] partes = Phistorial.split("-");
        for (String parte : partes)
        {
            List<String> datosInd = new ArrayList<>();
            String[] secciones = parte.split(" ");
            datosInd.add(secciones[0]);
            //System.out.println(secciones[0]);
            datosInd.add(secciones[1]);
            System.out.println("");
            historialCompleto.add(datosInd);
        }
        historial = historialCompleto;
    }

    public String getHistorialProductos()
    {
        int counter = 0;
        String historialTotal = "";
        for (List<String> secciones : historial)
        {
            historialTotal += secciones.get(0);
            historialTotal += " ";
            historialTotal += secciones.get(1);
            if (counter < historial.size()-1)
            {
                historialTotal += "-";
            }
            counter += 1;
        }
        return historialTotal;
    }

    public List<List<String>> getHistorialProductoLista()
    {
        return historial;
    }

}
