package com.example.demo.services.impl;

import com.example.demo.dtos.AlmacenArticuloDTO;
import com.example.demo.entities.Articulo;
import com.example.demo.repositories.ArticuloRepository;
import com.example.demo.services.ArticuloService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    ArticuloRepository articuloRepository;

    @Override
    public ResponseEntity<Articulo> crearArticulo(Articulo article) {
        try {
            return ResponseEntity.ok(articuloRepository.save(article));
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<List<Articulo>> findAll() {
        try {
            return ResponseEntity.ok(articuloRepository.findAll());
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Articulo> deleteId(Long id) {
        try {
            articuloRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.getMessage();
        }
        return ResponseEntity.badRequest().build();
    }

//    @Override
//    public ResponseEntity<Articulo> anadirMercancia(AlmacenArticuloDTO almacenArticuloDTO) {
//        try {
//            if (stock > 0) {
//                try {
//                    Optional<Articulo> article = articuloRepository.findById(id);
//                    article.ifPresent(article1 -> article1.setStock(article1.getStock() + stock));
//                    articuloRepository.save(article.get());
//                    return ResponseEntity.ok().build();
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        return ResponseEntity.unprocessableEntity().build();
//    }

//    @Override
//    public ResponseEntity<Articulo> quitarMercancia(Long id, Integer stock) {
//        Logger log = null;
//        try {
//            if (stock > 0) {
//                try {
//                    Optional<Articulo> article = articuloRepository.findById(id);
//                    if ((article.get().getStock() - stock) < 0) {
////                        log.info("No se puede quitar la cantidad de stock de " + stock +
////                                " ya que el stock en almacen es de " + article.get().getStock());
//                        return ResponseEntity.unprocessableEntity().build();
//                    } else {
//                        article.ifPresent(article1 -> article1.setStock(article1.getStock() - stock));
//                        articuloRepository.save(article.get());
//                        return ResponseEntity.ok().build();
//                    }
//                } catch (Exception e) {
//                    e.getMessage();
//                }
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        return ResponseEntity.unprocessableEntity().build();
//    }
}
