package io.home.plantero.interfaces.api.facade.internal;

import io.home.plantero.application.SpeciesService;
import io.home.plantero.domain.model.species.Species;
import io.home.plantero.interfaces.api.facade.SpeciesServiceFacade;
import io.home.plantero.interfaces.api.facade.dto.SpeciesResource;
import io.home.plantero.interfaces.api.facade.internal.assembler.SpeciesAssembler;

import java.util.List;

public class SpeciesServiceFacadeImpl implements SpeciesServiceFacade {
    private final SpeciesService speciesService;

    public SpeciesServiceFacadeImpl(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    @Override
    public List<SpeciesResource> findAll() {
        final Iterable<Species> entities = speciesService.findAll();
        final SpeciesAssembler assembler = new SpeciesAssembler();
        return assembler.toResources(entities);
    }

    @Override
    public SpeciesResource findById(Long id) {
        final Species entity = speciesService.findById(id).get();
        final SpeciesAssembler assembler = new SpeciesAssembler();
        return assembler.toResource(entity);
    }
}
