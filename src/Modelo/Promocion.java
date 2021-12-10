package Modelo;

public class Promocion {

    private int codigoProducto;
    private String fechaInicial;
    private String fechaFinal;
    private String tipoPromocion;

    public Promocion(int codigoProducto, String fechaInicial, String fechaFinal, String tipoPromocion) {
        this.codigoProducto = codigoProducto;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.tipoPromocion = tipoPromocion;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(String fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }
}
