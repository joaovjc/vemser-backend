package br.com.dbc.vemser.pessoaapi.controller;

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

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;

@RestController
@RequestMapping("/endereco") // localhost:8080/endereco
public class EnderecoController {
	
	@Autowired
    private EnderecoService enderecoService;

    @PostMapping // localhost:8080/endereco
    public Endereco create(@RequestBody Endereco endereco) {
        return enderecoService.create(endereco);
    }

    @GetMapping // localhost:8080/endereco
    public List<Endereco> list() {
        return enderecoService.list();
    }
    
    @GetMapping("/{byid}") // localhost:8080/Endereco/10
    public List<Endereco> listByid(@PathVariable("byid") long id) {
        return enderecoService.listByIdPessoa(id);
    }
    
    @GetMapping("/{byidpessoa}/pessoa") // localhost:8080/Endereco/100/pessoa
    public List<Endereco> listByidPessoa(@PathVariable("byidpessoa") long byidpessoa) {
        return enderecoService.listByIdPessoa(byidpessoa);
    }

    @PutMapping("/{idendereco}") // localhost:8080/Endereco/1000
    public Endereco update(@PathVariable("idendereco") long id,
                         @RequestBody Endereco enderecoAtualizar) throws Exception {
    	System.out.println(id);
        return enderecoService.update(id, enderecoAtualizar);
    }

    @DeleteMapping("/{idendereco}") // localhost:8080/endereco/10
    public void delete(@PathVariable("idendereco") long id) throws Exception {
        enderecoService.delete(id);
    }
}
