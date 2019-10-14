package io.home.plantero.application.util;

import io.home.plantero.domain.model.plant.PlantState;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SampleDataGenerator {

    public static final int INITIAL_VERSION = 0;

    private static Long value = 0L;

    private static Long nextId() {
        return value++;
    }

    public static class DefinedSpecies {
        public static final Long CHERRY_TOMATO_ID = nextId();
        public static final String CHERRY_TOMATO_NAME = "Cherry tomato";
        public static final String CHERRY_TOMATO_HTML = "https://en.wikipedia.org/wiki/Cherry_tomato";

        public static final String INSERT_SQL = "INSERT INTO species (id, version, name, url) VALUES (?, ?, ?, ?)";

        public static final Object[][] INSERT_ARGS = {
                {CHERRY_TOMATO_ID, INITIAL_VERSION, CHERRY_TOMATO_NAME, CHERRY_TOMATO_HTML}
        };
    }

    public static class DefinedPlant {

        private static String plantName(String name) {
            return name;
        }

        public static final Long CHERRY_TOMATO_ID = nextId();
        public static final String CHERRY_TOMATO_NAME = plantName(DefinedSpecies.CHERRY_TOMATO_NAME);

        public static final String INSERT_SQL = "INSERT INTO plant (id, version, name, state, species_id, mother_id) VALUES (?, ?, ?, ?, ?, ?)";
        public static final Object[][] INSERT_ARGS = {
                {CHERRY_TOMATO_ID, INITIAL_VERSION, CHERRY_TOMATO_NAME, PlantState.GROWING.name(), DefinedSpecies.CHERRY_TOMATO_ID, null},
        };
    }

    public static class DefinedEvent {

        public static LocalDate SEED_DATE = LocalDate.of(2019, 1, 1);
        public static final Long CHERRY_TOMATO_TO_SEED_ID = nextId();

        public static LocalDate SEEDLING_DATE = LocalDate.of(2019, 5, 7);
        public static final Long CHERRY_TOMATO_TO_SEEDLING_ID = nextId();

        public static LocalDate GROWING_DATE = SEEDLING_DATE.plus(10, ChronoUnit.DAYS);
        public static final Long CHERRY_TOMATO_TO_GROWING_ID = nextId();

        private static final String INSERT_SQL = "INSERT INTO event (id, version, plant_id, date, initial_state, final_state) VALUES (?, ?, ?, ?, ?, ?)";
        public static final Object[][] INSERT_ARGS = {
                {CHERRY_TOMATO_TO_SEED_ID, INITIAL_VERSION, DefinedPlant.CHERRY_TOMATO_ID, SEED_DATE, null, PlantState.SEED.name()},
                {CHERRY_TOMATO_TO_SEEDLING_ID, INITIAL_VERSION, DefinedPlant.CHERRY_TOMATO_ID, SEEDLING_DATE, PlantState.SEED.name(), PlantState.SEEDLING.name()},
                {CHERRY_TOMATO_TO_GROWING_ID, INITIAL_VERSION, DefinedPlant.CHERRY_TOMATO_ID, GROWING_DATE, PlantState.SEEDLING.name(), PlantState.GROWING.name()},
        };
    }

    public static class DefinedClones {
        private static String cloneName(String motherName, int index) {
            return "Clone " + motherName + "#" + index;
        }

        public static final Long CHERRY_TOMATO_ID_1 = nextId();
        public static final String CHERRY_TOMATO_NAME_1 = cloneName(DefinedPlant.CHERRY_TOMATO_NAME, 1);

        public static final Long CHERRY_TOMATO_ID_2 = nextId();
        public static final String CHERRY_TOMATO_NAME_2 = cloneName(DefinedPlant.CHERRY_TOMATO_NAME, 2);

        public static final String INSERT_SQL = DefinedPlant.INSERT_SQL;
        public static final Object[][] INSERT_ARGS = {
                {CHERRY_TOMATO_ID_1, INITIAL_VERSION, CHERRY_TOMATO_NAME_1, PlantState.GROWING.name(), DefinedSpecies.CHERRY_TOMATO_ID, DefinedPlant.CHERRY_TOMATO_ID},
                {CHERRY_TOMATO_ID_2, INITIAL_VERSION, CHERRY_TOMATO_NAME_2, PlantState.GROWING.name(), DefinedSpecies.CHERRY_TOMATO_ID, DefinedPlant.CHERRY_TOMATO_ID},
        };
    }

    public static class DefinedCloneEvent {

        public static LocalDate CLONE_DATE = LocalDate.of(2019, 9, 27);
        public static final Long CHERRY_TOMATO_TO_CLONE_ID_1 = nextId();
        public static final Long CHERRY_TOMATO_TO_CLONE_ID_2 = nextId();

        public static LocalDate ROOTING_DATE = CLONE_DATE;
        public static final Long CHERRY_TOMATO_TO_ROOTING_ID_1 = nextId();
        public static final Long CHERRY_TOMATO_TO_ROOTING_ID_2 = nextId();

        public static LocalDate GROWING_DATE = LocalDate.of(2019, 10, 10);
        public static final Long CHERRY_TOMATO_TO_GROWING_ID_1 = nextId();

        public static LocalDate DIE_DATE = LocalDate.of(2019, 10, 13);
        public static final Long CHERRY_TOMATO_TO_DIE_ID_1 = nextId();

        public static final String INSERT_SQL = DefinedEvent.INSERT_SQL;
        public static final Object[][] INSERT_ARGS = {
                {CHERRY_TOMATO_TO_CLONE_ID_1, INITIAL_VERSION, DefinedClones.CHERRY_TOMATO_ID_1, CLONE_DATE, null, PlantState.CLONE.name()},
                {CHERRY_TOMATO_TO_CLONE_ID_2, INITIAL_VERSION, DefinedClones.CHERRY_TOMATO_ID_2, CLONE_DATE, null, PlantState.CLONE.name()},

                {CHERRY_TOMATO_TO_ROOTING_ID_1, INITIAL_VERSION, DefinedClones.CHERRY_TOMATO_ID_1, ROOTING_DATE, PlantState.CLONE.name(), PlantState.ROOTING.name()},
                {CHERRY_TOMATO_TO_ROOTING_ID_2, INITIAL_VERSION, DefinedClones.CHERRY_TOMATO_ID_2, ROOTING_DATE, PlantState.CLONE.name(), PlantState.ROOTING.name()},

                {CHERRY_TOMATO_TO_GROWING_ID_1, INITIAL_VERSION, DefinedClones.CHERRY_TOMATO_ID_1, GROWING_DATE, PlantState.ROOTING.name(), PlantState.GROWING.name()},

                {CHERRY_TOMATO_TO_DIE_ID_1, INITIAL_VERSION, DefinedClones.CHERRY_TOMATO_ID_2, DIE_DATE, PlantState.ROOTING.name(), PlantState.DIE.name()},
        };
    }


    private final JdbcTemplate jdbcTemplate;

    public SampleDataGenerator(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void generate() {
        populateSpecies();
        populatePlants();
        populateClones();
    }

    public void populateSpecies() {
        executeUpdate(jdbcTemplate, DefinedSpecies.INSERT_SQL, DefinedSpecies.INSERT_ARGS);
    }

    public void populatePlants() {
        executeUpdate(jdbcTemplate, DefinedPlant.INSERT_SQL, DefinedPlant.INSERT_ARGS);
        executeUpdate(jdbcTemplate, DefinedEvent.INSERT_SQL, DefinedEvent.INSERT_ARGS);
    }

    public void populateClones() {
        executeUpdate(jdbcTemplate, DefinedClones.INSERT_SQL, DefinedClones.INSERT_ARGS);
        executeUpdate(jdbcTemplate, DefinedCloneEvent.INSERT_SQL, DefinedCloneEvent.INSERT_ARGS);
    }

    private static void executeUpdate(JdbcTemplate jdbcTemplate, String sql, Object[][] args) {
        for (Object[] arg : args) {
            jdbcTemplate.update(sql, arg);
        }
    }
}
