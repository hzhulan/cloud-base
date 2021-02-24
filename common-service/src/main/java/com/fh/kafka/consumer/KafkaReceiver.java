package com.fh.kafka.consumer;

import com.fh.kafka.config.KafkaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class KafkaReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReceiver.class);

//    @Resource
    private KafkaProperties kafkaProperties;

//    @KafkaListener(topics = "test")
    public void receive(String msg) {
        LOGGER.info("【消费者消费消息】{}", msg);
    }
}
