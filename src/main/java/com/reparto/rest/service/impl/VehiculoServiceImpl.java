package com.reparto.rest.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.reparto.rest.entity.HcoUbicacionVehiculo;
import com.reparto.rest.entity.Vehiculo;
import com.reparto.rest.exception.BadRequestException;
import com.reparto.rest.model.HcoUbicacionVehiculoDTO;
import com.reparto.rest.model.PedidoDTO;
import com.reparto.rest.model.VehiculoDTO;
import com.reparto.rest.model.VehiculoNuevo;
import com.reparto.rest.model.VehiculoUbicacion;
import com.reparto.rest.repository.HcoUbicacionVehiculoRepository;
import com.reparto.rest.repository.VehiculoRepository;
import com.reparto.rest.service.VehiculoService;

@Service
public class VehiculoServiceImpl implements VehiculoService{
    

    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @Autowired
    private HcoUbicacionVehiculoRepository hcoUbicacionVehiculoRepository;
    
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
        
        //Comprobar si existe ese número de vehículo
        Vehiculo vehiculoBBDD = vehiculoRepository.findByNumero(vehiculoNuevo.getNumeroVehiculo());
        if(!Objects.isNull(vehiculoBBDD)) {
            throw new BadRequestException("El vehículo que está intentando crear ya existe.");
        }
        
        LocalDate date = LocalDate.now();
        Date fecha = java.sql.Date.valueOf(date);
        
        VehiculoDTO result = new VehiculoDTO();
        Vehiculo entityVehiculo = new Vehiculo();
        entityVehiculo.setNumero(vehiculoNuevo.getNumeroVehiculo());
        entityVehiculo.setLongitud(vehiculoNuevo.getLongitud());
        entityVehiculo.setLatitud(vehiculoNuevo.getLatitud());
        entityVehiculo.setFecha(fecha);
        
        Vehiculo resultSave = vehiculoRepository.save(entityVehiculo);
        
        if(Objects.nonNull(resultSave)) {
            result = new VehiculoDTO(resultSave);
        }
        
        return result;
    }
    
    @Override
    public VehiculoUbicacion actualizarUbicacion(VehiculoUbicacion datosActualizar) {
        
        VehiculoUbicacion result = new VehiculoUbicacion();
        
        //Buscar vehiculo para ver si existe
        Vehiculo vehiculo = vehiculoRepository.findByNumero(datosActualizar.getNumeroVehiculo());
        
        if(Objects.isNull(vehiculo)) {
            throw new BadRequestException("El vehículo para el cual intenta actualizar la ubicación no existe.");
        }
        
      //Guardar el HCO
        HcoUbicacionVehiculo hcoUbicacionVehiculo = new HcoUbicacionVehiculo();
        hcoUbicacionVehiculo.setLatitud(vehiculo.getLatitud());
        hcoUbicacionVehiculo.setLongitud(vehiculo.getLongitud());
        hcoUbicacionVehiculo.setVehiculo(vehiculo);
        hcoUbicacionVehiculo.setFecha(vehiculo.getFecha());
        
        hcoUbicacionVehiculoRepository.save(hcoUbicacionVehiculo);
        
        VehiculoDTO vehiculoActualizado = new VehiculoDTO(vehiculo);
        
        
        //Actulizamos sus datos
        if(Objects.nonNull(datosActualizar.getLatitud()) && Objects.nonNull(datosActualizar.getLongitud())) {
            LocalDate date = LocalDate.now();
            Date fecha = java.sql.Date.valueOf(date);
            vehiculoActualizado.setLongitud(datosActualizar.getLongitud());
            vehiculoActualizado.setLatitud(datosActualizar.getLatitud());
            vehiculoActualizado.setFecha(fecha);
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
    
    @Override
    public List<HcoUbicacionVehiculoDTO> obtenerHistorialUbicacion(Integer numeroVehiculo, String fechaString){
        
        List<HcoUbicacionVehiculoDTO> resultado = new ArrayList<HcoUbicacionVehiculoDTO>(0);
        
        List<HcoUbicacionVehiculo> listadoUbicaciones = new ArrayList<HcoUbicacionVehiculo>(0);
        
        String textoError = "";
        
        if(Objects.isNull(fechaString)) {
            listadoUbicaciones.addAll(hcoUbicacionVehiculoRepository.obtenerHCOUbicacionesVehiculo(numeroVehiculo));
        }else {       
            
            Date fecha = convertToSqlDate(fechaString);      
            listadoUbicaciones.addAll(hcoUbicacionVehiculoRepository.obtenerHCOUbicacionesPorFechayVehiculo(numeroVehiculo, fecha));
            textoError = textoError +" en esta fecha";
   
        }
        
        if(CollectionUtils.isEmpty(listadoUbicaciones)) {
            throw new BadRequestException("No existe histórico de ubicaciones para este número de vehículo"+textoError);
        }
        
        resultado.addAll(listadoUbicaciones.stream().map(HcoUbicacionVehiculoDTO::new).collect(Collectors.toList()));
        
        return resultado;
        
        
    }
    
    
    /**
     * Convierte una fecha que viene como string a java.sql.Date
     *
     * @param dateString the date string
     * @return the date
     */
    private Date convertToSqlDate(String dateString) {

        java.sql.Date date = null;
        try {
            date = Objects.isNull(dateString) ? null
                    : new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(dateString).getTime());
        } catch (ParseException e) {

        }

        return date;
    }
    
    
}
