package com.reparto.rest.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reparto.rest.entity.HcoUbicacionVehiculo;

public interface HcoUbicacionVehiculoRepository extends JpaRepository<HcoUbicacionVehiculo, Long> {

    /**
     * Obtiene el listado de ubicaciones de un vehiculo buscando por número de vehículo
     *
     * @param numVehiculo the num vehiculo
     * @return the list
     */
    @Query("SELECT hco FROM HcoUbicacionVehiculo hco "
            +"INNER JOIN hco.vehiculo as vehiculo "
            +"WHERE vehiculo.numero = :numVehiculo")
    List<HcoUbicacionVehiculo> obtenerHCOUbicacionesVehiculo(Integer numVehiculo);
    
    /**
     * Obtiene el listado de ubicaciones de un vehiculo buscando por número de vehículo y fecha
     *
     * @param numVehiculo the num vehiculo
     * @param fecha the fecha
     * @return the list
     */
    @Query("SELECT hco FROM HcoUbicacionVehiculo hco "
            +"INNER JOIN hco.vehiculo as vehiculo "
            +"WHERE vehiculo.numero = :numVehiculo "
            +"AND hco.fecha = :fecha")
    List<HcoUbicacionVehiculo> obtenerHCOUbicacionesPorFechayVehiculo(Integer numVehiculo, Date fecha);
}
