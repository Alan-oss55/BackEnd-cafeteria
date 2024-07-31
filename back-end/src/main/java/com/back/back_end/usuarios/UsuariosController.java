package com.back.back_end.usuarios;

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
@RequestMapping("api/v1/usuarios")
public class UsuariosController {

    @Autowired UsuarioService service;

    //getAll
    @GetMapping
    public List<Usuarios> getAll(){
        return service.getAll();
    }

    //get by id
    @GetMapping("/{id}")
    public Usuarios getByIdUsuario(@PathVariable Long id){
        return service.getByIdUsuario(id);
    }

    //create
    @PostMapping
    public Usuarios addUsuarios(@RequestBody Usuarios usuario){
        return service.addUsuarios(usuario);
    }

    @PutMapping("/{id}")
    public Usuarios updateUsuarios(@PathVariable Long id, @RequestBody Usuarios usuarioDilog){
        return service.updateUsuarios(id, usuarioDilog);
    }

    //delete
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUsuario(@PathVariable Long id){
        return service.deleteUsuario(id);
    }
}
