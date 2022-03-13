package br.com.dbc.vemser.pessoaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Endereco contato){
        return enderecoRepository.create(contato);
    }

    public List<Endereco> list(){
        return enderecoRepository.list();
    }

    public Endereco update(long id,
    		Endereco enderecoAtualizar) throws Exception {
        return enderecoRepository.update(id, enderecoAtualizar);
    }

    public void delete(long id) throws Exception {
    	enderecoRepository.delete(id);
    }

    public List<Endereco> listByIdPessoa(long id) {
        return enderecoRepository.listByIdPessoa(id);
    }
}
