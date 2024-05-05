package com.SRP.sistema.repositorio;


import com.SRP.sistema.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio que nos brinda metodos de jpa
@Repository
public interface ProductoRepositorio extends JpaRepository <Producto  , Integer> {

}
