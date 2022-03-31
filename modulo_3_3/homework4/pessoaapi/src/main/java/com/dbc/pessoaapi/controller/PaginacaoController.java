package com.dbc.pessoaapi.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/paginacao")
@Validated
@RequiredArgsConstructor
public class PaginacaoController {
	private final EnderecoRepository enderecoRepository;
	private final ContatoRepository contatoRepository;

	@GetMapping("/list-contatos")
	public Page<ContatoEntity> listContatos(@RequestParam(name = "paginaSolicitada") Integer paginaSolicitada
			, @RequestParam(name = "tamanhoPorPagina")Integer tamanhoPorPagina) {
		Pageable p =  PageRequest.of(paginaSolicitada, tamanhoPorPagina, Sort.by("descricao").descending());
		return contatoRepository.findAll(p);
	}
	
	@GetMapping("/list-enderecos")
	public Page<EnderecoEntity> listEnderecos(@RequestParam(name = "paginaSolicitada") Integer paginaSolicitada
			, @RequestParam(name = "tamanhoPorPagina")Integer tamanhoPorPagina,
			@RequestParam(name = "nomepais")String nomePais) {
		Pageable p =  PageRequest.of(paginaSolicitada, tamanhoPorPagina);
		return enderecoRepository.findAllByPais(nomePais,p);
	}
	
	@GetMapping("/list-enderecos-por-cep")
	public Page<EnderecoEntity> listEnderecosPorCep(@RequestParam(name = "paginaSolicitada") Integer paginaSolicitada
			, @RequestParam(name = "tamanhoPorPagina")Integer tamanhoPorPagina) {
		
		Pageable p =  PageRequest.of(paginaSolicitada, tamanhoPorPagina, Sort.by("cep").descending());
		return enderecoRepository.findAll(p);
		
	}
}
