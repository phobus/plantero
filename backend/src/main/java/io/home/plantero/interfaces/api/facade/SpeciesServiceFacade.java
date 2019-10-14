package io.home.plantero.interfaces.api.facade;

import io.home.plantero.interfaces.api.facade.dto.SpeciesResource;

import java.util.List;

public interface SpeciesServiceFacade {
    List<SpeciesResource> findAll();

    SpeciesResource findById(Long speciesId);
}
