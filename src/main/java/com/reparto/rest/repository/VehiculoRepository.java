package com.reparto.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reparto.rest.entity.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    /**
     * Recupera un vehiculo buscando por número de vehículo
     *
     * @param numeroPedido the numero pedido
     * @return the vehiculo
     */
    Vehiculo findByNumero(Integer numeroPedido);
    
    /**
     * Devuelve la lista de todos los vehículos guardados
     *
     * @return the list
     */
    List<Vehiculo> findAll();
    
    
}
