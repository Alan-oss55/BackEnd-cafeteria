package com.back.back_end.DetalleVenta.com;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/detalles")
@CrossOrigin(origins = "*")
public class DetalleVentaController {

    @Autowired DetalleVentaService service;

    //getAll
    @GetMapping
    public List<DetalleVenta> getAll(){
        return service.getAll();
    }

    //get by id
    @GetMapping("/{id}")
    public DetalleVenta getById(@PathVariable Long id){
        return service.getByIdVenta(id);
    }

    //create
    @PostMapping
    public DetalleVenta addDetalle(@RequestBody DetalleVenta venta){
        return service.addDetalleVenta(venta);
    }

    //update
    @PutMapping("/{id}")
    public DetalleVenta updateDetalle(@PathVariable Long id, @RequestBody DetalleVenta detalleDitail){
        return service.updateDetalles(id, detalleDitail);
    }

    //delete
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteDetail(@PathVariable Long id){
        return service.deleteRegistro(id);
    }
}