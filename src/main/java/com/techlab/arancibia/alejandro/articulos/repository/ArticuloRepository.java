package com.techlab.arancibia.alejandro.articulos.repository;

import com.techlab.arancibia.alejandro.articulos.model.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
