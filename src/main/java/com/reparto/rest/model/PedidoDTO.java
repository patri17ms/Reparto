package com.reparto.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reparto.rest.entity.Pedido;

public class PedidoDTO {

    @JsonIgnore
    private Long id;
    
    private Integer numero;
    
    private boolean entregado;
    
    @JsonIgnore
    private Integer numeroVehiculo;
    
    
    /**

    public PedidoDTO(Long id, Integer numero, boolean entregado) {
        super();
        this.id = id;
        this.numero = numero;
        this.entregado = entregado;
    }*/

    public PedidoDTO(Pedido p) {
        super();
        this.id = p.getId();
        this.numero = p.getNumero();
        this.entregado = p.isEntregado();
    }

    public PedidoDTO() {
        super();
        // TODO Auto-generated constructor stub
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
     * @return the entregado
     */
    public boolean isEntregado() {
        return entregado;
    }

    /**
     * @param entregado the entregado to set
     */
    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
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

    

    
    
}
