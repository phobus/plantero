package io.home.plantero.interfaces.api.rest;

import io.home.plantero.interfaces.api.facade.PlantServiceFacade;
import io.home.plantero.interfaces.api.facade.dto.PlantResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/plants")
public class PlantController {

    private final PlantServiceFacade plantServiceFacade;

    public PlantController(PlantServiceFacade plantServiceFacade) {
        this.plantServiceFacade = plantServiceFacade;
    }

    @GetMapping
    public List<PlantResource> showAll() {
        return plantServiceFacade.findAll();
    }

    @GetMapping(value = "/{plantId}")
    public PlantResource show(@PathVariable Long plantId) {
        return plantServiceFacade.findById(plantId);
    }


}
