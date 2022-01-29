package com.coderhouse.controller;

import com.coderhouse.model.Restaurante;
import com.coderhouse.service.RestauranteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/coder-house")
@RequiredArgsConstructor
public class RestauranteController {

    private final RestauranteService service;

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

}
