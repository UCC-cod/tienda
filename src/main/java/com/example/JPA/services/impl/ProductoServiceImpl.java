package com.example.JPA.services.impl;

import com.example.JPA.entities.Producto;
import com.example.JPA.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements com.example.JPA.services.ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getProductos() {
        List<Producto> productos = productoRepository.findAll();
        if(productos.isEmpty()){
            throw new RuntimeException("Producto no encontrado");
        }else{
            return productos;
        }
    }

    @Override
    public Producto getProductoById(int codigo) {
        Producto producto = productoRepository.findById(codigo).get();
        if(producto == null){
            throw new RuntimeException("Producto no encontrado");
        }else{
            return producto;
        }
    }

    @Override
    public Producto guardar(Producto producto) {
        Producto productoNuevo = productoRepository.save(producto);
        return productoNuevo;
    }
}
