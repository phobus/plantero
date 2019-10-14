package io.home.plantero.interfaces.api.facade;

import io.home.plantero.interfaces.api.facade.dto.LifeTimeResource;
import io.home.plantero.interfaces.api.facade.dto.PlantResource;

import java.util.List;

public interface LifeTimeServiceFacade {

    LifeTimeResource findAllByPlantId(Long plantId);

}
