package io.home.plantero;

import io.home.plantero.application.util.SampleDataGenerator;
import io.home.plantero.domain.model.plant.PlantRepository;
import io.home.plantero.domain.model.species.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PlanteroApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlanteroApplication.class, args);
    }

    //@Autowired
    private SampleDataGenerator sampleDataGenerator;

    //@Autowired
    SpeciesRepository speciesRepository;

    //@Autowired
    PlantRepository plantRepository;

    //@PostConstruct
    public void init() {
        sampleDataGenerator.generate();
    }

}
