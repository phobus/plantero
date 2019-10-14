package io.home.plantero.domain.model.plant;

import io.home.plantero.domain.share.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Event extends BaseEntity {

    @ManyToOne
    private Plant plant;

    @NotNull
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private PlantState initialState;

    @Enumerated(EnumType.STRING)
    @NotNull
    private PlantState finalState;

    public Event() {
    }

    public Event(Plant plant, LocalDate date, PlantState initialState, PlantState finalState) {
        this.plant = plant;
        this.date = date;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public Event(Long id, long version, Plant plant, LocalDate date, PlantState initialState, PlantState finalState) {
        super(id, version);
        this.plant = plant;
        this.date = date;
        this.initialState = initialState;
        this.finalState = finalState;
    }

    public Plant getPlant() {
        return plant;
    }

    public LocalDate getDate() {
        return date;
    }

    public PlantState getInitialState() {
        return initialState;
    }

    public PlantState getFinalState() {
        return finalState;
    }
}
