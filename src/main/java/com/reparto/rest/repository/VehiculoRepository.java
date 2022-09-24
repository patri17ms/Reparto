package com.reparto.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reparto.rest.entity.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    Vehiculo findByNumero(Integer numeroPedido);
    
    List<Vehiculo> findAll();
    
    
}
