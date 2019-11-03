/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;
import java.sql.Date;

/**
 *
 * @author portatil
 */
public class Ave {

    private String anilla, especie, lugar;

    private String fecha;

    public Ave(String anilla, String especie, String lugar, String fecha) {
        super();
        this.anilla = anilla;
        this.especie = especie;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    /**
     * @return the anilla
     */
    public String getAnilla() {
        return anilla;
    }

    /**
     * @param anilla the anilla to set
     */
    public void setAnilla(String anilla) {
        this.anilla = anilla;
    }

    /**
     * @return the especie
     */
    public String getEspecie() {
        return especie;
    }

    /**
     * @param especie the especie to set
     */
    public void setEspecie(String especie) {
        this.especie = especie;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

}
