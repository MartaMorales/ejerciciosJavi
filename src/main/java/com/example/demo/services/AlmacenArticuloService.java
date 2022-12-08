package com.example.demo.services;

import com.example.demo.dtos.AlmacenArticuloDTO;
import org.springframework.http.ResponseEntity;

public interface AlmacenArticuloService {

    ResponseEntity<AlmacenArticuloDTO> save(AlmacenArticuloDTO almacenArticuloDTO);
}
