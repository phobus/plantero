package io.home.plantero.domain.model.plant;

import io.home.plantero.domain.model.species.Species;
import io.home.plantero.domain.share.StateMachineEntity;
import io.home.plantero.domain.share.StateTransitions;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Plant extends StateMachineEntity<PlantState> {

    @ManyToOne(fetch = FetchType.LAZY)
    private Species species;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plant mother;

    @OneToMany(
            mappedBy = "plant",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @OrderBy("date ASC")
    private List<Event> events = new ArrayList<>();

    public Plant() {
    }

    /**
     * Constructor for plant from seed
     *
     * @param name
     * @param species
     */
    public Plant(String name, Species species) {
        setName(name);
        this.species = species;
        this.mother = null;
        this.state = PlantState.SEED;
        registerChangeState(null, this.state);
        init();
    }

    /**
     * Constructor for clone from mother
     *
     * @param name
     * @param mother
     */
    public Plant(String name, Plant mother) {
        setName(name);
        this.species = mother.getSpecies();
        this.mother = mother;
        this.state = PlantState.CLONE;
        registerChangeState(null, this.state);
        init();
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public LifeTime lifeTime() {
        return new LifeTime(getId(), events);
    }

    @Override
    protected void registerChangeState(PlantState initState, PlantState finalState) {
        Event event = new Event(this, LocalDate.now(), initState, finalState);
        events.add(event);
    }

    @Override
    protected StateTransitions<PlantState> createStateMachine(StateTransitions.StateTransitionsBuilder<PlantState> builder) {
        return builder
                .withTransition(PlantState.SEED, PlantState.SEEDLING)
                .withTransition(PlantState.SEED, PlantState.DIE)
                .withTransition(PlantState.SEEDLING, PlantState.GROWING)
                .withTransition(PlantState.SEEDLING, PlantState.DIE)
                .withTransition(PlantState.GROWING, PlantState.FLOWERING)
                .withTransition(PlantState.GROWING, PlantState.DIE)
                .withTransition(PlantState.FLOWERING, PlantState.HARVEST)
                .withTransition(PlantState.FLOWERING, PlantState.GROWING)
                .withTransition(PlantState.FLOWERING, PlantState.DIE)
                .withTransition(PlantState.HARVEST, PlantState.HARVESTED)
                .withTransition(PlantState.HARVESTED, PlantState.DIE)
                .withTransition(PlantState.HARVESTED, PlantState.GROWING)
                .build();
    }

}
