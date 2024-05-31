package com.bank.onboarding.commonslib.utils.kafka;

import com.bank.onboarding.commonslib.persistence.enums.OperationType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    private final EventSeDeserializer eventSeDeserializer;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendEvent(String topicName, OperationType operationType, Object sendingEvent) {
        String operationTypeString = "";
        if(operationType != null) operationTypeString = operationType.name();
        String eventSerialized = eventSeDeserializer.serialize(sendingEvent);
        log.info("Sent message to {} for operation type {} with event {}", topicName, operationTypeString, eventSerialized);

        kafkaTemplate.send(topicName, operationTypeString, eventSerialized);
    }
}
