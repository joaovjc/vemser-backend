package com.dbc.pessoaapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity(name = "CONTATO")
public class ContatoEntity {

	@Id
	@Column(name = "id_contato")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTATO_SEQ")
	@SequenceGenerator(name = "CONTATO_SEQ", sequenceName = "SEQ_CONTATO", allocationSize = 1)
	private Integer idContato;
	@Column(name = "id_pessoa", insertable = false, updatable = false)
	private Integer idPessoa;
	@Column(name = "tipo")
	@Enumerated(EnumType.ORDINAL)
	private TipoContato tipoContato;
	@Column(name = "numero")
	private String numero;
	@Column(name = "descricao")
	private String descricao;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa")
	private PessoaEntity pessoaEntity;
}
