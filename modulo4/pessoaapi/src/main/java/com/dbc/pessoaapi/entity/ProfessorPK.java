package com.dbc.pessoaapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProfessorPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2259396388642199508L;

	@Column(name = "id_universidade")
	private Integer idFaculdade;
	
	@Column(name = "id_professor")
	private Integer idProfessor;
	
}
