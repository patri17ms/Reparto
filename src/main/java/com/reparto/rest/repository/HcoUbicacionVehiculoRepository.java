package com.reparto.rest.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.reparto.rest.entity.HcoUbicacionVehiculo;

public interface HcoUbicacionVehiculoRepository extends JpaRepository<HcoUbicacionVehiculo, Long> {

    @Query("SELECT hco FROM HcoUbicacionVehiculo hco "
            +"INNER JOIN hco.vehiculo as vehiculo "
            +"WHERE vehiculo.numero = :numVehiculo")
    List<HcoUbicacionVehiculo> obtenerHCOUbicacionesVehiculo(Integer numVehiculo);
    
    @Query("SELECT hco FROM HcoUbicacionVehiculo hco "
            +"INNER JOIN hco.vehiculo as vehiculo "
            +"WHERE vehiculo.numero = :numVehiculo "
            +"AND hco.fecha = :fecha")
    List<HcoUbicacionVehiculo> obtenerHCOUbicacionesPorFechayVehiculo(Integer numVehiculo, Date fecha);
    
    
//    @Query("SELECT hco FROM HcoUbicacionVehiculo hco "
//            +"INNER JOIN FETCH hco.vehiculo as vehiculo "
//            +"WHERE  vehiculo.fecha = :fecha")
//    List<HcoUbicacionVehiculo> prueba(Date fecha);
//    
//    List<HcoUbicacionVehiculo> findBy
}
