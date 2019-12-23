package io.home.plantero.config;

import io.home.plantero.application.util.SampleDataGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class SampleConfig {

    @Bean
    public SampleDataGenerator sampleDataGenerator(JdbcTemplate jdbcTemplate) {
        return new SampleDataGenerator(jdbcTemplate);
    }
}
