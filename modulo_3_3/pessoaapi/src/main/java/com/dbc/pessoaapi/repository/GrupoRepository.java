package com.dbc.pessoaapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbc.pessoaapi.entity.GrupoEntity;

public interface GrupoRepository extends JpaRepository<GrupoEntity, Integer>{
	Optional<GrupoEntity> findByNome(String nome);
}
