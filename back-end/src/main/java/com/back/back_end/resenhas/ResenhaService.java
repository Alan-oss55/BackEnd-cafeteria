package com.back.back_end.resenhas;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.back_end.ResourceNotFoundException;

@Service
public class ResenhaService {
    @Autowired ResenhaRepository repository;

    //getAll
    public List<Resenha> getAllResenhas(){
        return repository.findAll();
    }

    //get by id
    public Resenha getByIdResenha(Long id){
        return repository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No se encontro una resenha con el id" + id));
    }

    //create resenha
    public Resenha addResenha(Resenha resenha){
        return repository.save(resenha);
    }

    //update resenha
    public Resenha updateResenha(Long id, Resenha resenhaDitail){
        Resenha updatResenha = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encuentra una resenha con el id" + id));

        updatResenha.setUsuario(resenhaDitail.getUsuario());
        updatResenha.setProducto(resenhaDitail.getProducto());
        updatResenha.setComentario(resenhaDitail.getComentario());
        updatResenha.setCalificacion(resenhaDitail.getCalificacion());

        Resenha updatedResenha = updatResenha;
        return repository.save(updatedResenha);
    }

    // delete resenha
    public Map<String, Boolean> deletedResenha(Long id){
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encuentra un comentario con el id" + id));

        HashMap<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

}
