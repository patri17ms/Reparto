package com.reparto.rest.service;

import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;

public interface PedidoService {

    public PedidoInformacion obtenerPosicionPedido(Integer numeroPedido);
    
    public PedidoDTO insertarPedido(PedidoNuevo pedidoNuevo);
    
    public void eliminarPedido(Integer numeroPedido);

}
