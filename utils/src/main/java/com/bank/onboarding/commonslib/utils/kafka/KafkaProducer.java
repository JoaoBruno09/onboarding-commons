package com.bank.onboarding.commonslib.utils.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.bank.onboarding.commonslib.persistence.enums.OperationType.CREATE_ACCOUNT;

@Service
@RequiredArgsConstructor
public class KafkaProducer {

    private final EventSeDeserializer eventSeDeserializer;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(String topicName, CreateAccountEvent createAccountEvent) {
        kafkaTemplate.send(topicName, CREATE_ACCOUNT.name(), eventSeDeserializer.serialize(createAccountEvent));
    }


}
