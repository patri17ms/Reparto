package com.reparto.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reparto.rest.entity.Pedido;

public class PedidoDTO {

    @JsonIgnore
    private Long id;
    
    private Integer numero;
    
    @JsonIgnore
    private Integer numeroVehiculo;
    
    private String direccionEntrega;
    
    private String destinatario;

    public PedidoDTO(Pedido p) {
        super();
        this.id = p.getId();
        this.numero = p.getNumero();
        this.direccionEntrega = p.getDireccionEntrega();
        this.destinatario= p.getDestinatario();
    }

    public PedidoDTO() {
        super();
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
     * @return the direccionEntrega
     */
    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    /**
     * @param direccionEntrega the direccionEntrega to set
     */
    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    /**
     * @return the destinatario
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * @param destinatario the destinatario to set
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    
}
