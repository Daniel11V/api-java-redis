package com.coderhouse.service;

import com.coderhouse.model.Restaurante;

import java.util.List;

public interface RestauranteService {

    Restaurante create(Restaurante restaurante);
    List<Restaurante> findAll();
    Restaurante getRestauranteById(Long id);
    Restaurante updateRestauranteById(Restaurante restaurante, Long id);
    List<Restaurante> deleteRestauranteById(Long id);
}
