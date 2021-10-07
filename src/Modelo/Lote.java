package Modelo;

public class Lote {

    private int id;
    private String fechaEntrada;
    private String fechaVencimiento;
    private String codigoProducto;
    private double precioPagado;
    private double ventaPublico;
    private int unidades;

    public Lote(int id, String fechaEntrada, String fechaVencimiento, String codigoProducto,
                double precioPagado, double ventaPublico, int unidades) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoProducto = codigoProducto;
        this.precioPagado = precioPagado;
        this.ventaPublico = ventaPublico;
        this.unidades = unidades;
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

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setProducto(String codigoProducto) {
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
}
