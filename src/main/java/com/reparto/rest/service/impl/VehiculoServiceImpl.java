package com.reparto.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.exception.BadRequestException;
import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.model.VehiculoUbicacion;
import com.reparto.rest.repository.VehiculoRepository;
import com.reparto.rest.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @Override
    public List<VehiculoDTO> findAll(){
        
        List<VehiculoDTO> vehiculosDTOList = new ArrayList<VehiculoDTO>(0);
        
        List<Vehiculo> vehiculosList = vehiculoRepository.findAll();
        
        if(!CollectionUtils.isEmpty(vehiculosList)) {
            vehiculosDTOList.addAll(vehiculosList.stream().map(VehiculoDTO::new).collect(Collectors.toList()));
        }
        
        return vehiculosDTOList;
    }
    
    @Override
    public VehiculoDTO obtenerUbicacion(Integer numeroVehiculo){
        
        VehiculoDTO resultado = new VehiculoDTO();
        
        Vehiculo vehiculo = vehiculoRepository.findByNumero(numeroVehiculo);
        
        if(Objects.isNull(vehiculo)) {
            throw new BadRequestException("El vehículo que está buscando no existe.");
        }
        
        if(Objects.nonNull(vehiculo)) {
            
            List<PedidoDTO> pedidosDTO = new ArrayList<PedidoDTO>();
            if(Objects.nonNull(vehiculo.getPedidos())) {
                pedidosDTO.addAll(vehiculo.getPedidos().stream().map(PedidoDTO::new).collect(Collectors.toList()));
            }
            resultado = new VehiculoDTO(vehiculo);
            resultado.setPedidos(pedidosDTO);
        }
        
        return resultado;
    }

    @Override
    public VehiculoDTO insertarVehiculo(VehiculoNuevo vehiculoNuevo) {
        
        VehiculoDTO result = new VehiculoDTO();
        Vehiculo entityVehiculo = new Vehiculo();
        entityVehiculo.setNumero(vehiculoNuevo.getNumeroVehiculo());
        entityVehiculo.setLongitud(vehiculoNuevo.getLongitud());
        entityVehiculo.setLatitud(vehiculoNuevo.getLatitud());
        
        Vehiculo resultSave = vehiculoRepository.save(entityVehiculo);
        
        if(Objects.nonNull(resultSave)) {
            result = new VehiculoDTO(resultSave);
        }
        
        return result;
    }
    
    @Override
    public VehiculoUbicacion insertarUbicacion(VehiculoUbicacion datosActualizar) {
        
        VehiculoUbicacion result = new VehiculoUbicacion();
        
        //Buscar vehiculo para ver si existe
        Vehiculo vehiculo = vehiculoRepository.findByNumero(datosActualizar.getNumeroVehiculo());
        
        if(Objects.isNull(vehiculo)) {
            throw new BadRequestException("El vehículo para el cual intenta actualizar la ubicación no existe");
        }
        
        VehiculoDTO vehiculoActualizado = new VehiculoDTO(vehiculo);
        
        //Actulizamos sus datos
        if(Objects.nonNull(datosActualizar.getLatitud()) && Objects.nonNull(datosActualizar.getLongitud())) {
            vehiculoActualizado.setLongitud(datosActualizar.getLongitud());
            vehiculoActualizado.setLatitud(datosActualizar.getLatitud());
        }else {
            throw new BadRequestException("Los datos de longitud y latitud no pueden ser vacíos.");
        }
        
        Vehiculo vehiculoSave = new Vehiculo(vehiculoActualizado);
        
        //Guardamos datos actualizados
        Vehiculo resultSave = vehiculoRepository.save(vehiculoSave);
        
        if(Objects.nonNull(resultSave)) {
            result = new VehiculoUbicacion(resultSave);
        }
        
        return result;
        
    }
    
    
}
