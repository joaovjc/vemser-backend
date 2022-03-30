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

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        enderecoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                           @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return enderecoService.create(idPessoa, endereco);
    }

    @PutMapping("/{id}")
    public EnderecoDTO update(@PathVariable("id") Integer id,
                           @RequestBody EnderecoCreateDTO endereco) throws Exception {
        return enderecoService.update(id, endereco);
    }

    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

//    @GetMapping("/{idPessoa}/pessoa")
//    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
//        return enderecoService.listByIdPessoa(idPessoa);
//    }

    @GetMapping("/{idEndereco}")
    public EnderecoDTO findById(@PathVariable("idEndereco") Integer id) throws Exception {
        return enderecoService.findById(id);
    }
}
