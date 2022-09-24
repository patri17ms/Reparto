package com.reparto.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.repository.VehiculoRepository;
import com.reparto.rest.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @Override
    public List<Vehiculo> findAll(){
        List<Vehiculo> vehiculosList = vehiculoRepository.findAll();
        return vehiculosList;
    }
}
