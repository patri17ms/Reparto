package com.reparto.rest.controller;

import java.util.List;

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

import com.reparto.rest.entity.Pedido;
import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @GetMapping("/posicionPedido")
    public ResponseEntity<PedidoInformacion> obtenerPosicionPedido(@RequestParam(value = "numeroPedido") Integer numeroPedido){
        return new ResponseEntity<>(pedidoService.obtenerPosicionPedido(numeroPedido), HttpStatus.OK);
    }
    
    
    @PostMapping("/insertarPedido")
    public ResponseEntity<PedidoDTO> insertarPedido(@RequestBody PedidoNuevo pedidoNuevo) {
        return ResponseEntity.ok(pedidoService.insertarPedido(pedidoNuevo));
    }
    
    @DeleteMapping("/eliminarPedido")
    public ResponseEntity<Void> eliminarPedido(@RequestParam Integer numeroPedido) {
        pedidoService.eliminarPedido(numeroPedido);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

}
