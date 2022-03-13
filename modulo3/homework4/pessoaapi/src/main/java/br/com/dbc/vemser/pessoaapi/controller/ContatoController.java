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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.PropertiReader;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {
	
	@Autowired
    private ContatoService contatoService;
	@Autowired
	private PropertiReader propertiReader;

    @PostMapping // localhost:8080/contato
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @GetMapping // localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/byidpessoa") // localhost:8080/contato/byidpessoa?id=1
    public List<Contato> listByid(@RequestParam("id") long id) {
        return contatoService.listByIdPessoa(id);
    }

    @PutMapping("/{idcontato}") // localhost:8080/contato/1000
    public Contato update(@PathVariable("idcontato") long id,
                         @RequestBody Contato contatoAtualizar) throws Exception {
    	System.out.println(id);
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idcontato}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idcontato") long id) throws Exception {
        contatoService.delete(id);
    }
    
    @GetMapping("/ambiente")
    public String ambiente() {
    	return propertiReader.getAmbiente();
    }
}
