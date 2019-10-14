package io.home.plantero.domain.share;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public abstract class StateMachineEntity<State extends Enum> extends NamedEntity {

    @NotNull
    @Enumerated(EnumType.STRING)
    protected State state;

    @Transient
    protected StateTransitions<State> stateTransitions;

    public StateMachineEntity() {
    }

    public StateMachineEntity(Long id, long version, String name, State state) {
        super(id, version, name);
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public boolean hasState(State state) {
        return stateTransitions.hasState(state);
    }

    public boolean hasTransition(State finalState) {
        return stateTransitions.hasTransition(this.state, finalState);
    }

    public List<State> transitions() {
        return stateTransitions.transitions(state);
    }

    public boolean changeState(State finalState) {
        return Optional.ofNullable(finalState)
                .filter(this::hasTransition)
                .map(this::processChangeState)
                .orElse(false);
    }

    private boolean processChangeState(State finalState) {
        registerChangeState(this.state, finalState);
        this.state = finalState;
        return true;
    }

    protected abstract void registerChangeState(State initState, State finalState);

    /**
     * Called by ORM when instance is managed.
     * If the instance not is managed by the ORM need to call this method.
     */
    @PostLoad
    protected void init() {
        final StateTransitions.StateTransitionsBuilder<State> builder = new StateTransitions.StateTransitionsBuilder<>();
        stateTransitions = createStateMachine(builder);
    }

    protected abstract StateTransitions<State> createStateMachine(StateTransitions.StateTransitionsBuilder<State> builder);
}
