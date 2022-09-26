package com.reparto.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reparto.rest.entity.HcoUbicacionVehiculo;

public class HcoUbicacionVehiculoDTO {

    /** The id. */
    @JsonIgnore
    private Long id;
    
    /** The latitud. */
    private Double latitud;
    
    /** The longitud. */
    private Double longitud;
    
    
    public HcoUbicacionVehiculoDTO(HcoUbicacionVehiculo hco) {
        super();
        this.id = hco.getId();
        this.latitud = hco.getLatitud();
        this.longitud = hco.getLongitud();
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
