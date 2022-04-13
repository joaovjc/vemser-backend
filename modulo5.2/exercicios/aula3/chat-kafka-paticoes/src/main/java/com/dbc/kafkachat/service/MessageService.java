package com.dbc.kafkachat.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dbc.kafkachat.Entity.MessageEntity;
import com.dbc.kafkachat.dto.MessageDTO;
import com.dbc.kafkachat.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MessageService {
	private final MessageRepository messageRepository;
	private final ObjectMapper objectMapper;
	
	
	public MessageEntity create(MessageDTO dto, String topico) {
		
		MessageEntity entity = objectMapper.convertValue(dto, MessageEntity.class);
		entity.setTopico(topico);
		MessageEntity save = messageRepository.save(entity);
		
		return save;
	}
	
	public List<MessageDTO> findAll() {
		return messageRepository.findAll().stream().map(m->{
			return MessageDTO.builder().dataCriacao(m.getDataCriacao()).mensagem(m.getMensagem()).usuario(m.getUsuario()).build();
		}).collect(Collectors.toList());
	}
	
	public Page<MessageDTO> findAllPrivateByPessoa(String usuario, String topico, Integer pagina){
		Pageable pageable = PageRequest.of(pagina == null ? 0 : pagina, 10, Sort.by("dataCriacao").ascending());
		List<MessageDTO> collect = messageRepository.findAllByIgnoreCaseUsuarioAndIgnoreCaseTopico(usuario, topico, pageable).stream().map(u->{
			return MessageDTO.builder().dataCriacao(u.getDataCriacao()).mensagem(u.getMensagem()).usuario(u.getUsuario()).build();
		}).collect(Collectors.toList());
		return new PageImpl<MessageDTO>(collect);
	}
	
}
