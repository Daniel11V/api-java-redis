package com.coderhouse.controller;

import com.coderhouse.model.Restaurante;
import com.coderhouse.service.RestauranteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Método para visualizar todos los Restaurantes",
        description = "Permite realizar una llamada a la base de datos de H2 para obetener todos los restaurantes",
        tags = {"restaurante"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvieron los restaurantes"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado", content = @Content),
            }
    )
    @GetMapping("/restaurantes")
    public List<Restaurante> getRestaurantes() {
        log.info("GET obtener todos los restaurantes");
        return service.findAll();
    }

    @Operation(summary = "Método para visualizar un Restaurante por su ID",
            description = "Permite realizar una llamada a la base de datos de Redis para obetener un restaurante por su id. " +
                    "Si no lo encuentra realiza la misma petición en la base de datos de H2",
            tags = {"restaurante"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se obtuvo el restaurante"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado", content = @Content),
            }
    )
    @GetMapping("/restaurantes/{id}")
    public Restaurante getRestauranteById(@PathVariable Long id) {
        log.info("GET obtener restaurante por el id");
        return service.getRestauranteById(id);
    }

    @Operation(summary = "Método para crear un Restaurante",
            description = "Permite crear un restaurante en la base de datos de H2 y en la de Redis",
            tags = {"restaurante"})
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Se creo el restaurante"),
                    @ApiResponse(responseCode = "400", description = "Hay un error en el request", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado", content = @Content),
            }
    )
    @PostMapping("/restaurantes")
    public Restaurante createRestaurante(@RequestBody Restaurante restaurante) {
        log.info("POST crear restaurante");
        return service.create(restaurante);
    }

    @Operation(summary = "Método para actualizar un Restaurante por su ID",
            description = "Permite actualizar un restaurante por su id en la base de datos de Redis y H2",
            tags = {"restaurante"})
    @PutMapping("/restaurantes/{id}")
    public Restaurante updateRestauranteById(@PathVariable Long id, @RequestBody  Restaurante newRestaurante) {
        log.info("PUT actualizar restaurante por el id");
        return service.updateRestauranteById(newRestaurante, id);
    }

    @Operation(summary = "Método para borrar un Restaurante por su ID",
            description = "Permite borrar un restaurante por su id en la base de datos de Redis y H2",
            tags = {"restaurante"})
    @DeleteMapping("/restaurantes/{id}")
    public List<Restaurante> deleteRestauranteById(@PathVariable Long id) {
        log.info("DELETE eliminar restaurante por el id");
        return service.deleteRestauranteById(id);
    }

    @Operation(summary = "Método que retorna el string deserializado",
            tags = {"normalize"})
    @PostMapping("/deserialize")
    public Map deserializeRestaurante(@RequestBody String restauranteString) throws JsonProcessingException {
        return service.deserialize(restauranteString);
    }

}
