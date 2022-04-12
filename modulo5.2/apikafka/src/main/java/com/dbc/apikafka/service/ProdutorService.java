package com.dbc.apikafka.service;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
    private final KafkaTemplate<String,String> kafkaTemplate;

    @Value(value = "${kafka.topic}")
    private String topic; //meu-primeiro-topico

    public void enviarMensagem(String mensagem) {
        Message<String> message = MessageBuilder.withPayload(mensagem)
                .setHeader(KafkaHeaders.TOPIC, topic)
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
}