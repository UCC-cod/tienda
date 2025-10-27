package com.example.JPA.services;

import com.example.JPA.entities.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getProductos();
    Producto getProductoById(int codigo);
    Producto guardar(Producto producto);
}
