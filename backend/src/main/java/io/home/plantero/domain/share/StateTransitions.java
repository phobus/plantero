package io.home.plantero.domain.share;

import java.util.*;
import java.util.stream.Collectors;

public class StateTransitions<State extends Enum> {

    private final Map<State, Set<State>> transitionMap;

    private StateTransitions(Map<State, Set<State>> transitionMap) {
        this.transitionMap = transitionMap;
    }

    public boolean hasState(State state) {
        return transitionMap.containsKey(state);
    }

    public boolean hasTransition(State initState, State finalState) {
        return Optional.ofNullable(transitionMap.get(initState))
                .map(states -> states.contains(finalState))
                .orElse(false);
    }

    public List<State> transitions(State state) {
        return Optional.ofNullable(transitionMap.get(state))
                .map(ArrayList::new)
                .map(Collections::unmodifiableList)
                .orElseGet(Collections::emptyList);
    }

    public static class StateTransitionsBuilder<State extends Enum> {
        private final Map<State, Set<State>> transitionMap = new HashMap<>();;

        public StateTransitionsBuilder<State> withTransition(State initState, State finalState) {
            transitionMap.computeIfAbsent(finalState, k -> new HashSet<>());
            transitionMap.computeIfAbsent(initState, k -> new HashSet<>());
            Set<State> nextStates = transitionMap.get(initState);
            nextStates.add(finalState);
            return this;
        }

        public StateTransitions<State> build() {
            return new StateTransitions<>(transitionMap);
        }

        public StateTransitions<State> buildDeepClone() {
            final Map<State, Set<State>> t = this.transitionMap.entrySet()
                    .stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, e -> new HashSet<>(e.getValue())));
            return new StateTransitions<>(t);
        }
    }
}
