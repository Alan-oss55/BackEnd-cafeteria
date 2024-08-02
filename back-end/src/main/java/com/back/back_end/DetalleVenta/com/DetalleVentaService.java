package com.back.back_end.DetalleVenta.com;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.back_end.ResourceNotFoundException;

@Service
public class DetalleVentaService {
    @Autowired DetalleVentaRepository repository;

    //getAll
    public List<DetalleVenta> getAll(){ 
        return repository.findAll();
    }

    //get by id
    public DetalleVenta getByIdVenta(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encontró una venta con el id:" +id));
    }

    //create
    public DetalleVenta addDetalleVenta(DetalleVenta venta){
        return repository.save(venta);
    }

    //update
    public DetalleVenta updateDetalles(Long id, DetalleVenta detallesDilog){
        DetalleVenta detalles = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una venta con el id:" +id));

        detalles.setVenta(detallesDilog.getVenta());
        detalles.setProducto(detallesDilog.getProducto());
        detalles.setPrecio(detallesDilog.getPrecio());
        detalles.setCantidad(detallesDilog.getCantidad());

        return repository.save(detalles);
    }

    //delete
    public Map<String, Boolean> deleteRegistro(Long id){
        repository.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una venta con el id:" +id));
        
        repository.deleteById(id);

        HashMap<String, Boolean>response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
