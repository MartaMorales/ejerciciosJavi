package com.example.demo.controllers;

import com.example.demo.dtos.AlmacenArticuloDTO;
import com.example.demo.entities.Articulo;
import com.example.demo.services.AlmacenArticuloService;
import com.example.demo.services.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductosController {


    @Autowired
    ArticuloService articuloService;
    @Autowired
    AlmacenArticuloService almacenArticuloService;

    //Listado
    @GetMapping("/")
    public ResponseEntity<List<Articulo>> listarProductos() {
        return articuloService.findAll();
    }

    //Alta
    @PostMapping("/")
    public ResponseEntity<Articulo> crearProducto(@RequestBody Articulo article) {
        return articuloService.crearArticulo(article);
    }

    //Baja
    @DeleteMapping("/{id}")
    public ResponseEntity<Articulo> borrarProducto(@PathVariable Long id) {
        return articuloService.deleteId(id);
    }

    //Anadir mercancia
    @PatchMapping("/anadir")
    public ResponseEntity anadirMercancia(AlmacenArticuloDTO almacenArticuloDTO) {
        return almacenArticuloService.save(almacenArticuloDTO);
    }

//    //Quitar mercancia
//    @PatchMapping("/quitar/{id}")
//    public ResponseEntity<Articulo> quitarMercancia(@PathVariable Long id, @RequestParam Integer stock) {
//        return articuloService.quitarMercancia(id, stock);
//    }


}
