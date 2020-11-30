/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author felip
 */
public class actividadObjetivo extends Actividad {
    private String primerDia;
    private int repeticiones;

    public actividadObjetivo(String primerDia, int repeticiones, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.primerDia = primerDia;
        this.repeticiones = repeticiones;
    }

    public actividadObjetivo() {
    }

    public String getPrimerDia() {
        return primerDia;
    }

    public void setPrimerDia(String primerDia) {
        this.primerDia = primerDia;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }
    
    
    
}
