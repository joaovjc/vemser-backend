package com.dbc.kafkachat.Entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("mensagem")
public class MessageEntity {
	
	@Id
	private String id;
	private String usuario;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String topico;
	
}
