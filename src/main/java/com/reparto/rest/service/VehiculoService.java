package com.reparto.rest.service;

import java.util.List;

import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.model.HcoUbicacionVehiculoDTO;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.model.VehiculoUbicacion;

public interface VehiculoService {

    public List<VehiculoDTO> findAll();
    
    public VehiculoDTO obtenerUbicacion(Integer numeroVehiculo);
    
    public VehiculoDTO insertarVehiculo(VehiculoNuevo vehiculoNuevo);
    
    public VehiculoUbicacion actualizarUbicacion(VehiculoUbicacion datosActualizar);
    
    public List<HcoUbicacionVehiculoDTO> obtenerHistorialUbicacion(Integer numeroVehiculo);
}
