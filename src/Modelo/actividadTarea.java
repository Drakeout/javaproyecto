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
public class actividadTarea extends Actividad{
    private String fecha;
    private boolean terminada;

    public actividadTarea(String fecha, boolean terminada, String nombre, String descripcion) {
        super(nombre, descripcion);
        this.fecha = fecha;
        this.terminada = terminada;
    }

    public actividadTarea() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isTerminada() {
        return terminada;
    }

    public void setTerminada(boolean terminada) {
        this.terminada = terminada;
    }
     
    
}
