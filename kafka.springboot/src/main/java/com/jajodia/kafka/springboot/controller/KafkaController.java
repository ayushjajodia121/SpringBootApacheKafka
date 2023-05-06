package com.jajodia.kafka.springboot.controller;

import com.jajodia.kafka.springboot.kafka.KafkaProducer;
import com.jajodia.kafka.springboot.payload.EmailRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class KafkaController {
    private KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendEvent(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to producer");
    };
//    @PostMapping("/publish/pojo")
//    public ResponseEntity<String> sendObjectEvent(@RequestBody EmailRequestModel object){
//        kafkaProducer.sendMessageObject(object);
//        return ResponseEntity.ok("Message Object sent to producer");
//    };
}
