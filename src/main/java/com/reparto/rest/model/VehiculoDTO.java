package com.reparto.rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.reparto.rest.entity.Pedido;
import com.reparto.rest.entity.Vehiculo;

public class VehiculoDTO {


    @JsonIgnore
    private Long id;
    
    private Integer numero;
    
    private Double longitud;
    
    private Double latitud;
    
    private List<PedidoDTO> pedidos;
    
    
    

    public VehiculoDTO(Vehiculo v) {
        super();
        this.id = v.getId();
        this.numero = v.getNumero();
        this.longitud = v.getLongitud();
        this.latitud = v.getLatitud();
        this.pedidos = addPedidosDTO(v.getPedidos());
    }

    public VehiculoDTO() {
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
    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    public List<PedidoDTO> addPedidosDTO(Set<Pedido> pedidos) {
        
        //List<Pedido> pedidosEntity = new ArrayList<Pedido>(pedidos);
            
        List<PedidoDTO> resultado = new ArrayList<PedidoDTO>();
        
        
        
        if(!CollectionUtils.isEmpty(pedidos)) {
            resultado.addAll(pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList()));
        }
        
        return resultado;
    }
    
    
}
