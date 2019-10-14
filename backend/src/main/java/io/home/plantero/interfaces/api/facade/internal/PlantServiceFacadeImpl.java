package io.home.plantero.interfaces.api.facade.internal;

import io.home.plantero.application.PlantService;
import io.home.plantero.domain.model.plant.Plant;
import io.home.plantero.interfaces.api.facade.PlantServiceFacade;
import io.home.plantero.interfaces.api.facade.dto.LifeTimeResource;
import io.home.plantero.interfaces.api.facade.dto.PlantResource;
import io.home.plantero.interfaces.api.facade.internal.assembler.LifeTimeAssembler;
import io.home.plantero.interfaces.api.facade.internal.assembler.PlantAssembler;

import java.util.List;

public class PlantServiceFacadeImpl implements PlantServiceFacade {
    private final PlantService PlantService;

    public PlantServiceFacadeImpl(PlantService PlantService) {
        this.PlantService = PlantService;
    }

    @Override
    public List<PlantResource> findAll() {
        final Iterable<Plant> entities = PlantService.findAll();
        final PlantAssembler assembler = new PlantAssembler();
        return assembler.toResources(entities);
    }

    @Override
    public PlantResource findById(Long id) {
        final Plant entity = PlantService.findById(id).get();
        final PlantAssembler assembler = new PlantAssembler();
        return assembler.toResource(entity);
    }

    @Override
    public LifeTimeResource findPlantLifeTimeByPlantId(Long id) {
        final Plant entity = PlantService.findById(id).get();
        final LifeTimeAssembler assembler = new LifeTimeAssembler();
        return assembler.toResource(entity.lifeTime());
    }
}
