package com.dbc.veiculoproducerconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.dbc.veiculoproducerconsumer.dto.VeiculoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {
	private final VeiculoService veiculoService;
	private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic}", 
            groupId = "group1",
            containerFactory = "listenerContainerFactory")
    public void consume(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset) throws JsonMappingException, JsonProcessingException{
    	log.info("#### recived value:  offset -> '{}' key -> '{}'  ", offset, key);
    	
    	String id = veiculoService.create(objectMapper.readValue(message, VeiculoDTO.class));
    	log.info("#### persisted id -> '{}' ", id);
    	
    }
}