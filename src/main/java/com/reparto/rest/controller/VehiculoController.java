package com.reparto.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.service.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    
    @GetMapping("/listadoVehiculos")
    public ResponseEntity<List<VehiculoDTO>> findAll(){
        return new ResponseEntity<>(vehiculoService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/buscarVehiculo")
    public ResponseEntity<VehiculoDTO> obtenerUbicacion(@RequestParam(value = "numeroVehiculo") Integer numeroVehiculo){
        return new ResponseEntity<>(vehiculoService.obtenerUbicacion(numeroVehiculo), HttpStatus.OK);
    }
    
    @PostMapping("/insertarVehiculo")
    public ResponseEntity<VehiculoDTO> updateParam(@RequestBody VehiculoNuevo vehiculoNuevo) {
        return ResponseEntity.ok(vehiculoService.insertarVehiculo(vehiculoNuevo));
    }
}


