package com.reparto.rest.service;

import java.util.List;

import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.model.VehiculoUbicacion;

public interface VehiculoService {

    public List<VehiculoDTO> findAll();
    
    public VehiculoDTO obtenerUbicacion(Integer numeroVehiculo);
    
    public VehiculoDTO insertarVehiculo(VehiculoNuevo vehiculoNuevo);
    
    public VehiculoUbicacion insertarUbicacion(VehiculoUbicacion datosActualizar);
}
