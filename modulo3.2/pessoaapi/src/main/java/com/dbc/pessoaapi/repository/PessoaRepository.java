package com.dbc.pessoaapi.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dbc.pessoaapi.entity.PessoaEntity;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
	
	List<PessoaEntity> findAllByNomeIgnoreCase(String nome);
	List<PessoaEntity> findByCpf(String cpf);
	List<PessoaEntity> findAllByDataNascimentoBetween(Date inicio, Date fim);
	
	@Query("select p from PESSOA p where p.dataNascimento > :ini AND p.dataNascimento < :fin")
	List<PessoaEntity> listPorData(LocalDate ini, LocalDate fin);
	
	@Query("select p from PESSOA p INNER JOIN p.enderecos e ")
	List<PessoaEntity> listPorEndereco();
	
	@Query(nativeQuery = true, value = "SELECT "
			+ "        * "
			+ "    FROM "
			+ "        PESSOA p "
			+ "    LEFT JOIN"
			+ "        PESSOA_X_PESSOA_ENDERECO e "
			+ "            ON e.ID_PESSOA = p.ID_PESSOA "
			+ "    WHERE"
			+ "        e.ID_PESSOA IS NULL")
	List<PessoaEntity> listPorSemEndereco();
}
