package com.bank.onboarding.commonslib.utils.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final KafkaTemplate<String, CreateAccountEvent> kafkaTemplate;
    public void sendEvent(String topicName, CreateAccountEvent createAccountEvent){
        kafkaTemplate.send(topicName, createAccountEvent);
    }
}
