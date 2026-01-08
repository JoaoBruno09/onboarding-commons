package com.bank.onboarding.commonslib.utils.kafka;

import com.bank.onboarding.commonslib.persistence.exceptions.OnboardingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventSeDeserializer {

    private final ObjectMapper objectMapper;

    public String serialize(Object sendingEvent){
        try {
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsString(sendingEvent);
        } catch (JsonProcessingException e) {
            throw new OnboardingException("Não foi possível serializar o evento " +  e.getMessage());
        }
    }

    public <T> Object deserialize(String eventValue, Class<T> classObject){
        try {
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.readValue(eventValue, classObject);
        } catch (JsonProcessingException e) {
            throw new OnboardingException("Não foi possível serializar o evento " +  e.getMessage());
        }
    }
}
