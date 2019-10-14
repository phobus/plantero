package io.home.plantero.interfaces.api.facade.internal.assembler;


import io.home.plantero.domain.model.plant.Plant;
import io.home.plantero.interfaces.api.facade.dto.PlantResource;
import io.home.plantero.interfaces.api.rest.LifeTimeController;
import io.home.plantero.interfaces.api.rest.PlantController;
import io.home.plantero.interfaces.api.rest.SpeciesController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class PlantAssembler extends ResourceAssemblerSupport<Plant, PlantResource> {

    public PlantAssembler() {
        super(PlantController.class, PlantResource.class);
    }

    @Override
    public PlantResource toResource(Plant entity) {
        PlantResource resource = super.createResourceWithId(entity.getId(), entity);
        resource.setPlantId(entity.getId());
        resource.setVersion(entity.getVersion());
        resource.setName(entity.getName());
        resource.setState(entity.getState());
        resource.setSpeciesId(entity.getSpecies().getId());

        addLifeTimeLink(resource);
        addSpeciesLink(resource);

        return resource;
    }

    private void addLifeTimeLink(PlantResource plantResource) {
        Link link = linkTo(methodOn(LifeTimeController.class).showByPlantId(plantResource.getPlantId()))
                .withRel("lifetime");
        plantResource.add(link);
    }

    private void addSpeciesLink(PlantResource plantResource) {
        Link link = linkTo(SpeciesController.class).slash(plantResource.getSpeciesId()).withRel("species");
        plantResource.add(link);
    }
}
