package com.example.demo.controllers;

import com.example.demo.dtos.AlmacenArticuloDTO;
import com.example.demo.entities.Almacen;
import com.example.demo.services.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacenes")
public class AlmacenesController {

    @Autowired
    AlmacenService almacenService;

    //Listar almacenes
    @GetMapping("/")
    public ResponseEntity<List<Almacen>> listarAlmacenes() {
        return almacenService.getAll();
    }

    //Alta almacen
    @PostMapping("/")
    public ResponseEntity<Almacen> anadirAlmacen(@RequestBody Almacen almacen){
        return almacenService.save(almacen);
    }

    //Baja almacen
    @DeleteMapping("/{id}")
    public ResponseEntity<Almacen> bajaAlmacen(@PathVariable Long id){
        ;
        return almacenService.delete(id);
    }
    //Listado de productos (Get by Id)
    @GetMapping("/{id}")
    public ResponseEntity<Almacen> getById(@PathVariable Long id){
        return almacenService.getById(id);
    }
}
