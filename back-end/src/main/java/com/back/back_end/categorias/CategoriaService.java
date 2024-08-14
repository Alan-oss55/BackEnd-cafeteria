package com.back.back_end.categorias;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.back_end.ResourceNotFoundException;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository repository;

    //getAll
    public List<Categoria> getAll(){
        return repository.findAll();
    }

    //get by id
    public Categoria getByIdCategoria(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una categoria con el id " + id));
    }

    //create
    public Categoria addCategoria(Categoria categoria ){
        return repository.save(categoria);
    }

    //update
    public Categoria updateCategoria(Long id, Categoria categoriaDitail){
        Categoria updateCategoria = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encuentra una categoria con el id " + id));

        updateCategoria.setNombre(categoriaDitail.getNombre());
        updateCategoria.setDescripcion(categoriaDitail.getDescripcion());
        updateCategoria.setImageUrl(categoriaDitail.getImageUrl());

        return repository.save(updateCategoria);
    }

    //delete categoria
    public Boolean deleteCategoria(Long id){
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encuentra una categoria con el id " + id));

        repository.deleteById(id);
        return true;
    }

}
