package com.dbc.kafkachat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.kafkachat.Entity.enums.TopicsEnum;
import com.dbc.kafkachat.dto.MessageDTO;
import com.dbc.kafkachat.service.ProdutorService;
import com.fasterxml.jackson.core.JsonProcessingException;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/enviar")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;
    
    private final String user = "joao"; 

    @PostMapping("/geral")
    private void enviar(@RequestParam(name = "Mensagem") String mensagem) throws JsonProcessingException {
        produtorService.enviarMensagemGeral(MessageDTO.builder().mensagem(mensagem).usuario(user).build());
    }
    
    @PostMapping("/varios")
    private void enviarVarios(@RequestParam(name = "Mensagem") String mensagem, @RequestParam(name = "Destinatários") List<TopicsEnum> topics) throws JsonProcessingException {
        produtorService.enviarMensagens(MessageDTO.builder().mensagem(mensagem).usuario(user).build(),topics);
    }
}