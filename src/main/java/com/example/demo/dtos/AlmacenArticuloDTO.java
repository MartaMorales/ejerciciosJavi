package com.example.demo.dtos;

import lombok.Data;

@Data
public class AlmacenArticuloDTO {

    private Long idAlmacen;
    private Long idArticulo;
    private Integer stock;
}
