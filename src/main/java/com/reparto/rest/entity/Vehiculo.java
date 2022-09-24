package com.reparto.rest.entity;

import static javax.persistence.FetchType.LAZY;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehiculo")
    private Long id;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "longitud")
    private Double longitud;
    
    @Column(name = "latitud")
    private Double latitud;
    
    @OneToMany(mappedBy = "vehiculo", fetch = LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private Set<Pedido> pedidos;
    
    @OneToMany(mappedBy = "vehiculo", fetch = LAZY, cascade = { CascadeType.MERGE, CascadeType.PERSIST })
    private Set<HcoUbicacionVehiculo> hcoUbicaciones;

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
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
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
     * @return the pedidos
     */
    public Set<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the hcoUbicaciones
     */
    public Set<HcoUbicacionVehiculo> getHcoUbicaciones() {
        return hcoUbicaciones;
    }

    /**
     * @param hcoUbicaciones the hcoUbicaciones to set
     */
    public void setHcoUbicaciones(Set<HcoUbicacionVehiculo> hcoUbicaciones) {
        this.hcoUbicaciones = hcoUbicaciones;
    }
    
    
    
}
