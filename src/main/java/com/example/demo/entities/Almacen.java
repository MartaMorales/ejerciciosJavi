package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "almacen")
public class Almacen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String localizacion;
    @Transient
    private Integer stockTotal;
    @OneToMany
    private List<AlmacenArticulo> almacenArticulo;
}
