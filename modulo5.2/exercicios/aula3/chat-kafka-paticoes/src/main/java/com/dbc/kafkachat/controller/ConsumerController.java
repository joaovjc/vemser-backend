package com.dbc.kafkachat.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.kafkachat.Entity.enums.ChatEnum;
import com.dbc.kafkachat.Entity.enums.UsersEnum;
import com.dbc.kafkachat.dto.MessageDTO;
import com.dbc.kafkachat.service.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ler")
@RequiredArgsConstructor
public class ConsumerController {
	private final MessageService messageService;
	
	@GetMapping("/chat-privado")
	public Page<MessageDTO> lerMensagensPrivadasPorUsusario(@RequestParam() UsersEnum enu, @RequestParam() ChatEnum chatEnum, Integer pagina ){
		return messageService.findAllPrivateByPessoa(enu.getNome(), chatEnum.getNome(), pagina);
	}
}
