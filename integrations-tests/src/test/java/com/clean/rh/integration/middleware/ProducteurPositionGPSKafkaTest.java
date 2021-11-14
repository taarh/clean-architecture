package com.clean.rh.integration.middleware;

import com.clean.rh.dataproviders.middleware.ConsommateurPositionGps;
import com.clean.rh.dataproviders.middleware.ProducteurPositionGPSKafka;
import com.clean.rh.dataproviders.middleware.converter.PositionGpsConverter;
import com.clean.rh.dataproviders.middleware.entities.PositionGpsK;
import com.clean.rh.entity.PositionGps;
import com.clean.rh.usercase.coordonneesgps.emettrecoordonneesgps.StatutEnvoi;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.hasValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.kafka.test.assertj.KafkaConditions.key;


public class ProducteurPositionGPSKafkaTest extends MiddlewarIntegrationTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ProducteurPositionGPSKafkaTest.class);

    private final static String SENDER_TOPIC = "position_gps";

    private final static String MATRICULE="5555";
    private final static String LATITUDE="123.456";
    private final static String LONGITUDE="789.456";

    @Autowired
    private ProducteurPositionGPSKafka producteur;

    @Autowired
    private ConsommateurPositionGps consommateurPositionGps;

    private KafkaMessageListenerContainer<String, PositionGpsK> container;

    private BlockingQueue<ConsumerRecord<String, PositionGpsK>> records;

    private KafkaTemplate<String, PositionGpsK> template;


    @ClassRule
    public static EmbeddedKafkaRule embeddedKafka =
            new EmbeddedKafkaRule(1, true, SENDER_TOPIC);


    @Before
    public void setUp() throws Exception {
        // set up the Kafka consumer properties
        Map<String, Object> consumerProperties =
                KafkaTestUtils.consumerProps("group_id", "false",
                        embeddedKafka.getEmbeddedKafka());

        // create a Kafka consumer factory
        DefaultKafkaConsumerFactory<String, PositionGpsK> consumerFactory =
                new DefaultKafkaConsumerFactory<String, PositionGpsK>(
                        consumerProperties);

        // set the topic that needs to be consumed
        ContainerProperties containerProperties =
                new ContainerProperties(SENDER_TOPIC);

        // create a Kafka MessageListenerContainer
        container = new KafkaMessageListenerContainer<>(consumerFactory,
                containerProperties);

        // create a thread safe queue to store the received message
        records = new LinkedBlockingQueue<>();

        // setup a Kafka message listener
        container
                .setupMessageListener(new MessageListener<String, PositionGpsK>() {
                    @Override
                    public void onMessage(
                            ConsumerRecord<String, PositionGpsK> record) {
                        LOGGER.debug("test-listener received message='{}'",
                                record.toString());
                        records.add(record);
                    }
                });

        // start the container and underlying message listener
        container.start();

        // wait until the container has the required number of assigned partitions
        ContainerTestUtils.waitForAssignment(container,
                embeddedKafka.getEmbeddedKafka().getPartitionsPerTopic());
    }

    @Test
    public void testExample() {

    }

    @Test
    public void testSend() throws InterruptedException {
        // send the message
        String greeting = "Hello Spring Kafka Sender!";
        PositionGps positionGps = PositionGps.builder().matricule(MATRICULE).latitude(LATITUDE).longitude(LONGITUDE).build();

        StatutEnvoi statutEnvoi=producteur.emettreCoordonneesGPSParMatricule(positionGps);

        // Hamcrest Matchers to check the value
        assertEquals(StatutEnvoi.SUCCES,statutEnvoi.SUCCES);
        // AssertJ Condition to check the key
        //assertThat(received).has(key(null));

    }

    @After
    public void tearDown() {
        // stop the container
        container.stop();
    }


}
