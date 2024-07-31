package com.back.back_end.categorias;

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
@CrossOrigin(origins = "*")
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    //getAll
    @GetMapping("/listar")
    public List<Categoria> getAll(){
        return service.getAll();
    }

    //get By Id
    @GetMapping("/{id}")
    public Categoria getById(@PathVariable Long id){
        return service.getByIdCategoria(id);
    }


    //Create
    @PostMapping("/crear")
    public Categoria createCategoria(@RequestBody Categoria categoria){
        return service.addCategoria(categoria);
    }

    //update
    @PutMapping("/{id}")
    public Categoria updateCategoriaCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDitail){
        return service.updateCategoria(id, categoriaDitail);
    }

    @DeleteMapping("/{id}")
    public HashMap<String, Boolean> delete(@PathVariable Long id) {
        service.deleteCategoria(id);
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
   
}
