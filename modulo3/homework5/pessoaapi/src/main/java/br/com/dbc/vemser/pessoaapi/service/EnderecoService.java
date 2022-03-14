package br.com.dbc.vemser.pessoaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;

@Service
public class EnderecoService {
	
	@Autowired
    private EnderecoRepository enderecoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
    public Endereco create(Endereco endereco){
    	if(pessoaRepository.idExists(endereco.getId())== false)new RegraDeNegocioException("não existe uma pessoa com esse id");
        return enderecoRepository.create(endereco);
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
