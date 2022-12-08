package com.example.demo.services;

import com.example.demo.dtos.AlmacenArticuloDTO;
import com.example.demo.entities.Articulo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ArticuloService {

     ResponseEntity<Articulo> crearArticulo(Articulo article);

     ResponseEntity<List<Articulo>> findAll();

     ResponseEntity<Articulo> deleteId(Long id);

//     ResponseEntity<Articulo> anadirMercancia(AlmacenArticuloDTO almacenArticuloDTO);

//     ResponseEntity<Articulo> quitarMercancia(Long id, Integer stock);
}
