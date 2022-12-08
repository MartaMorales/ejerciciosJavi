package com.example.demo.services;

import com.example.demo.dtos.AlmacenArticuloDTO;
import com.example.demo.entities.Almacen;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AlmacenService {

    ResponseEntity<List<Almacen>> getAll();

    ResponseEntity<Almacen> save(Almacen almacen);

    ResponseEntity<Almacen> delete(Long id);

    ResponseEntity<Almacen> getById(Long id);
}
