package com.reparto.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reparto.rest.model.HcoUbicacionVehiculoDTO;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.model.VehiculoUbicacion;
import com.reparto.rest.service.VehiculoService;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    
    /**
     * Recupera el listado de todos los vehículos existentes en base de datos
     * GET Mapping
     *
     * @return Devuelve un listado de vehículos
     */
    @GetMapping("/listadoVehiculos")
    public ResponseEntity<List<VehiculoDTO>> findAll(){
        return new ResponseEntity<>(vehiculoService.findAll(), HttpStatus.OK);
    }
    
    /**
     * Obtiene la ubicación de un determinado vehículo utilizando el número de vehículo como parámetro de consulta
     * GET Mapping.
     *
     * @param numeroVehiculo the numero vehiculo
     * @return Devuelve la información de un vehículo o un error avisando de que el vehículo no existe
     */
    @GetMapping("/buscarVehiculo")
    public ResponseEntity<VehiculoDTO> obtenerUbicacion(@RequestParam(value = "numeroVehiculo") Integer numeroVehiculo){
        return new ResponseEntity<>(vehiculoService.obtenerUbicacion(numeroVehiculo), HttpStatus.OK);
    }
    
    /**
     * Insertar un nuevo vehículo.
     * POST Mapping
     *
     * @param vehiculoNuevo the vehiculo nuevo
     * @return Devuelve el nuevo vehículo
     */
    @PostMapping("/insertarVehiculo")
    public ResponseEntity<VehiculoDTO> insertarVehiculo(@RequestBody VehiculoNuevo vehiculoNuevo) {
        return ResponseEntity.ok(vehiculoService.insertarVehiculo(vehiculoNuevo));
    }
    
    /**
     * Actualiza la ubicación de un vehículo ya existente
     * PUT Mapping
     *
     * @param vehiculoUbicacion the vehiculo ubicacion
     * @return Devuelve el vehículo actualizado o un error avisando de que no se puede actualizar y el motivo.
     */
    @PutMapping("/actualizarUbicacion")
    public ResponseEntity<VehiculoUbicacion> actualizarUbicacion(@RequestBody @Valid VehiculoUbicacion vehiculoUbicacion) {
        return new ResponseEntity<>(vehiculoService.actualizarUbicacion(vehiculoUbicacion), HttpStatus.OK);
    }
    
    /**
     * Obtiene el historial de ubicacion utilizando como parámetro de consulta el número de vehículo.
     *
     * @param numeroVehiculo the numero vehiculo
     * @return Devuelve un listado de ubicaciones o un error avisando de que no hay ubicaciones para ese vehículo.
     */
    @GetMapping("/obtenerHistorialUbicacion")
    public ResponseEntity<List<HcoUbicacionVehiculoDTO>> obtenerHistorialUbicacion(
            @RequestParam(value = "numeroVehiculo") Integer numeroVehiculo,
            @RequestParam(value = "fecha", required = false) String fecha) {
        return new ResponseEntity<>(vehiculoService.obtenerHistorialUbicacion(numeroVehiculo, fecha), HttpStatus.OK);
    }
}


