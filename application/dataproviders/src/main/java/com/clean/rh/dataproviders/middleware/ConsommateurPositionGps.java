package com.clean.rh.dataproviders.middleware;

import com.clean.rh.dataproviders.middleware.converter.PositionGpsConverter;
import com.clean.rh.dataproviders.middleware.entities.PositionGpsK;
import com.clean.rh.entity.PositionGps;
import com.clean.rh.usercase.coordonneesgps.PositionGpsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsommateurPositionGps {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsommateurPositionGps.class);

    private final static String TOPIC_POSITION_GPS = "position_gps";

    private final  PositionGpsRepository positionGpsRepository;

    public ConsommateurPositionGps(PositionGpsRepository positionGpsRepository) {
        this.positionGpsRepository = positionGpsRepository;
    }

    @KafkaListener(topics = TOPIC_POSITION_GPS, groupId = "group_json", containerFactory = "kafkaListenerContainerFactory")
    public PositionGps consommerPositionGps(PositionGpsK positionGpsK) {
        LOGGER.info("Consumer {}",positionGpsK.getMatricule());
        persisterPositionGpsEnBase(positionGpsK);
        return PositionGpsConverter.convertirEnPositionGps(positionGpsK);
    }

    private void persisterPositionGpsEnBase(PositionGpsK positionGpsK) {
        LOGGER.info("Persister position gps de la vehciule avec de la matricule",positionGpsK.getMatricule());
        positionGpsRepository.creerPositionGps(PositionGpsConverter.convertirEnPositionGps(positionGpsK));
    }
}
