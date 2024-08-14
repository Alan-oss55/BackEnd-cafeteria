package com.back.back_end.carrito;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/api/v1/carrito")
public class CarritoController {
    @Autowired CarritoService service;

    //getAll
    @GetMapping
    public List<Carrito> getAll(){
        return service.getAll();
    }

    //get by id
    @GetMapping("/{id}")
    public Carrito getByIdCart(@PathVariable Long id){
        return service.getByIdCarrito(id);
    }

    //create
    // @PostMapping
    // public ResponseEntity<Carrito> createCarrito(@RequestBody Carrito carrito) {
    //     try {
    //         Carrito savedCarrito = service.addCart(carrito);
    //         return new ResponseEntity<>(savedCarrito, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // add to cart
    @PostMapping
    public ResponseEntity<?> addToCart(@RequestBody CarritoDto carritoRequest) {
        try {
            List<Carrito> carritoItems = service.addItemsToCart(carritoRequest);
            return ResponseEntity.ok(carritoItems);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al agregar al carrito");
        }
    }

    @PutMapping("/{id}")
    public Carrito updateCarrito(@PathVariable Long id, @RequestBody Carrito cartDitail){
        return service.updateCart(id, cartDitail);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteCart(@PathVariable Long id){
        return service.deleteCart(id);
    }
}
