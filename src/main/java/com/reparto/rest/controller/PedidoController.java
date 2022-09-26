package com.reparto.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;
import com.reparto.rest.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    /**
     * Obtiene la posición de un determinado pedido utilizando como parámetro de entrar el número de pedido
     *
     * @param numeroPedido the numero pedido
     * @return Devuelve la información de un número de pedido o un error de que no encuentra el pedido
     */
    @GetMapping("/posicionPedido")
    public ResponseEntity<PedidoInformacion> obtenerPosicionPedido(@RequestParam(value = "numeroPedido") Integer numeroPedido){
        return new ResponseEntity<>(pedidoService.obtenerPosicionPedido(numeroPedido), HttpStatus.OK);
    }
    
    
    /**
     * Inserta un nuevo pedido
     *
     * @param pedidoNuevo the pedido nuevo
     * @return Devuelve el nuevo pedido o un error avisando de que ese número de pedido ya existe
     */
    @PostMapping("/insertarPedido")
    public ResponseEntity<PedidoDTO> insertarPedido(@RequestBody PedidoNuevo pedidoNuevo) {
        return ResponseEntity.ok(pedidoService.insertarPedido(pedidoNuevo));
    }
    
    /**
     * Elimina un pedido
     *
     * @param numeroPedido the numero pedido
     * @return Devuelve un HttpStatus.OK o un error avisando de que el pedido que se quiere eliminar no existe.
     */
    @DeleteMapping("/eliminarPedido")
    public ResponseEntity<Void> eliminarPedido(@RequestParam Integer numeroPedido) {
        pedidoService.eliminarPedido(numeroPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
