package com.tracker.configuration;

import com.tracker.dataproviders.middleware.entities.PositionGpsK;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfiguration {


    @Bean
    ConcurrentKafkaListenerContainerFactory<String, PositionGpsK>
    kafkaListenerContainerFactory(ConsumerFactory<String, PositionGpsK> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, PositionGpsK> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ProducerFactory<String, PositionGpsK> producerFactory() {
        return new DefaultKafkaProducerFactory<>(senderProps());
    }

    private Map<String, Object> senderProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        //...
        return props;
    }

    @Bean
    public KafkaTemplate<String, PositionGpsK> kafkaTemplate(ProducerFactory<String, PositionGpsK> producerFactory) {
        return new KafkaTemplate<String, PositionGpsK>(producerFactory);
    }

    @Bean
    public ConsumerFactory<String, PositionGpsK> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerProps(), new StringDeserializer(), new JsonDeserializer<>(PositionGpsK.class));
    }

    private Map<String, Object> consumerProps() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // ...
        return props;
    }

}
