package io.home.plantero.config;

import io.home.plantero.application.PlantService;
import io.home.plantero.application.SpeciesService;
import io.home.plantero.application.impl.PlantServiceImpl;
import io.home.plantero.application.impl.SpeciesServiceImpl;
import io.home.plantero.domain.model.plant.PlantRepository;
import io.home.plantero.domain.model.species.SpeciesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public SpeciesService speciesService(SpeciesRepository speciesRepository) {
        return new SpeciesServiceImpl(speciesRepository);
    }

    @Bean
    public PlantService plantService(PlantRepository plantRepository) {
        return new PlantServiceImpl(plantRepository);
    }

}
