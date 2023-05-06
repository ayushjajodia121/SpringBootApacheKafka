package com.jajodia.kafka.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic jajodiaTopic(){
        return TopicBuilder.name("jajodia").build();
    }
    @Bean
    public NewTopic pendingEmailsTopic(){
        return TopicBuilder.name("pendingEmail").build();
    }
}
