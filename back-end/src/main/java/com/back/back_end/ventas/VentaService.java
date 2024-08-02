package com.back.back_end.ventas;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.back_end.ResourceNotFoundException;

@Service
public class VentaService {
    @Autowired VentasRepository repository;

    //get All
    public List<Ventas> getAll(){
        return repository.findAll();
    }

    //get by id 
    public Ventas getByIdVentas(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una venta con el id" + id));
    }

    //create
    public Ventas addVenta(Ventas ventas){
        return repository.save(ventas);
    }

    //update
    public Ventas updateVenta(Long id, Ventas ventaDilog){
        Ventas updateVenta = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una venta con el id" +id));
        
        updateVenta.setUsuario(ventaDilog.getUsuario());
        updateVenta.setTotal(ventaDilog.getTotal());
        updateVenta.setEstado(ventaDilog.getEstado());
        return repository.save(updateVenta);
    }

    //delete
    public Map<String, Boolean> deleteVenta(Long id){
        repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una venta con el id:" + id));

        repository.deleteById(id);

        HashMap<String, Boolean>response =  new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
