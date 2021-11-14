package com.tracker.configuration;

import com.tracker.dataproviders.middleware.ConsommateurPositionGps;
import com.tracker.dataproviders.middleware.ProducteurPositionGPSKafka;
import com.tracker.dataproviders.middleware.entities.PositionGpsK;
import com.tracker.usercase.coordonneesgps.PositionGpsRepository;
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
