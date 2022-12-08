package com.example.demo.repositories;

import com.example.demo.entities.AlmacenArticulo;
import com.example.demo.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlmacenArticuloRepository extends JpaRepository<AlmacenArticulo, Long> {
}
