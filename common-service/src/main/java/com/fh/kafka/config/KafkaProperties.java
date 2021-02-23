package com.fh.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.kafka")
public class KafkaProperties {

    private String bootstrapServer;

    /**
     * 生产者
     */
    private Producer producer;

    /**
     * 消费者
     */
    private Consumer consumer;

    //<editor-fold desc="setter and getter">
    public String getBootstrapServer() {
        return bootstrapServer;
    }

    public void setBootstrapServer(String bootstrapServer) {
        this.bootstrapServer = bootstrapServer;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
    //</editor-fold>

    public static class Producer {
        String keySerializer;

        String valueSerializer;

        Integer retries;

        //<editor-fold desc="setter and getter">
        public String getKeySerializer() {
            return keySerializer;
        }

        public void setKeySerializer(String keySerializer) {
            this.keySerializer = keySerializer;
        }

        public String getValueSerializer() {
            return valueSerializer;
        }

        public void setValueSerializer(String valueSerializer) {
            this.valueSerializer = valueSerializer;
        }

        public Integer getRetries() {
            return retries;
        }

        public void setRetries(Integer retries) {
            this.retries = retries;
        }
        //</editor-fold>

        //<editor-fold desc="toString">
        @Override
        public String toString() {
            return "Producer{" +
                    "keySerializer='" + keySerializer + '\'' +
                    ", valueSerializer='" + valueSerializer + '\'' +
                    ", retries=" + retries +
                    '}';
        }
        //</editor-fold>
    }

    public static class Consumer {
        String groupId;

        boolean enableAutoCommit;

        String keyDeserializer;

        String valueDeserializer;

        //<editor-fold desc="setter and getter">
        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public boolean isEnableAutoCommit() {
            return enableAutoCommit;
        }

        public void setEnableAutoCommit(boolean enableAutoCommit) {
            this.enableAutoCommit = enableAutoCommit;
        }

        public String getKeyDeserializer() {
            return keyDeserializer;
        }

        public void setKeyDeserializer(String keyDeserializer) {
            this.keyDeserializer = keyDeserializer;
        }

        public String getValueDeserializer() {
            return valueDeserializer;
        }

        public void setValueDeserializer(String valueDeserializer) {
            this.valueDeserializer = valueDeserializer;
        }
        //</editor-fold>

        //<editor-fold desc="toString">
        @Override
        public String toString() {
            return "Consumer{" +
                    "groupId='" + groupId + '\'' +
                    ", enableAutoCommit=" + enableAutoCommit +
                    ", keyDeserializer='" + keyDeserializer + '\'' +
                    ", valueDeserializer='" + valueDeserializer + '\'' +
                    '}';
        }
        //</editor-fold>
    }
}
