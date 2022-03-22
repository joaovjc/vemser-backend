package com.dbc.pessoaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbc.pessoaapi.entity.ContatoEntity;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer>{
   List<ContatoEntity> findAllByIdPessoa(Integer idPessoa);
}
