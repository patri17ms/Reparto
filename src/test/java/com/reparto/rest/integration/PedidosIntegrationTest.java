package com.reparto.rest.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.PedidoInformacion;
import com.reparto.rest.model.PedidoNuevo;

public class PedidosIntegrationTest extends BaseIntegrationTest{

    @Test
    public void obtenerPosicionPedido() {
        String url = "http://localhost:" + port;
        String testUrl = url + "/pedidos/posicionPedido";
        
        Integer numeroPedido = 7;
        
        UriComponentsBuilder ucb = UriComponentsBuilder.fromHttpUrl(testUrl)
                .queryParam("numeroPedido", numeroPedido);
        
        final ResponseEntity<PedidoInformacion> response = 
                this.restTemplate.getForEntity(ucb.toUriString(), PedidoInformacion.class);
        
        assertEquals(7, response.getBody().getNumeroPedido());
    }
    
    @Test
    public void insertarPedido() {
        String url = "http://localhost:" + port;
        String testUrl = url + "/pedidos/insertarPedido";
        
        PedidoNuevo pedidoNuevo = new PedidoNuevo();
        pedidoNuevo.setNumeroPedido(9999999);
        pedidoNuevo.setNumeroVehiculo(7);
       
        final ResponseEntity<PedidoDTO> response = this.restTemplate.postForEntity(testUrl, pedidoNuevo, PedidoDTO.class);
        
        assertNotNull(response);
    }
    
    @Test
    public void eliminarPedido() {
        String url = "http://localhost:" + port;
        String testUrl = url + "/pedidos/eliminarPedido";
        
        Integer numeroPedido = 9999999;
        
        UriComponentsBuilder ucb = UriComponentsBuilder.fromHttpUrl(testUrl)
                .queryParam("numeroPedido", numeroPedido);
        
        Map<String, Integer> params = new HashMap < String, Integer > ();
        params.put("numeroPedido", numeroPedido);
        
        this.restTemplate.delete(testUrl, params);
        
    }
}
