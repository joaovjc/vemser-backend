package com.dbc.pessoaapi.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.dto.PessoaDTOComContatos;
import com.dbc.pessoaapi.dto.PessoaDTOComEnderecos;
import com.dbc.pessoaapi.dto.PessoaDTOComEnderecosEContatos;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.PessoaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/pessoa")
@Validated
@Slf4j
@RequiredArgsConstructor
public class PessoaController {
    private final PessoaService pessoaService;


    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        return new ResponseEntity<>(name, HttpStatus.ACCEPTED);
    }


    @PostMapping
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) throws Exception {
        log.info("criando pessoa");
        PessoaDTO pessoaCriado = pessoaService.create(pessoa);
        return new ResponseEntity<>(pessoaCriado, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Voc?? n??o tem permiss??o para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exce????o"),
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

//    @GetMapping("/byname")
//    public List<PessoaDTO> listByName(@RequestParam("nome") @NotEmpty(message = "nome da pessoa n??o informado") String nome) {
//        return pessoaService.listByName(nome);
//    }
    
    
    @GetMapping("/listar-com-contatos")
    public List<PessoaDTOComContatos> listarPessoasComContato(@RequestParam(value = "id", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listComContatos(idPessoa);
    }
    
    @GetMapping("/listar-com-enderecos")
    public List<PessoaDTOComEnderecos> listarPessoasComEnderecos(@RequestParam(value = "id", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listComEnderecos(idPessoa);
    }
    
    @GetMapping("/listar-com-enderecos-e-contatos")
    public List<PessoaDTOComEnderecosEContatos> listarPessoasComEnderecosEContatos(@RequestParam(value = "id", required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listComEnderecosEContatos(idPessoa);
    }
    
    @GetMapping("/listar-por")
    public List<PessoaDTO> listarPor(@RequestParam(value = "nome", required = false) String nome, @RequestParam(value = "cpf", required = false) String cpf, @RequestParam(value = "datainicio", required = false)Date inicio, @RequestParam(value = "datafim", required = false) Date fim) throws RegraDeNegocioException {
        return pessoaService.listPor(nome, cpf, inicio, fim);
    }

    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                         @RequestBody @Valid PessoaCreateDTO pessoaAtualizar) throws Exception {
        return pessoaService.update(id, pessoaAtualizar);
    }

    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }


}
