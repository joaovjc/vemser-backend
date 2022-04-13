package com.dbc.kafkachat.service;
import java.util.List;
import java.util.UUID;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.dbc.kafkachat.Entity.enums.TopicsEnum;
import com.dbc.kafkachat.dto.MessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String,String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    
    
    public void enviarMensagemGeral(MessageDTO dto) throws JsonProcessingException {
    	String mensagem = objectMapper.writeValueAsString(dto);
    	this.send(mensagem,TopicsEnum.GERAL);
    }

    private void send(String mensagem, TopicsEnum topic) {
        Message<String> message = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topic.getNome())
                .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                .build();

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info(" Log enviado: {} ", mensagem);
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error(" Erro: {}", mensagem, ex);
            }
        });
    }
    
    private void sendOneOrMore(String mensagem, List<TopicsEnum> topics) {
    	for (TopicsEnum topicsEnum : topics) {
    		Message<String> message = MessageBuilder.withPayload(mensagem)
                    .setHeader(KafkaHeaders.TOPIC, topicsEnum.getNome())
                    .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                    .build();

            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message);

            future.addCallback(new ListenableFutureCallback<>() {
                @Override
                public void onSuccess(SendResult<String, String> result) {
                    log.info(" Log enviado para topicsEnum: {} ", mensagem);
                }

                @Override
                public void onFailure(Throwable ex) {
                    log.error(" Erro: {}", mensagem, ex);
                }
            });
		}
    }
    
    public void enviarMensagens(MessageDTO dto, List<TopicsEnum> topicsEnums) throws JsonProcessingException {
    	String mensagem = objectMapper.writeValueAsString(dto);
    	this.sendOneOrMore(mensagem, topicsEnums);
    }
}