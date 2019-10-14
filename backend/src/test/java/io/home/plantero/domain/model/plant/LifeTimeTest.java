package io.home.plantero.domain.model.plant;

import io.home.plantero.application.util.SampleDataGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LifeTimeTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void process() {
        LocalDate date = LocalDate.of(2019, 5, 21);
        LocalDate dateMinus = date.minus(38, ChronoUnit.DAYS);
        LocalDate datePlus = date.plus(10, ChronoUnit.DAYS);
        Plant plant = new Plant();
        plant.setId(SampleDataGenerator.DefinedPlant.ROYAL_GORILLA_ID);
        plant.setName(SampleDataGenerator.DefinedPlant.ROYAL_GORILLA_NAME);
        List<Event> events = Arrays.asList(
                new Event(plant, dateMinus, null, PlantState.SEED),
                new Event(plant, date, PlantState.SEED, PlantState.SEEDLING),
                new Event(plant, datePlus, PlantState.SEEDLING, PlantState.GROWING)
        );
        LifeTime lifeTime = new LifeTime(plant.getId(), events);
        lifeTime.timeSpanList().forEach(ts -> {
            System.out.println(ts.getPlantState() + " " + ts.getDays());
        });
        //process(events);
    }

    void process(List<Event> events) {
        final List<LifeTime.TimeSpan> spans = new ArrayList<>(events.size());
        LocalDate lastDate = events.get(0).getDate();
        for (int i = 1; i < events.size(); i++) {
            Event e = events.get(i);
            long days = ChronoUnit.DAYS.between(lastDate, e.getDate());
            lastDate = e.getDate();
            System.out.println(e.getInitialState() + " " + days);
        }
        Event e = events.get(events.size() - 1);
        long days = ChronoUnit.DAYS.between(lastDate, LocalDate.now());
        System.out.println(e.getFinalState() + " " + days);
//        System.out.println(e.getInitialState() != null ? e.getInitialState() : e.getFinalState() + " " + days);
    }

    void process2(List<Event> events) {

    }

    @Test
    public void timeSpanList() {
    }
}