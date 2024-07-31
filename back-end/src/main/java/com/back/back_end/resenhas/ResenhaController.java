package com.back.back_end.resenhas;

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
@RequestMapping("/api/v1/resenha")
@CrossOrigin(origins = "*")
public class ResenhaController {

    @Autowired ResenhaService service;

    // getAll
    @GetMapping
    public List<Resenha> getAllResenhas(){
        return service.getAllResenhas();
    }
  
    //get by id
    @GetMapping("/{id}")
    public Resenha getbyIdResenha(@PathVariable Long id){
        return service.getByIdResenha(id);
    }
   
    //create resenha
    @PostMapping
    public Resenha addResenha(@RequestBody Resenha resenha){
        return service.addResenha(resenha);
    }

    // update resenha
    @PutMapping("/{id}")
    public Resenha updateResenha(@PathVariable Long id, @RequestBody Resenha resenhaDitail){
        return service.updateResenha(id, resenhaDitail);
    }

    //delete resenha
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteResenha(@PathVariable Long id){
        return service.deletedResenha(id);
    }
}
