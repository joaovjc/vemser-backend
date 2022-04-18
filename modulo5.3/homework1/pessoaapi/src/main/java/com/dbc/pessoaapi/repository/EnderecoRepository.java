package com.dbc.pessoaapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer>{
//	List<EnderecoEntity> findAllByIdPessoa(Integer idPessoa);
	
	@Query("select e from ENDERECO_PESSOA e where e.pais = :nome")
	List<EnderecoEntity> listPorPais(String nome);
	
	Page<EnderecoEntity> findAllByPais(String pais, Pageable pageable);
	
	@Query("select e from ENDERECO_PESSOA e JOIN FETCH e.pessoas p where p.idPessoa = :id")
	List<EnderecoEntity> listPorIdPessoa(Integer id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM ENDERECO_PESSOA ep WHERE ep.COMPLEMENTO IS NULL")
	List<EnderecoEntity> listPorSemComplemento();
	
	@Query(nativeQuery = true, value = "SELECT * FROM ENDERECO_PESSOA ep WHERE ep.CIDADE = 1? OR 2?")
	List<EnderecoEntity> listPorCidadeOuPais(String cidade, String Pais);
	
}
