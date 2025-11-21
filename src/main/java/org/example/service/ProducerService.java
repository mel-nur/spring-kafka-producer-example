package org.example.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic]")
    private String topic;

    public ProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(Object message){
        this.kafkaTemplate.send(topic, message);
        System.out.println("Message is sent to Kafka" + message);
    }
}
