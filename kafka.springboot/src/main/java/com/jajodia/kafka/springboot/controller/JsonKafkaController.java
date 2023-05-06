package com.jajodia.kafka.springboot.controller;

import com.jajodia.kafka.springboot.kafka.JsonKafkaProducer;
import com.jajodia.kafka.springboot.payload.EmailRequestModel;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka/json")
@Slf4j
public class JsonKafkaController {

    private JsonKafkaProducer kafkaProducer;
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaController.class);
    public JsonKafkaController (JsonKafkaProducer kafkaProducer){
        this.kafkaProducer=kafkaProducer;
    };
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonEvent(@RequestBody EmailRequestModel obj){
        log.info(String.format("message sent in JSON -> %s",obj.toString()));
        kafkaProducer.sendJsonMessage(obj);
        return ResponseEntity.ok("message in json sent successfully to kafka broker");
    };
}
