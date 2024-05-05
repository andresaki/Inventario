package com.SRP.sistema.servicio;

import com.SRP.sistema.modelo.Producto;
import com.SRP.sistema.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//repositorio para la optimizacion de metodos
@Service
public class ProductoServicio {

    @Autowired
    ProductoRepositorio productoRepositorio;

    // listar productos 
    public List<Producto> listaDeProductos(){
        return new ArrayList<>(productoRepositorio.findAll(Sort.by(Sort.Direction.DESC,"id")));
    }

    // obtener producto por id
    public Producto detallesProducto (Integer id) {
        return  productoRepositorio.findById(id).get();
    }

    // Guardar o actualizar si ya esta creado el producto
    public boolean guardarOActualizarProducto (Producto producto){
        Producto producto1 = productoRepositorio.save(producto);
        return productoRepositorio.findById(producto1.getId()).isPresent();  // retorna un verdadero  si esta presente el registro que guardo y si no nose pudo guardar
    }

    // eliminar el producto
    public boolean eliminarProducto(Integer id){
        productoRepositorio.deleteById(id);
        return productoRepositorio.findById(id).isEmpty();          //retorna true si lo elimino 
    }

}
