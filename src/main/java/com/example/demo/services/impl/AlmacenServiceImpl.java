package com.example.demo.services.impl;

import com.example.demo.dtos.AlmacenArticuloDTO;
import com.example.demo.entities.Almacen;
import com.example.demo.entities.AlmacenArticulo;
import com.example.demo.entities.Articulo;
import com.example.demo.repositories.AlmacenRepository;
import com.example.demo.services.AlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AlmacenServiceImpl implements AlmacenService {

    @Autowired
    AlmacenRepository almacenRepository;

    @Override
    public ResponseEntity<List<Almacen>> getAll() {
        try {
            return ResponseEntity.ok(almacenRepository.findAll());
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Almacen> save(Almacen almacen) {
        try {
            return ResponseEntity.ok(almacenRepository.save(almacen));
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Almacen> delete(Long id) {
        try {
            almacenRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.getMessage();
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Almacen> getById(Long id) {
        try {
            Optional<Almacen> almacen = almacenRepository.findById(id);

            if (almacen.isPresent()) {
                almacen.get().setStockTotal(almacen.get().getAlmacenArticulo().stream().mapToInt(AlmacenArticulo::getStock).sum());
            }
            return ResponseEntity.ok(almacen.get());
        }catch (Exception e){
            e.getMessage();
        }

        return ResponseEntity.badRequest().build();
    }
}
