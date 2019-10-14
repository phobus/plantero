package io.home.plantero.application;

import io.home.plantero.domain.model.plant.Plant;

import java.util.Optional;

public interface PlantService {

    Iterable<Plant> findAll();

    Optional<Plant> findById(Long id);
}
