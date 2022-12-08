package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AlmacenArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Almacen almacen;
    @ManyToOne
    private Articulo article;
    private Integer stock;
}
