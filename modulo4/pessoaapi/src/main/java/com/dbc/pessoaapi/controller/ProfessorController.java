package com.dbc.pessoaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	@Autowired
	private ProfessorRepository professorRepository;
	
	@PostMapping()
    public ProfessorEntity create(@RequestBody ProfessorEntity professor) throws Exception {
        return professorRepository.save(professor);
    }
	@GetMapping
	public List<ProfessorEntity> findAll() {
		return professorRepository.findAll();
	}
}
