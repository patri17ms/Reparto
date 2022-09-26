package com.reparto.rest.service;

import java.sql.Date;
import java.util.List;

import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.model.HcoUbicacionVehiculoDTO;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.model.VehiculoUbicacion;

public interface VehiculoService {

    /**
     * Muestra una lista de todos los vehículos existentes.
     *
     * @return the list
     */
    public List<VehiculoDTO> findAll();
    
    /**
     * Obtiene la ubicación de un número de vehículo.
     *
     * @param numeroVehiculo the numero vehiculo
     * @return the vehiculo DTO
     */
    public VehiculoDTO obtenerUbicacion(Integer numeroVehiculo);
    
    /**
     * Inserta un vehículo nuevo.
     *
     * @param vehiculoNuevo the vehiculo nuevo
     * @return the vehiculo DTO
     */
    public VehiculoDTO insertarVehiculo(VehiculoNuevo vehiculoNuevo);
    
    /**
     * Actualiza la ubicación de un vehículo ya existente.
     *
     * @param datosActualizar the datos actualizar
     * @return the vehiculo ubicacion
     */
    public VehiculoUbicacion actualizarUbicacion(VehiculoUbicacion datosActualizar);
    
    /**
     * Obtiene el historial de ubicación de un determinado número de vehículo.
     *
     * @param numeroVehiculo the numero vehiculo
     * @return the list
     */
    public List<HcoUbicacionVehiculoDTO> obtenerHistorialUbicacion(Integer numeroVehiculo, String fecha);
}
