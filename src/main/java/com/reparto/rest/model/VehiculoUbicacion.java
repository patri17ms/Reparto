package com.reparto.rest.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reparto.rest.entity.Vehiculo;

public class VehiculoUbicacion {

    private Integer numeroVehiculo;
    private Double latitud;
    private Double longitud;
    @JsonIgnore
    private Date fecha;
    
    
    public VehiculoUbicacion(Vehiculo v) {
        super();
        this.numeroVehiculo = v.getNumero();
        this.latitud = v.getLatitud();
        this.longitud = v.getLongitud();
        this.fecha = v.getFecha();
    }
    public VehiculoUbicacion() {
        
    }
    /**
     * @return the numeroVehiculo
     */
    public Integer getNumeroVehiculo() {
        return numeroVehiculo;
    }
    /**
     * @param numeroVehiculo the numeroVehiculo to set
     */
    public void setNumeroVehiculo(Integer numeroVehiculo) {
        this.numeroVehiculo = numeroVehiculo;
    }
    /**
     * @return the latitud
     */
    public Double getLatitud() {
        return latitud;
    }
    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    /**
     * @return the longitud
     */
    public Double getLongitud() {
        return longitud;
    }
    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }
    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
 
    
    
}
