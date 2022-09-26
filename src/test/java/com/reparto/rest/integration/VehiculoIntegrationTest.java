package com.reparto.rest.integration;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.reparto.rest.model.VehiculoDTO;

public class VehiculoIntegrationTest extends BaseIntegrationTest{
    
    @Test
    public void obtenerUbicacion() {
        String url = "http://localhost:" + port;
        String testUrl = url + "/vehiculos/buscarVehiculo";
        
        UriComponentsBuilder ucb = UriComponentsBuilder.fromHttpUrl(testUrl)
                .queryParam("numeroVehiculo", 7);
        
        final ResponseEntity<VehiculoDTO> response = 
                this.restTemplate.getForEntity(ucb.toUriString(), VehiculoDTO.class);
        
        assertNotNull(response);
    }
}
