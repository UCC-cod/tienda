package com.example.JPA.controllers;

import com.example.JPA.entities.Fabricante;
import com.example.JPA.services.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("fabricantes/")
public class FabricanteController {

    @Autowired
    public final FabricanteService fabricanteService;

    public FabricanteController(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        try{
            List<Fabricante> fabricantes = fabricanteService.getFabricantesConProductos();
            return ResponseEntity.ok(fabricantes);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        try{
            Fabricante fabricante = fabricanteService.getFabricanteById(id);
            return ResponseEntity.ok(fabricante);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Fabricante fabricante) {
        try{
            Fabricante fabricanteNuevo = fabricante;
            fabricanteService.guardar(fabricanteNuevo);
            return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteNuevo);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado");
        }
    }
}
