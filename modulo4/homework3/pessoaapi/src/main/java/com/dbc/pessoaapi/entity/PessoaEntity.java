package com.dbc.pessoaapi.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	@JsonIgnore
    @OneToMany(mappedBy="pessoaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoEntity> contatos;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "Pessoa_X_Pessoa_Endereco",
            joinColumns = @JoinColumn(name = "id_pessoa"),
            inverseJoinColumns = @JoinColumn(name= "id_endereco")
    )
    private Set<EnderecoEntity> enderecos;
	
}