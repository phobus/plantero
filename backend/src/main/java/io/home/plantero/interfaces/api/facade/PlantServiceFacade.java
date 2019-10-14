package io.home.plantero.interfaces.api.facade;

import io.home.plantero.interfaces.api.facade.dto.LifeTimeResource;
import io.home.plantero.interfaces.api.facade.dto.PlantResource;

import java.util.List;

public interface PlantServiceFacade {
    List<PlantResource> findAll();

    PlantResource findById(Long plantId);

    LifeTimeResource findPlantLifeTimeByPlantId(Long plantId);

}
