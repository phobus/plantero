package io.home.plantero.config;

import io.home.plantero.application.PlantService;
import io.home.plantero.application.SpeciesService;
import io.home.plantero.interfaces.api.facade.LifeTimeServiceFacade;
import io.home.plantero.interfaces.api.facade.internal.LifeTimeServiceFacadeImpl;
import io.home.plantero.interfaces.api.facade.PlantServiceFacade;
import io.home.plantero.interfaces.api.facade.SpeciesServiceFacade;
import io.home.plantero.interfaces.api.facade.internal.PlantServiceFacadeImpl;
import io.home.plantero.interfaces.api.facade.internal.SpeciesServiceFacadeImpl;
import org.springframework.context.annotation.Bean;

public class FacadeConfig {

    @Bean
    public SpeciesServiceFacade speciesRestServiceFacade(SpeciesService speciesService) {
        return new SpeciesServiceFacadeImpl(speciesService);
    }

    @Bean
    public PlantServiceFacade plantRestServiceFacade(PlantService plantService) {
        return new PlantServiceFacadeImpl(plantService);
    }

    @Bean
    public LifeTimeServiceFacade lifeTimeServiceFacade(PlantService plantService) {
        return new LifeTimeServiceFacadeImpl(plantService);
    }
}
