package com.coderhouse.controller;

import com.coderhouse.model.Restaurante;
import com.coderhouse.service.RestauranteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/coder-house")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteService service;

    @GetMapping("/restaurantes")
    public List<Restaurante> getRestaurantes() {
        log.info("GET obtener todos los restaurantes");
        return service.findAll();
    }

    @GetMapping("/restaurantes/{id}")
    public Restaurante getRestauranteById(@PathVariable Long id) {
        log.info("GET obtener restaurante por el id");
        return service.getRestauranteById(id);
    }

    @PostMapping("/restaurantes")
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        log.info("POST crear restaurante");
        return service.create(restaurante);
    }

    @PutMapping("/restaurantes/{id}")
    public Restaurante updateRestauranteById(@PathVariable Long id, @RequestBody  Restaurante newRestaurante) {
        log.info("PUT actualizar restaurante por el id");
        return service.updateRestauranteById(newRestaurante, id);
    }

    @DeleteMapping("/restaurantes/{id}")
    public List<Restaurante> deleteRestauranteById(@PathVariable Long id) {
        log.info("DELETE eliminar restaurante por el id");
        return service.deleteRestauranteById(id);
    }

    @PostMapping("/deserialize")
    public Map deserializeRestaurante(@RequestBody String restauranteString) throws JsonProcessingException {
        return service.deserialize(restauranteString);
    }

}
