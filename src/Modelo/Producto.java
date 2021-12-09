package Modelo;

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
}
