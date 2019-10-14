package io.home.plantero.application;

import io.home.plantero.domain.model.species.Species;

import java.util.Optional;

public interface SpeciesService {

    Iterable<Species> findAll();

    Optional<Species> findById(Long id);
}
