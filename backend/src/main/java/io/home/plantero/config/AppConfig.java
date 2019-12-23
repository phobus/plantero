package io.home.plantero.config;

import io.home.plantero.application.util.SampleDataGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Import({ServiceConfig.class, FacadeConfig.class, SampleConfig.class})
public class AppConfig {

}
