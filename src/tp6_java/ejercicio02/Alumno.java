package tp6_java.ejercicio02;

import java.util.ArrayList;

public class Alumno {
    private String nombreCompleto;
    private long legajo;
    private ArrayList<Nota> notas;

    public void addNota(Nota nota){
        if(this.notas == null){
            this.notas = new ArrayList<Nota>();
        }
        this.notas.add(nota);
    }

    public double promedio(){
        double suma = 0;
        for (Nota nota: this.notas) {
            suma += nota.getNotaExamen();
        }
        return suma/this.notas.size();
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public long getLegajo() {
        return legajo;
    }

    public void setLegajo(long legajo) {
        this.legajo = legajo;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }
}
