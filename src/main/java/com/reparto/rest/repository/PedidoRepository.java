package com.reparto.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reparto.rest.entity.Pedido;
import com.reparto.rest.entity.Vehiculo;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    /**
     * Recupera un pedido buscando por su número de pedido.
     *
     * @param numeroPedido the numero pedido
     * @return the pedido
     */
    Pedido findByNumero(Integer numeroPedido);
}
