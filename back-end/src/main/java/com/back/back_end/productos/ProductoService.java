package com.back.back_end.productos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.back.back_end.ResourceNotFoundException;

@Service
public class ProductoService {
    
    @Autowired
    private ProductosRepository repository;

    //getAll
    public List<Productos> getAll(){
        return repository.findAll();
    }

    //get By id
    public Productos getByIdProducto(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontró un producto con el id " + id));
    }

    //create
    public Productos addProductos(Productos productos){
        return repository.save(productos);
    }

    //update
    public Productos updateProducto(Long id, Productos productoDitail){
        Productos updaProducto = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontró un producto con el id " + id));

        updaProducto.setNombre(productoDitail.getNombre());
        updaProducto.setDescripcion(productoDitail.getDescripcion());
        updaProducto.setCategoriaId(productoDitail.getCategoriaId());
        updaProducto.setPrecio(productoDitail.getPrecio());
        updaProducto.setImagen(productoDitail.getImagen());
        updaProducto.setDisponibilidad(productoDitail.getDisponibilidad());

        return repository.save(updaProducto);

    }

    //delete
    public Boolean deleteProducto(Long id){
        repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No se encontró un producto con el id " + id));

        repository.deleteById(id);
        return  true;
    }
}
