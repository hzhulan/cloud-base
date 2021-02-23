package com.fh.kafka.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaProducerConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerConfig.class);

    @Resource
    private KafkaProperties kafkaProperties;

    private Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServer());

        KafkaProperties.Producer producer = kafkaProperties.getProducer();
        props.put(ProducerConfig.RETRIES_CONFIG, kafkaProperties.getProducer().getRetries());

        Class<?> keySerializeClazz = null;
        Class<?> valueSerializeClazz = null;
        try {
            keySerializeClazz = Class.forName(producer.getKeySerializer());
            valueSerializeClazz = Class.forName(producer.getValueSerializer());
        } catch (ClassNotFoundException e) {
            LOGGER.error("【KafkaProducerConfig.producterFactory】", e);
        }
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializeClazz);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializeClazz);

        return props;
    }

    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
}
