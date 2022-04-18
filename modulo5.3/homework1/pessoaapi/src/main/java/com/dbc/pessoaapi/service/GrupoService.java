package com.dbc.pessoaapi.service;

import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.GrupoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrupoService {
	private final GrupoRepository grupoRepository;
	
	public GrupoEntity achraPorNome(String nome) throws RegraDeNegocioException {
		return grupoRepository.findByNome(nome).orElseThrow(() -> new RegraDeNegocioException("Não Existe Esse Cargo"));
	}
	
}
