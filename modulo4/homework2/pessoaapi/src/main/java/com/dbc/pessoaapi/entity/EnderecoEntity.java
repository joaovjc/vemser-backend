package com.dbc.pessoaapi.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Entity(name = "ENDERECO_PESSOA")
public class EnderecoEntity {

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
	@SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "SEQ_ENDERECO", allocationSize = 1)
	private Integer idEndereco;
	@Column(name = "tipo")
	@Enumerated(EnumType.ORDINAL)
	private TipoEndereco tipo;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "cep")
	private String cep;
	@Column(name = "cidade")
	private String cidade;
	@Column(name = "estado")
	private String estado;
	@Column(name = "pais")
	private String pais;
	@JsonIgnore
	@ManyToMany(mappedBy = "enderecos")
	private Set<PessoaEntity> pessoas;
}
