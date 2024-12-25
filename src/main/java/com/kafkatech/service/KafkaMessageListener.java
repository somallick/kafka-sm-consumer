package com.kafkatech.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

    private static final Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

//    @Value("${kafka-topic.name}")
//    private String topicName;

    @KafkaListener(id = "receiver-1", topics = "${kafka-topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMessageFromTopic(String message) {
        log.info("Consumer consume the message - {}", message);
    }

    /*
    * Below listener work like the below kafka command - consume all message from beginning of the topic
    * "kafka-console-consumer.bat --topic <topic-name> --bootstrap-server localhost:<port> --from-beginning"
    */
//    @KafkaListener(id = "receiver-2", groupId = "sm-group-1", topicPartitions = {
//            @TopicPartition(topic = "${kafka-topic.name}",
//                    partitionOffsets = @PartitionOffset(partition ="0-2", initialOffset = "0"))})
//    public void consumeMessageFromBeginnigOfTopic(String message) {
//        log.info("Consumer consume the message2 - {}", message);
//    }

    /*
    * Note - two listener cannot be active for same topic at a time, hence commenting one listener.
    */
}
