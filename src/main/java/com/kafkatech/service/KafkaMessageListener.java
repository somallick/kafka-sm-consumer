package com.kafkatech.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @Value("${kafka-topic.name}")
    private String topicName;

    @KafkaListener(topics = "sm-test-topic-3", groupId = "sm-group-1")
    public void consumeMessageFromTopic(String message) {
        log.info("Consumer consume the message - {}", message);
    }
}
