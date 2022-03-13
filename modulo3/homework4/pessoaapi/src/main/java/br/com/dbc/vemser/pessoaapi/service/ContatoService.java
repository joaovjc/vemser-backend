package br.com.dbc.vemser.pessoaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

@Service
public class ContatoService {
	
	@Autowired
    private ContatoRepository ContatoRepository;

    public Contato create(Contato contato){
        return ContatoRepository.create(contato);
    }

    public List<Contato> list(){
        return ContatoRepository.list();
    }

    public Contato update(long id,
    		Contato contatoAtualizar) throws Exception {
        return ContatoRepository.update(id, contatoAtualizar);
    }

    public void delete(long id) throws Exception {
        ContatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(long id) {
        return ContatoRepository.listByIdPessoa(id);
    }
}
