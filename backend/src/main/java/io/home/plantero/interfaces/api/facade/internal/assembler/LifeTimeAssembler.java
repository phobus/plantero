package io.home.plantero.interfaces.api.facade.internal.assembler;

import io.home.plantero.domain.model.plant.LifeTime;
import io.home.plantero.interfaces.api.facade.dto.LifeTimeResource;
import io.home.plantero.interfaces.api.rest.LifeTimeController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceAssembler;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class LifeTimeAssembler implements ResourceAssembler<LifeTime, LifeTimeResource> {

    @Override
    public LifeTimeResource toResource(LifeTime entity) {
        final List<LifeTimeResource.TimeSpanDto> spans = entity.timeSpanList().stream()
                .map(ts -> new LifeTimeResource.TimeSpanDto(ts.getPlantState(), ts.getDays()))
                .collect(Collectors.toList());
        LifeTimeResource resource = new LifeTimeResource(entity.getPlantId(), spans);
        addSelfLink(resource);
        return resource;
    }

    private void addSelfLink(LifeTimeResource resource) {
        Link link = linkTo(methodOn(LifeTimeController.class).showByPlantId(resource.getPlantId()))
                .withSelfRel();
        resource.add(link);
    }
}
