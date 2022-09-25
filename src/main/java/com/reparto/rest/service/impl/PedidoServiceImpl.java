package com.reparto.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reparto.rest.entity.Pedido;
import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.exception.BadRequestException;
import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;
import com.reparto.rest.model.VehiculoDTO;
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
        
        //Buscar si ya existe ese pedido
        Pedido pedidoBBDD = pedidoRepository.findByNumero(pedidoNuevo.getNumeroPedido());
        
        if(!Objects.isNull(pedidoBBDD)) {
            throw new BadRequestException("El número de pedido que está intentando insertar ya existe");
        }
        
        PedidoDTO result = new PedidoDTO();
        
        Pedido entityPedido = new Pedido();
        entityPedido.setEntregado(false);
        entityPedido.setNumero(pedidoNuevo.getNumeroPedido());
       
        
        Vehiculo vehiculo = vehiculoRepository.findByNumero(pedidoNuevo.getNumeroVehiculo());
        
        if(Objects.isNull(vehiculo)) {
            throw new BadRequestException("El vehículo para el que quiere añadir el pedido no existe. Por favor, crear el vehículo antes de insertar pedido");
        }
        
        entityPedido.setVehiculo(vehiculo);
        
        Pedido resultSave = pedidoRepository.save(entityPedido);
        
        if(Objects.nonNull(result)) {
            result = new PedidoDTO(resultSave);
        }
        
        return result;
    }
    
    
    public void eliminarPedido(Integer numeroPedido) {
        //Buscar numeroPedido a ver si existe
        
        Pedido pedido = pedidoRepository.findByNumero(numeroPedido);
        if(Objects.isNull(pedido)) {
            throw new BadRequestException("El pedido no existe");
        }
        
        pedidoRepository.delete(pedido);
    }
    
    
}
