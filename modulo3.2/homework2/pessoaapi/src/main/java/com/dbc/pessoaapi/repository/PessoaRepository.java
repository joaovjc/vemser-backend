package com.dbc.pessoaapi.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbc.pessoaapi.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
	
	List<PessoaEntity> findAllByNomeIgnoreCase(String nome);
	Optional<PessoaEntity> findByCpf(String cpf);
	List<PessoaEntity> findAllByDataNascimentoBetween(Date inicio, Date fim);
	
}
