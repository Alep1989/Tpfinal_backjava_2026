package com.techlab.arancibia.alejandro.articulos.controller;

import com.techlab.arancibia.alejandro.articulos.model.Articulo;
import com.techlab.arancibia.alejandro.articulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/articulos")
@CrossOrigin(origins = "*")
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    @GetMapping
    public ResponseEntity<List<Articulo>> listarTodos() {
        List<Articulo> articulos = articuloRepository.findAll();
        return ResponseEntity.ok(articulos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articulo> obtenerPorId(@PathVariable Long id) {
        Optional<Articulo> articulo = articuloRepository.findById(id);
        return articulo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Articulo> crear(@RequestBody Articulo articulo) {
        Articulo articuloGuardado = articuloRepository.save(articulo);
        return ResponseEntity.status(HttpStatus.CREATED).body(articuloGuardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Articulo> actualizar(@PathVariable Long id, @RequestBody Articulo articuloDetails) {
        Optional<Articulo> articulo = articuloRepository.findById(id);
        if (articulo.isPresent()) {
            Articulo articuloExistente = articulo.get();
            articuloExistente.setNombre(articuloDetails.getNombre());
            articuloExistente.setDescripcion(articuloDetails.getDescripcion());
            articuloExistente.setPrecio(articuloDetails.getPrecio());
            articuloExistente.setStock(articuloDetails.getStock());
            Articulo articuloActualizado = articuloRepository.save(articuloExistente);
            return ResponseEntity.ok(articuloActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (articuloRepository.existsById(id)) {
            articuloRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
