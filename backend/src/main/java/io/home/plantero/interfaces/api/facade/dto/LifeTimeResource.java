package io.home.plantero.interfaces.api.facade.dto;

import io.home.plantero.domain.model.plant.PlantState;
import org.springframework.hateoas.ResourceSupport;

import java.util.Collections;
import java.util.List;

public class LifeTimeResource extends ResourceSupport {

    private final List<TimeSpanDto> timeSpanList;
    private final Long plantId;

    public LifeTimeResource(Long plantId, List<TimeSpanDto> timeSpanList) {
        this.plantId = plantId;
        this.timeSpanList = Collections.unmodifiableList(timeSpanList);
    }

    public List<TimeSpanDto> getTimeSpanList() {
        return timeSpanList;
    }

    public Long getPlantId() {
        return plantId;
    }

    public static class TimeSpanDto {
        private final PlantState plantState;
        private final long days;

        public TimeSpanDto(PlantState plantState, long days) {
            this.plantState = plantState;
            this.days = days;
        }

        public PlantState getPlantState() {
            return plantState;
        }

        public long getDays() {
            return days;
        }
    }
}
