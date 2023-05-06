package com.jajodia.kafka.springboot.kafka;

import com.jajodia.kafka.springboot.payload.EmailRequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, EmailRequestModel> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, EmailRequestModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendJsonMessage(EmailRequestModel obj){
        LOGGER.info(String.format("message in json-> %s",obj.toString()));
        Message<EmailRequestModel> message = MessageBuilder
                .withPayload(obj)
                .setHeader(KafkaHeaders.TOPIC,"pendingEmail")
                .build();
        kafkaTemplate.send(message);
    }
}
