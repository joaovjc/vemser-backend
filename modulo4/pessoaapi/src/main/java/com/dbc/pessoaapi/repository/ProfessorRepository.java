package com.dbc.pessoaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.entity.ProfessorPK;

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {

}
