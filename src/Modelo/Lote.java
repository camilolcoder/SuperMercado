package Modelo;

public class Lote {

    private int id;
    private String fechaEntrada;
    private String fechaVencimiento;
    private int codigoProducto;
    private double precioPagado;
    private double ventaPublico;
    private int unidades;
    private int unidadesVendidas;
    private double peso;

    public Lote(int id, String fechaEntrada, String fechaVencimiento, int codigoProducto,
                double precioPagado, double ventaPublico, int unidades, int unidadesVendidas,
                double peso) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoProducto = codigoProducto;
        this.precioPagado = precioPagado;
        this.ventaPublico = ventaPublico;
        this.unidades = unidades;
        this.unidadesVendidas = unidadesVendidas;
        this.peso = peso;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public double getPrecioPagado() {
        return precioPagado;
    }

    public void setPrecioPagado(double precioPagado) {
        this.precioPagado = precioPagado;
    }

    public double getVentaPublico() {
        return ventaPublico;
    }

    public void setVentaPublico(double ventaPublico) {
        this.ventaPublico = ventaPublico;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getUnidadesVendidas() { return unidadesVendidas; }

    public void setUnidadesVendidas(int unidadesVendidas) { this.unidadesVendidas = unidadesVendidas; }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void updateUnidades()
    {
        unidades -= 1;
        unidadesVendidas += 1;
    }

    public void updateNoEmpaquetado(double pesoResta)
    {
        peso -= pesoResta;
    }
}
