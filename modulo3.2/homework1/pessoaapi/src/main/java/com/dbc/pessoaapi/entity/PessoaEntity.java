package com.dbc.pessoaapi.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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
@Entity(name = "PESSOA")
public class PessoaEntity {
	@Id
    @Column(name="id_pessoa")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_SEQ")
    @SequenceGenerator(name = "PESSOA_SEQ", sequenceName = "SEQ_PESSOA2", allocationSize = 1)
    private Integer idPessoa;
	@Column(name = "NOME")
    private String nome;
	@Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "CPF")
    private String cpf;
}