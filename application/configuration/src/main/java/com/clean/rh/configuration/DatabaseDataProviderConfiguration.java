package com.clean.rh.configuration;

import com.clean.rh.dataproviders.database.personne.PersonneDataBaseProvider;
import com.clean.rh.dataproviders.database.positionGps.PositionGpsDataBaseProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseDataProviderConfiguration {

    @Bean
    public PersonneDataBaseProvider personneDataBaseProvider(JdbcTemplate jdbcTemplate) {
        return new PersonneDataBaseProvider(jdbcTemplate);
    }
    @Bean
    public PositionGpsDataBaseProvider positionGpsDataBaseProvider(JdbcTemplate jdbcTemplate) {
        return new PositionGpsDataBaseProvider(jdbcTemplate);
    }



}
