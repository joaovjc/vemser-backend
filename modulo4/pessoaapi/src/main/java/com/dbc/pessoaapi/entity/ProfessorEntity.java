package com.dbc.pessoaapi.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
@Entity(name = "PROFESSOR")
public class ProfessorEntity {
	
	@EmbeddedId
	private ProfessorPK chaveComposta;
	@Column(name = "nome")
	private String nome;
	@Column(name = "salario")
	private Double salario;
	
}
