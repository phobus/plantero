package io.home.plantero.interfaces.api.facade.internal;

import io.home.plantero.application.PlantService;
import io.home.plantero.domain.model.plant.LifeTime;
import io.home.plantero.domain.model.plant.Plant;
import io.home.plantero.interfaces.api.facade.LifeTimeServiceFacade;
import io.home.plantero.interfaces.api.facade.dto.LifeTimeResource;
import io.home.plantero.interfaces.api.facade.internal.assembler.LifeTimeAssembler;

public class LifeTimeServiceFacadeImpl implements LifeTimeServiceFacade {
    private final PlantService plantService;

    public LifeTimeServiceFacadeImpl(PlantService plantService) {
        this.plantService = plantService;
    }

    @Override
    public LifeTimeResource findAllByPlantId(Long id) {
        final Plant plant = plantService.findById(id).get();
        final LifeTime lifeTime = plant.lifeTime();
        final LifeTimeAssembler assembler = new LifeTimeAssembler();
        return assembler.toResource(lifeTime);
    }
}
