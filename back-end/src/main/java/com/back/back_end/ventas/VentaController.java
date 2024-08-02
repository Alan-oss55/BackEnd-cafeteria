package com.back.back_end.ventas;

import java.util.List;
import java.util.Map;

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
@RequestMapping("/api/v1/venta")
@CrossOrigin(origins = "*")
public class VentaController {
    @Autowired VentaService service;

    //getAll
    @GetMapping
    public List<Ventas> getAll(){
        return service.getAll();
    }

    //get by id
    @GetMapping("/{id}")
    public Ventas getByIdVenta(@PathVariable Long id){
        return service.getByIdVentas(id);
    }

    //create
    @PostMapping
    public Ventas addVentas(@RequestBody Ventas ventas){
        return service.addVenta(ventas);
    }

    //update
    @PutMapping("/{id}")
    public Ventas updateVentas(@PathVariable Long id, @RequestBody Ventas ventaDilog){
        return service.updateVenta(id, ventaDilog);
    }

    //delete
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteVenta(@PathVariable Long id){
        return service.deleteVenta(id);
    }
}