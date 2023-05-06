package com.jajodia.kafka.springboot.kafka;

import com.jajodia.kafka.springboot.payload.EmailRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumerEmailRequest {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumerEmailRequest.class);
    @KafkaListener(topics = "pendingEmail",groupId = "myGroup")
    public void consumeJsonEmails(EmailRequestModel obj){
        LOGGER.info(String.format("json message received is -> %s",obj.toString()));
    }
}
