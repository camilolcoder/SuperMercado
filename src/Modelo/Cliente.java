package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private int edad;
    private String sexo;
    private String estadoCivil;
    private int id;
    private String situacionLaboral;
    private int puntos;
    private List<List<String>> historial;

    public Cliente(String nombre, int edad, String sexo, String estadoCivil, int id, String situacionLaboral) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.id = id;
        this.situacionLaboral = situacionLaboral;
        //this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(String situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void addHistory(double precio, String day)
    {
        List<String> historialDay = new ArrayList<>();
        historialDay.add(String.valueOf(precio));
        historialDay.add(day);
        historial.add(historialDay);
    }

    public void setHistorial(String Phistorial)
    {
        List<List<String>> historialCompleto = new ArrayList<>();
        String[] partes = Phistorial.split("-");
        for (String parte : partes)
        {
            List<String> datosInd = new ArrayList<>();
            String[] secciones = parte.split(" ");
            datosInd.add(secciones[0]);
            datosInd.add(secciones[1]);
            historialCompleto.add(datosInd);
        }
        historial = historialCompleto;
    }

    public String getHistorial()
    {
        String historialTotal = "";
        for (List<String> secciones : historial)
        {
            historialTotal += secciones.get(0);
            historialTotal += secciones.get(1);
            historialTotal += " - ";
        }
        return historialTotal;
    }

    public void sumarPuntos(double dineroGastado)
    {
        double puntosCalculados = Math.round(dineroGastado/1000);
        this.puntos += puntosCalculados;
    }
}
