package com.back.back_end.usuarios;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.back_end.ResourceNotFoundException;

@Service
public class UsuarioService {

    @Autowired UsuariosRepository repository;

    //get all
   public List<Usuarios> getAll(){
        return repository.findAll();
   }

   //get by id
   public Usuarios getByIdUsuario(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encuetra un usuario con el id " + id));
   } 

    //get by id
    public Usuarios updateUsuarios(Long id, Usuarios usuarioDilog){
        Usuarios updateUsuario = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encuetra un usuario con el id " + id));

        updateUsuario.setNombre(usuarioDilog.getNombre());
        updateUsuario.setEmail(usuarioDilog.getEmail());
        updateUsuario.setContrasenha(usuarioDilog.getContrasenha());
        updateUsuario.setRol(usuarioDilog.getRol());

        return repository.save(updateUsuario);
   } 

    //delete usuario
    public Map<String, Boolean> deleteUsuario(Long id){
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encuetra un usuario con el id " + id));
        repository.deleteById(id);
        
        HashMap< String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    } 

    //create
    public Usuarios addUsuarios(Usuarios usuarios){
        return repository.save(usuarios);
    }
}
