package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "article")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long code;
    private String description;
    private Double buyPrize;
    private Double sellPrize;
    @OneToMany
    private List<AlmacenArticulo> almacenArticulo;

}
