package com.reparto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.service.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    
    @GetMapping("/findAll")
        public ResponseEntity<List<Vehiculo>> findAll(){
            return new ResponseEntity<>(vehiculoService.findAll(), HttpStatus.OK);
        }
        
}


