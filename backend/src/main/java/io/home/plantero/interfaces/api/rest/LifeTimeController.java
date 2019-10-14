package io.home.plantero.interfaces.api.rest;

import io.home.plantero.interfaces.api.facade.PlantServiceFacade;
import io.home.plantero.interfaces.api.facade.dto.LifeTimeResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class LifeTimeController {

    private final PlantServiceFacade plantServiceFacade;

    public LifeTimeController(PlantServiceFacade plantServiceFacade) {
        this.plantServiceFacade = plantServiceFacade;
    }

    @GetMapping(value = "/plants/{plantId}/lifetime")
    public LifeTimeResource showByPlantId(@PathVariable Long plantId) {
        return plantServiceFacade.findPlantLifeTimeByPlantId(plantId);
    }
}
