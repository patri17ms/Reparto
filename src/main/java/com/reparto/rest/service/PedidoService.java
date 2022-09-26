package com.reparto.rest.service;

import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;

public interface PedidoService {

    /**
     * Obtener la posicion de un número de pedido .
     *
     * @param numeroPedido the numero pedido
     * @return the pedido informacion
     */
    public PedidoInformacion obtenerPosicionPedido(Integer numeroPedido);
    
    /**
     * Inserta un nuevo pedido.
     *
     * @param pedidoNuevo the pedido nuevo
     * @return the pedido DTO
     */
    public PedidoDTO insertarPedido(PedidoNuevo pedidoNuevo);
    
    /**
     * Elimina un pedido.
     *
     * @param numeroPedido the numero pedido
     */
    public void eliminarPedido(Integer numeroPedido);

}
