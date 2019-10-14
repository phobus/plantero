package io.home.plantero.domain.model.plant;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LifeTime {

    public static final int FIRST_EVENT = 0;
    private static final int SECOND_EVENT = 1;

    private final Long plantId;
    private final List<TimeSpan> timeSpanList;

    public LifeTime(Long plantId, List<Event> events) {
        this.plantId = plantId;
        this.timeSpanList = process(events);
    }

    public Long getPlantId() {
        return plantId;
    }

    public List<TimeSpan> timeSpanList() {
        return timeSpanList;
    }

    protected List<TimeSpan> process(List<Event> events) {
        final List<TimeSpan> spans = new ArrayList<>(events.size());
        LocalDate lastDate = firstEventDate(events);
        for (int i = SECOND_EVENT; i < events.size(); i++) {
            Event e = events.get(i);
            spans.add(createTimeSpan(lastDate, e));
            lastDate = e.getDate();
        }
        spans.add(createCurrentTimeSpan(lastDate, events));
        return Collections.unmodifiableList(spans);
    }

    private LocalDate firstEventDate(List<Event> events) {
        return events.get(FIRST_EVENT).getDate();
    }

    private TimeSpan createTimeSpan(LocalDate lastDate, Event e) {
        return new TimeSpan(e.getInitialState(), lastDate, e.getDate());
    }

    private TimeSpan createCurrentTimeSpan(LocalDate lastDate, List<Event> events) {
        Event e = events.get(events.size() - 1);
        return new TimeSpan(e.getFinalState(), lastDate, LocalDate.now());
    }

    public static class TimeSpan {

        private final PlantState plantState;
        private final long days;

        public TimeSpan(PlantState plantState, LocalDate initialDate, LocalDate finalDate) {
            this.plantState = plantState;
            this.days = ChronoUnit.DAYS.between(initialDate, finalDate);
        }

        public PlantState getPlantState() {
            return plantState;
        }

        public long getDays() {
            return days;
        }
    }
}
