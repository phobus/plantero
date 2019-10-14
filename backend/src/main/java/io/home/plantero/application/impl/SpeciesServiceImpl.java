package io.home.plantero.application.impl;

import io.home.plantero.application.SpeciesService;
import io.home.plantero.domain.model.species.Species;
import io.home.plantero.domain.model.species.SpeciesRepository;

import java.util.Optional;

public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepository;

    public SpeciesServiceImpl(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    public Iterable<Species> findAll() {
        return speciesRepository.findAll();
    }

    @Override
    public Optional<Species> findById(Long id) {
        return speciesRepository.findById(id);
    }
}
