package com.back.back_end.productos;

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

import java.util.*;

@RestController
@CrossOrigin(origins = {"http://localhost:4200, http://localhost:8080"})
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductoService service;

    //getAll
    @GetMapping("/listar")
    public List<Productos> getAll(){
        return service.getAll();
    }

    //get by id
    @GetMapping("/{id}")
    public Productos getById(@PathVariable Long id){
        return service.getByIdProducto(id);
    }

    //create
    @PostMapping("/crear")
    public Productos addProductos(@RequestBody Productos productos){
        return service.addProductos(productos);
    }

    //update
    @PutMapping("/{id}")
    public Productos updateProducto(@PathVariable Long id, @RequestBody Productos productoDitail){
        return service.updateProducto(id, productoDitail);
    }

    @DeleteMapping("/{id}")
    public HashMap<String, Boolean> delete(@PathVariable Long id) {
        
        service.deleteProducto(id);
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
}
