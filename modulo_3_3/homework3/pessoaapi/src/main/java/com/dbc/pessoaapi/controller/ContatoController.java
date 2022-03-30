package com.dbc.pessoaapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.service.ContatoService;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        contatoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                          @RequestBody ContatoCreateDTO contato) throws Exception {
        return contatoService.create(idPessoa, contato);
    }

    @PutMapping("/{id}")
    public ContatoDTO update(@PathVariable("id") Integer id,
                          @RequestBody ContatoCreateDTO contato) throws Exception {
        return contatoService.update(id, contato);
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    // {{url}}/contato/1/pessoa
    @GetMapping("/{idPessoa}/pessoa")
    public List<ContatoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }
    
    // {{url}}/contato/1/contato
    @GetMapping("/{idContato}/contato")
    public ContatoDTO listByIdContato(@PathVariable("idContato") Integer idContato) throws Exception {
        return contatoService.listByIdContato(idContato);
    }
}