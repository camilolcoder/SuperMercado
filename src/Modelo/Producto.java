package Modelo;

public class Producto {

    private String nombre;
    private double precio;
    private double precioPorUnidad;
    private String unidadMedida;
    private double peso;
    private String fresco;
    private String categoria;
    private String codigo;

    public Producto(String nombre, double precio, double precioPorUnidad,
                    String unidadMedida, double peso, String fresco, String categoria,
                    String codigo) {
        this.nombre = nombre;
        this.precio = precio;
        this.precioPorUnidad = precioPorUnidad;
        this.unidadMedida = unidadMedida;
        this.peso = peso;
        this.fresco = fresco;
        this.categoria = categoria;
        this.codigo = codigo;
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

    public String isFresco() {
        return fresco;
    }

    public void setFresco(String fresco) {
        this.fresco = fresco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
