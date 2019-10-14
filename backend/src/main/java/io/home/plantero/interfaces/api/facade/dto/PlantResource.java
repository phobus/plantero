package io.home.plantero.interfaces.api.facade.dto;

import io.home.plantero.domain.model.plant.PlantState;
import org.springframework.hateoas.ResourceSupport;

public class PlantResource extends ResourceSupport {

    private Long plantId;
    private long version;
    private String name;
    private PlantState state;
    private Long speciesId;

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlantState getState() {
        return state;
    }

    public void setState(PlantState state) {
        this.state = state;
    }

    public Long getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Long speciesId) {
        this.speciesId = speciesId;
    }
}
