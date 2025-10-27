package com.example.JPA.services;

import com.example.JPA.entities.Fabricante;

import java.util.List;

public interface FabricanteService {
    List<Fabricante> getFabricantesConProductos();
    Fabricante getFabricanteById(int codigo);
    Fabricante guardar(Fabricante fabricante);
}
