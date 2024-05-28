package com.bank.onboarding.commonslib.utils.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    public void sendEvent(String topicName, CreateAccountEvent createAccountEvent) {
        try{
            objectMapper.registerModule(new JavaTimeModule());
            kafkaTemplate.send(topicName, objectMapper.writeValueAsString(createAccountEvent));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
