package com.reparto.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reparto.rest.entity.HcoUbicacionVehiculo;

public interface HcoUbicacionVehiculoRepository extends JpaRepository<HcoUbicacionVehiculo, Long> {

    @Query("SELECT hco FROM HcoUbicacionVehiculo hco "
            +"INNER JOIN hco.vehiculo as vehiculo "
            +"WHERE vehiculo.numero = :numVehiculo")
    List<HcoUbicacionVehiculo> obtenerHCOUbicaciones(Integer numVehiculo);
}
