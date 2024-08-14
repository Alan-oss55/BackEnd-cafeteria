package com.back.back_end.carrito;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.back_end.ResourceNotFoundException;
import com.back.back_end.productos.Productos;
import com.back.back_end.productos.ProductosRepository;

@Service
public class CarritoService {   

    @Autowired CarritoRepository repository;
    @Autowired ProductosRepository productosRepository;

    //getAll
    public List<Carrito> getAll(){
        return repository.findAll();
    }

    //get by id
    public Carrito getByIdCarrito(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encontró un carrito con el id" + id));
    }

    //create cart
    public Carrito addCart(Carrito carrito){
        return repository.save(carrito);
    }

    //add to cart
    public List<Carrito> addItemsToCart(CarritoDto carritoRequest) {
        List<Carrito> carritoItems = new ArrayList<>();

        for (CarritoDto.CarritoItem item : carritoRequest.getItems()) {
            Productos producto = productosRepository.findById(item.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            Carrito carrito = new Carrito();
            carrito.setProducto(producto);
            carrito.setCantidad(item.getCantidad());
            carrito.setEstado("Pagado");

            carritoItems.add(carrito);
        }

        return repository.saveAll(carritoItems);
    }

    //update cart
    public Carrito updateCart(Long id, Carrito cartDitail){
        Carrito updateCarrito = repository.findById(id) .orElseThrow(() -> new ResourceNotFoundException("No se encontró un carrito con el id" + id));

        // updateCarrito.setUsuario(cartDitail.getUsuario());
        updateCarrito.setProducto(cartDitail.getProducto());
        updateCarrito.setCantidad(cartDitail.getCantidad());
        updateCarrito.setEstado(cartDitail.getEstado());

        Carrito updatedCart = updateCarrito;

        return repository.save(updatedCart);
    }

    //delete cart
    public Map<String, Boolean> deleteCart(Long id){
        repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró un carrito con el id" + id));
        repository.deleteById(id);

        HashMap<String, Boolean> response =  new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
