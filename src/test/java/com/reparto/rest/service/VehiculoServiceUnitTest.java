package com.reparto.rest.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.reparto.rest.entity.HcoUbicacionVehiculo;
import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.exception.BadRequestException;
import com.reparto.rest.model.HcoUbicacionVehiculoDTO;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.model.VehiculoUbicacion;
import com.reparto.rest.repository.HcoUbicacionVehiculoRepository;
import com.reparto.rest.repository.VehiculoRepository;
import com.reparto.rest.service.impl.VehiculoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class VehiculoServiceUnitTest {

    @InjectMocks
    private VehiculoServiceImpl vehiculoService;
    
    @Mock
    private VehiculoRepository vehiculoRepository;
    
    @Mock
    private HcoUbicacionVehiculoRepository hcoUbicacionVehiculoRepository;
    
    @Test
    public void findAll() {
        
        Mockito.when(vehiculoRepository.findAll()).thenReturn(getVehiculosBBDD());
        
        List<VehiculoDTO> listadoVehiculos = vehiculoService.findAll();
        
        assertEquals(17, listadoVehiculos.get(0).getNumero());
        
    }
    
    @Test
    public void obtenerUbicacion_BadRequest() {
        try {
            vehiculoService.obtenerUbicacion(Mockito.anyInt());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "El vehículo que está buscando no existe.");
        }
    }
    
    @Test
    public void obtenerUbicacion_OK() {
        Mockito.when(vehiculoRepository.findByNumero(Mockito.anyInt())).thenReturn( getVehiculosBBDD().get(0));
        VehiculoDTO resultado = vehiculoService.obtenerUbicacion(Mockito.anyInt());
        assertNotNull(resultado);
    }
    
    @Test
    public void insertarVehiculo_BadRequest() {
        Mockito.when(vehiculoRepository.findByNumero(Mockito.anyInt())).thenReturn( getVehiculosBBDD().get(0));
        try {
            vehiculoService.insertarVehiculo(getVehiculoNuevo());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "El vehículo que está intentando crear ya existe.");
        }
    }
    
    @Test
    public void insertarVehiculo_OK() {
        Mockito.when(vehiculoRepository.save(Mockito.any())).thenReturn(getVehiculosBBDD().get(0));
        VehiculoDTO resultado = vehiculoService.insertarVehiculo(getVehiculoNuevo());
        assertNotNull(resultado);
    }
    
    @Test
    public void actualizarUbicacion_BadRequest() {
        try {
            vehiculoService.actualizarUbicacion(getVehiculoNuevaUbicacion());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "El vehículo para el cual intenta actualizar la ubicación no existe.");
        }
    }
    
    @Test
    public void actualizarUbicacion_BadRequest_FaltanDatos() {
        VehiculoUbicacion ubicacionVehiculo = getVehiculoNuevaUbicacion();
        ubicacionVehiculo.setLatitud(null);
        
        Mockito.when(vehiculoRepository.findByNumero(Mockito.anyInt())).thenReturn( getVehiculosBBDD().get(0));
        
        try {
            vehiculoService.actualizarUbicacion(ubicacionVehiculo);
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "Los datos de longitud y latitud no pueden ser vacíos.");
        }
    }
    
    @Test
    public void actualizarUbicacion_OK() {
        Mockito.when(vehiculoRepository.findByNumero(Mockito.anyInt())).thenReturn( getVehiculosBBDD().get(0));
        Mockito.when(vehiculoRepository.save(Mockito.any())).thenReturn(getVehiculosBBDD().get(0));    
        VehiculoUbicacion resultado = vehiculoService.actualizarUbicacion(getVehiculoNuevaUbicacion());
        assertEquals(17, resultado.getNumeroVehiculo());
        
    }
    
    @Test
    public void obtenerHistorialUbicacion_BadRequest() {
        try {
            vehiculoService.obtenerHistorialUbicacion(Mockito.anyInt(), Mockito.anyString());
        }catch (BadRequestException e) {
            assertEquals(e.getReason(), "No existe histórico de ubicaciones para este número de vehículo en esta fecha");
        }
    }
    
    @Test
    public void obtenerHistorialUbicacion_OK() {
        Mockito.when(hcoUbicacionVehiculoRepository
                .obtenerHCOUbicacionesVehiculo(Mockito.anyInt())).thenReturn(getListadoHcoUbicacionVehiculo());
        
        List<HcoUbicacionVehiculoDTO> resultado = vehiculoService.obtenerHistorialUbicacion(Mockito.anyInt(),null);
        assertNotNull(resultado.get(0));
    }
    
    private List<Vehiculo> getVehiculosBBDD(){
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>(0);
        
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setId(1L);
        vehiculo.setLongitud(36.5);
        vehiculo.setLatitud(6.2); 
        vehiculo.setNumero(17);
        
        vehiculos.add(vehiculo);
        
        return vehiculos;
    }
    
    private VehiculoNuevo getVehiculoNuevo() {
        VehiculoNuevo vehiculoNuevo = new VehiculoNuevo();
        vehiculoNuevo.setNumeroVehiculo(17);
        vehiculoNuevo.setLatitud(14.56);
        vehiculoNuevo.setLatitud(65.3);
        return vehiculoNuevo;
    }
    
    
    private VehiculoUbicacion getVehiculoNuevaUbicacion() {
        VehiculoUbicacion vehiculoUbicacion = new VehiculoUbicacion();
        vehiculoUbicacion.setNumeroVehiculo(20);
        vehiculoUbicacion.setLatitud(38.0);
        vehiculoUbicacion.setLongitud(9.03);
        return vehiculoUbicacion;
    }
    
    private List<HcoUbicacionVehiculo> getListadoHcoUbicacionVehiculo() {
        List<HcoUbicacionVehiculo> listadoUbicaciones = new ArrayList<HcoUbicacionVehiculo>();
        
        HcoUbicacionVehiculo hcoUbicacionVehiculo = new HcoUbicacionVehiculo();
        hcoUbicacionVehiculo.setLatitud(65.2);
        hcoUbicacionVehiculo.setLongitud(5.6);
        listadoUbicaciones.add(hcoUbicacionVehiculo);
        
        return listadoUbicaciones;
    }
    
//    private List<HcoUbicacionVehiculo> getListadoUbicaciones(){
//        List<HcoUbicacionVehiculo> listadoUbicaciones = new ArrayList<HcoUbicacionVehiculo>();
//        
//    }
    
}
