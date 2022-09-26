package com.reparto.rest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.reparto.rest.entity.Pedido;
import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.exception.BadRequestException;
import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;
import com.reparto.rest.repository.PedidoRepository;
import com.reparto.rest.repository.VehiculoRepository;
import com.reparto.rest.service.impl.PedidoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceUnitTest {
    
    @InjectMocks
    private PedidoServiceImpl pedidoService;
    
    @Mock
    private PedidoRepository pedidoRepository;
    
    @Mock
    private VehiculoRepository vehiculoRepository;
    
    @Test
    public void obtenerPosicionPedido_BadRequest() {
        
        try {
            pedidoService.obtenerPosicionPedido(Mockito.anyInt());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "El número de pedido para el cual intenta obtener la posición no existe");
        }
    }
    
    @Test
    public void obtenerPosicionPedidoOk() {
        Mockito.when(pedidoRepository.findByNumero(Mockito.anyInt())).thenReturn(getPedidoBBDD());
       
        PedidoInformacion resultado = pedidoService.obtenerPosicionPedido(Mockito.anyInt());
        
        assertEquals(6.2, resultado.getLatitud());
    }
    
    @Test
    public void insertarPedido_BadRequest() {
        Mockito.when(pedidoRepository.findByNumero(Mockito.anyInt())).thenReturn(getPedidoBBDD());
        try {
            pedidoService.insertarPedido(getPedidoNuevo());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "El número de pedido que está intentando insertar ya existe");
        }
    }
    
    @Test
    public void insertarPedido_NoExisteVehiculo() {
        try {
            pedidoService.insertarPedido(getPedidoNuevo());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "El vehículo para el que quiere añadir el pedido no existe. Por favor, crear el vehículo antes de insertar pedido");
        }
    }
    
    @Test
    public void insertarPedido_OK() {
        Mockito.when(vehiculoRepository.findByNumero(Mockito.anyInt())).thenReturn(getVehiculoBBDD());
        Mockito.when(pedidoRepository.save(Mockito.any())).thenReturn(getPedidoBBDD());
        PedidoDTO resultado = pedidoService.insertarPedido(getPedidoNuevo());
        assertEquals(1L, resultado.getId());
    }
    
    @Test
    public void eliminarPedido_BadRequest() {
        try {
            pedidoService.eliminarPedido(Mockito.anyInt());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "El pedido que intenta eliminar no existe");
        }
    }
    
    @Test
    public void eliminarPedido_OK() {
        Mockito.when(pedidoRepository.findByNumero(Mockito.anyInt())).thenReturn(getPedidoBBDD());
        pedidoService.eliminarPedido(Mockito.anyInt());
        verify(pedidoRepository, times(1)).delete(Mockito.any());
    }
    
    private Pedido getPedidoBBDD() {
        Pedido pedido = new Pedido();
        pedido.setNumero(1);
        pedido.setId(1L);
        pedido.setDestinatario("Dest Prueba");
        pedido.setDireccionEntrega("Dir prueba");
        
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        vehiculo.setLongitud(36.5);
        vehiculo.setLatitud(6.2);        
        pedido.setVehiculo(vehiculo);
        
        return pedido;
    }
    
    private PedidoNuevo getPedidoNuevo() {
        PedidoNuevo pedidoNuevo = new PedidoNuevo();
        pedidoNuevo.setNumeroPedido(2);
        pedidoNuevo.setNumeroVehiculo(3);
        pedidoNuevo.setDestinatario("Dest Prueba");
        pedidoNuevo.setDireccionEntrega("Dir prueba");
        return pedidoNuevo;
    }
    
    private Vehiculo getVehiculoBBDD() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        vehiculo.setLatitud(3.44);
        vehiculo.setLongitud(24.43);
        return vehiculo;
    }
}
