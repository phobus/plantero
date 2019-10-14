package io.home.plantero.application.impl;

import io.home.plantero.application.PlantService;
import io.home.plantero.domain.model.plant.Plant;
import io.home.plantero.domain.model.plant.PlantRepository;

import java.util.Optional;

public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;

    public PlantServiceImpl(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @Override
    public Iterable<Plant> findAll() {
        return this.plantRepository.findAll();
    }

    @Override
    public Optional<Plant> findById(Long id) {
        return this.plantRepository.findById(id);
    }
}
