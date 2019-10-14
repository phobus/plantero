package io.home.plantero.interfaces.api.facade.internal.assembler;


import io.home.plantero.domain.model.species.Species;
import io.home.plantero.interfaces.api.facade.dto.SpeciesResource;
import io.home.plantero.interfaces.api.rest.SpeciesController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class SpeciesAssembler extends ResourceAssemblerSupport<Species, SpeciesResource> {

    public SpeciesAssembler() {
        super(SpeciesController.class, SpeciesResource.class);
    }

    @Override
    public SpeciesResource toResource(Species entity) {
        SpeciesResource resource = super.createResourceWithId(entity.getId(), entity);
        resource.setSpeciesId(entity.getId());
        resource.setVersion(entity.getVersion());
        resource.setName(entity.getName());
        resource.setUrl(entity.getUrl());
        return resource;
    }
}
