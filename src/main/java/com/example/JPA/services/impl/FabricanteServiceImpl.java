package com.example.JPA.services.impl;

import com.example.JPA.entities.Fabricante;
import com.example.JPA.repositories.FabricanteRepository;
import com.example.JPA.services.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FabricanteServiceImpl implements FabricanteService {

    @Autowired
    private final FabricanteRepository fabricanteRepository;

    public FabricanteServiceImpl(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }

    @Override
    public List<Fabricante> getFabricantesConProductos() {
        List<Fabricante> fabricantes = fabricanteRepository.findAll();
        if(fabricantes.isEmpty()){
            throw new RuntimeException("Fabricante no encontrado");
        }else{
            return fabricantes;
        }
    }

    @Override
    public Fabricante getFabricanteById(int codigo) {
        Fabricante fabricante = fabricanteRepository.findById(codigo).orElse(null);
        if(fabricante == null){
            throw new RuntimeException("Fabricante con id: "+ codigo + " no encontrado");
        }else{
            return fabricante;
        }
    }

    @Override
    public Fabricante guardar(Fabricante fabricante) {
        Fabricante fabricanteNuevo = fabricanteRepository.save(fabricante);
        return fabricanteNuevo;
    }
}
