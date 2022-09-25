package com.reparto.rest.model;

import com.reparto.rest.entity.Vehiculo;

public class VehiculoUbicacion {

    private Integer numeroVehiculo;
    private Double latitud;
    private Double longitud;
    
    
    
    public VehiculoUbicacion(Vehiculo v) {
        super();
        this.numeroVehiculo = v.getNumero();
        this.latitud = v.getLatitud();
        this.longitud = v.getLongitud();
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
 
    
    
}
