package br.com.dbc.vemser.pessoaapi.service;

import java.util.List;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

public class ContatoService {

    private ContatoRepository ContatoRepository;

    public ContatoService(){
        ContatoRepository = new ContatoRepository();
    }

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
