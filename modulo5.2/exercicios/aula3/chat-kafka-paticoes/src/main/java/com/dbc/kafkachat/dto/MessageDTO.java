package com.dbc.kafkachat.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MessageDTO {
	
	private String usuario;
	private String mensagem;
	@Builder.Default
	private LocalDateTime dataCriacao = LocalDateTime.now();
	
}
