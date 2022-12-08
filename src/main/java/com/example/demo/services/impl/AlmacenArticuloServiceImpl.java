package com.example.demo.services.impl;

import com.example.demo.dtos.AlmacenArticuloDTO;
import com.example.demo.entities.Almacen;
import com.example.demo.entities.AlmacenArticulo;
import com.example.demo.entities.Articulo;
import com.example.demo.repositories.AlmacenArticuloRepository;
import com.example.demo.repositories.AlmacenRepository;
import com.example.demo.repositories.ArticuloRepository;
import com.example.demo.services.AlmacenArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlmacenArticuloServiceImpl implements AlmacenArticuloService {

    @Autowired
    AlmacenRepository almacenRepository;

    @Autowired
    ArticuloRepository articuloRepository;

    @Autowired
    AlmacenArticuloRepository almacenArticuloRepository;

    @Override
    public ResponseEntity<AlmacenArticuloDTO> save(AlmacenArticuloDTO almacenArticuloDTO) {
        AlmacenArticulo almacenArticulo = null;
        try{
            Optional<Almacen> opAlmacen = almacenRepository.findById(almacenArticuloDTO.getIdAlmacen());

            if(opAlmacen.isPresent()){
                Almacen almacen = opAlmacen.get();

                Optional<Articulo> opArticulo = articuloRepository.findById(almacenArticuloDTO.getIdArticulo());

                if(opArticulo.isPresent()){
                    Articulo articulo = opArticulo.get();

                    AlmacenArticulo almacenArticuloFound = almacen.getAlmacenArticulo().stream()
                            .filter(almArticulo ->
                                    almArticulo.getArticle().getCode().equals(almacenArticuloDTO.getIdArticulo()))
                            .findAny()
                            .orElse(null);

                    if(almacenArticuloFound != null){
                        almacenArticuloFound.setStock(almacenArticuloFound.getStock()+almacenArticuloDTO.getStock());
                        almacenArticulo = almacenArticuloFound;
                    } else {
                        AlmacenArticulo newAlmacenArticulo = new AlmacenArticulo();
                        almacenArticulo.setAlmacen(almacen);
                        almacenArticulo.setArticle(articulo);
                        almacenArticulo.setStock(almacenArticuloDTO.getStock());
                        almacenArticulo = newAlmacenArticulo;
                    }
                } else {
                    return ResponseEntity.unprocessableEntity().build();
                }
            } else{
                return ResponseEntity.unprocessableEntity().build();
            }

            almacenArticuloRepository.save(almacenArticulo);
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().build();
    }


}
