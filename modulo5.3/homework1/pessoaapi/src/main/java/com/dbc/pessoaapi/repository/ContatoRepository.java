package com.dbc.pessoaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;

@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer>{
   List<ContatoEntity> findAllByIdPessoa(Integer idPessoa);
   
   @Query("select c from CONTATO c where c.tipoContato = :tipo")
	List<ContatoEntity> listPorTipoDeContato(TipoContato tipo);
   
   @Query(value = "SELECT * FROM CONTATO c WHERE c.ID_PESSOA = :id;", nativeQuery = true)
	List<ContatoEntity> listPorIdPessoa(Integer id);
}
