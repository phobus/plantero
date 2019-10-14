package io.home.plantero.interfaces.api.rest;

import io.home.plantero.interfaces.api.facade.SpeciesServiceFacade;
import io.home.plantero.interfaces.api.facade.dto.SpeciesResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/species")
public class SpeciesController {

    private final SpeciesServiceFacade speciesServiceFacade;

    public SpeciesController(SpeciesServiceFacade speciesServiceFacade) {
        this.speciesServiceFacade = speciesServiceFacade;
    }

    @GetMapping
    public List<SpeciesResource> findAll() {
        return speciesServiceFacade.findAll();
    }

    @GetMapping(value = "/{speciesId}")
    public SpeciesResource findById(@PathVariable Long speciesId) {
        return speciesServiceFacade.findById(speciesId);
    }
}
