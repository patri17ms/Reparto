package com.reparto.rest.service.impl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reparto.rest.entity.Pedido;
import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.repository.PedidoRepository;
import com.reparto.rest.repository.VehiculoRepository;
import com.reparto.rest.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public PedidoInformacion obtenerPosicionPedido(Integer numeroPedido){
        
        PedidoInformacion resultado = new PedidoInformacion();
        
        Pedido pedidoResultado = pedidoRepository.findByNumero(numeroPedido);
        
        if(Objects.nonNull(pedidoResultado)) {
            PedidoDTO pedidoDTO = new PedidoDTO(pedidoResultado);
            
            VehiculoDTO vehiculoDTO = new VehiculoDTO(pedidoResultado.getVehiculo());
            
            if(Objects.nonNull(pedidoDTO) && Objects.nonNull(vehiculoDTO)) {
                resultado.setNumeroPedido(pedidoDTO.getNumero());
                resultado.setNumeroVehiculo(vehiculoDTO.getNumero());
                resultado.setLongitud(vehiculoDTO.getLongitud());
                resultado.setLatitud(vehiculoDTO.getLatitud());
            }
        }
       
        
        
        return resultado;
    }
    
    
    @Override
    public PedidoDTO insertarPedido(PedidoNuevo pedidoNuevo) {
        
        PedidoDTO result = new PedidoDTO();
        
        Pedido entityPedido = new Pedido();
        entityPedido.setEntregado(false);
        entityPedido.setNumero(pedidoNuevo.getNumeroPedido());
       
        
        Vehiculo vehiculo = vehiculoRepository.findByNumero(pedidoNuevo.getNumeroVehiculo());
        
        if(Objects.nonNull(vehiculo)) {
            entityPedido.setVehiculo(vehiculo);
        }
        
        Pedido resultSave = pedidoRepository.save(entityPedido);
        
        if(Objects.nonNull(result)) {
            result = new PedidoDTO(resultSave);
        }
        
        return result;
    }
}
