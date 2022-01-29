package com.coderhouse.service;

import com.coderhouse.model.Restaurante;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Map;

public interface RestauranteService {

    Restaurante create(Restaurante restaurante);
    List<Restaurante> findAll();
    Restaurante getRestauranteById(Long id);
    Restaurante updateRestauranteById(Restaurante restaurante, Long id);
    List<Restaurante> deleteRestauranteById(Long id);
    Map deserialize(String restauranteString) throws JsonProcessingException;
}
