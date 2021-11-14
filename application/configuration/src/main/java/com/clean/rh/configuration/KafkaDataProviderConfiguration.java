package com.clean.rh.configuration;

import com.clean.rh.dataproviders.middleware.ConsommateurPositionGps;
import com.clean.rh.dataproviders.middleware.ProducteurPositionGPSKafka;
import com.clean.rh.dataproviders.middleware.entities.PositionGpsK;
import com.clean.rh.usercase.coordonneesgps.PositionGpsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaDataProviderConfiguration {
    @Bean
    public ProducteurPositionGPSKafka coordonneesGPSKafkaProvider(KafkaTemplate<String, PositionGpsK> kafkaTemplate) {
        return new ProducteurPositionGPSKafka(kafkaTemplate);
    }

    @Bean
    public ConsommateurPositionGps consommateurPositionGps(PositionGpsRepository positionGpsRepository) {
        return new ConsommateurPositionGps(positionGpsRepository);
    }


}
