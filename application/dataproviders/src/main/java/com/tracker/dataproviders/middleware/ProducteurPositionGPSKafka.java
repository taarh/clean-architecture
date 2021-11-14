package com.tracker.dataproviders.middleware;

import com.tracker.dataproviders.middleware.converter.PositionGpsConverter;
import com.tracker.dataproviders.middleware.entities.PositionGpsK;
import com.tracker.entity.PositionGps;
import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.EmettreCoordonneesGPSProvider;
import com.tracker.usercase.coordonneesgps.emettrecoordonneesgps.StatutEnvoi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

public class ProducteurPositionGPSKafka implements EmettreCoordonneesGPSProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducteurPositionGPSKafka.class);
    private final static String TOPIC_POSITION_GPS = "position_gps";
    private final KafkaTemplate<String, PositionGpsK> kafkaTemplate;
    private StatutEnvoi statutEnvoi;


    public ProducteurPositionGPSKafka(KafkaTemplate<String, PositionGpsK> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public StatutEnvoi emettreCoordonneesGPSParMatricule(PositionGps positionGPS) {
        LOGGER.info("envoyer la position de la vehicule avec matricule {}", positionGPS.getMatricule());
        final StatutEnvoi statutEnvo;
        ListenableFuture<SendResult<String, PositionGpsK>> future = kafkaTemplate.send(TOPIC_POSITION_GPS, positionGPS.getMatricule(), PositionGpsConverter.convertirEnPositionGpsK(positionGPS));
        future.addCallback(new ListenableFutureCallback<SendResult<String, PositionGpsK>>() {
            @Override
            public void onSuccess(SendResult<String, PositionGpsK> result) {
                LOGGER.info("transmettre le  message= " + result + " avec offset= " + result.getRecordMetadata().offset());
                setReponse(StatutEnvoi.SUCCES);
            }
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("impossible d'envoyer le message = " + positionGPS, ex);
                setReponse(StatutEnvoi.ERREUR);

            }

        });
        return this.statutEnvoi;
    }

    private void setReponse(StatutEnvoi statutEnvoi) {
        this.statutEnvoi = statutEnvoi;
    }


}
