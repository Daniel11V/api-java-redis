package com.coderhouse.service.impl;

import com.coderhouse.cache.CacheClient;
import com.coderhouse.handle.ApiRestException;
import com.coderhouse.model.Restaurante;
import com.coderhouse.repository.RestauranteRepository;
import com.coderhouse.service.RestauranteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestauranteServiceImpl implements RestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final CacheClient<Restaurante> cache;

    @Override
    public Restaurante create(Restaurante restaurante) {
        try {
            var data = restauranteRepository.save(restaurante);
            return saveRestauranteInCache(data);
        } catch (JsonProcessingException e) {
            log.error("Error converting restaurante to string", e);
        }
        return restaurante;
    }

    @Override
    public List<Restaurante> findAll() {
        return StreamSupport.stream(restauranteRepository.findAll().spliterator(),
                false).collect(Collectors.toList());
    }

    @Override
    public Restaurante getRestauranteById(Long id) {
        try {
            if (id == 0) {
                throw ApiRestException.builder().message("El identificador del restaurante debe ser mayor a 0").build();
            }
            var dataFromCache = cache.recover(id.toString(), Restaurante.class);
            if (!Objects.isNull(dataFromCache)) {
                return dataFromCache;
            }
            var dataFromDatabase = restauranteRepository.findById(id).orElseThrow(ApiRestException::new);
            return saveRestauranteInCache(dataFromDatabase);
        } catch (JsonProcessingException e) {
            log.error("Error converting restaurante to string", e);
        } catch (ApiRestException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Restaurante saveRestauranteInCache(Restaurante restaurante) throws JsonProcessingException {
        return cache.save(restaurante.getId().toString(), restaurante);
    }

}
