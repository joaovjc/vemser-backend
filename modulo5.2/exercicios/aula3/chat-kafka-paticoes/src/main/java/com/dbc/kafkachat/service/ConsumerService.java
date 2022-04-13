package com.dbc.kafkachat.service;

import java.time.format.DateTimeFormatter;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.dbc.kafkachat.Entity.MessageEntity;
import com.dbc.kafkachat.dto.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class ConsumerService {
	private final MessageService messageService;
	private final ObjectMapper objectMapper;
	
    @KafkaListener( 
            groupId = "${kafka.yours.groupid}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "todos",
            topicPartitions = {@TopicPartition(topic = "${kafka.topic}", partitions = {"0","8"})})
    public void consumeGeral(@Payload String message,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                        @Header(KafkaHeaders.OFFSET) Long offset,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer part) throws JsonMappingException, JsonProcessingException{
    	
    	MessageDTO readValue = objectMapper.readValue(message, MessageDTO.class);
    	if(part==0) {
	    	log.info(readValue.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" ["+readValue.getUsuario()+"] : "+ readValue.getMensagem());
	    	MessageEntity create = messageService.create(readValue,"geral");
	    	log.info("persistido a mensagem de id: "+ create.getId());
    	}else {
    		log.info(readValue.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) +" ["+readValue.getUsuario()+"] (private): "+ readValue.getMensagem());
        	MessageEntity create = messageService.create(readValue, "private");
        	log.info("persistido a mensagem de id: "+ create.getId());
    	}
    }
}