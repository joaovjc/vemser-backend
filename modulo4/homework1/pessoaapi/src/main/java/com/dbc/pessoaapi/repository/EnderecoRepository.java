package com.dbc.pessoaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer>{
//	List<EnderecoEntity> findAllByIdPessoa(Integer idPessoa);
}
