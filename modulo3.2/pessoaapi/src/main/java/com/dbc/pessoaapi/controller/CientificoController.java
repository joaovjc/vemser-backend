package com.dbc.pessoaapi.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ciencia")
@Validated
@RequiredArgsConstructor
public class CientificoController {
	private final PessoaRepository pessoaRepository;
	private final EnderecoRepository enderecoRepository;
	private final ContatoRepository contatoRepository;
	
	
	@GetMapping("/byendereco")
	public List<PessoaEntity> listByEndereco() {
		return pessoaRepository.listPorEndereco();
	}
	
  @GetMapping("/bydata")
  public List<PessoaEntity> listByData(@RequestParam("dataini") LocalDate ini, 
		  @RequestParam("datafin") LocalDate fin) {
      return pessoaRepository.listPorData(ini, fin);
  }
	
  @GetMapping("/bypais")
  public List<EnderecoEntity> listByPais(@RequestParam("nomepais") @NotEmpty(message = "Nome Do Pais não informado") String nome) {
      return enderecoRepository.listPorPais(nome);
  }
  
  @GetMapping("/enderecobyIdPEssoa")
  public List<EnderecoEntity> listByIdPessoa(@RequestParam("idpessoa") Integer id) {
      return enderecoRepository.listPorIdPessoa(id);
  }
  
  @GetMapping("/bytipoContato")
  public List<ContatoEntity> listByTipo(@RequestParam("tipo") TipoContato tipo) {
      return contatoRepository.listPorTipoDeContato(tipo);
  }
  
  @GetMapping("/byidnative")
  public List<ContatoEntity> listByIdNative(@RequestParam("id") Integer id) {
      return contatoRepository.listPorIdPessoa(id);
  }
  
  @GetMapping("/bysemendereco")
  public List<PessoaEntity> listBySem() {
      return pessoaRepository.listPorSemEndereco();
  }
  
  @GetMapping("/bypaisoucidade")
  public List<EnderecoEntity> listByPaisOuCidade(@RequestParam("nomepais") @NotEmpty(message = "Nome Do Pais não informado") String nomePais,
		  @RequestParam("nomecidade") @NotEmpty(message = "Nome Do Pais não informado") String nomeCidade) {
      return enderecoRepository.listPorCidadeOuPais(nomePais,nomeCidade);
  }
  @GetMapping("/bysemcomplemento")
  public List<EnderecoEntity> listByPaisOuCidade() {
      return enderecoRepository.listPorSemComplemento();
  }
}
