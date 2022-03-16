package br.com.dbc.vemser.pessoaapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa create(Pessoa pessoa){
//    	try {
//    		if(StringUtils.isBlank(pessoa.getNome()) || ObjectUtils.isEmpty(pessoa.getDataNascimento()) 
//    				|| StringUtils.isBlank(pessoa.getCpf()) || pessoa.getCpf().length() == 11) {
//        		throw new InvalidAttributeValueException("preencha os campos corretamente");
//        	}
//    		return pessoaRepository.create(pessoa);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
    	
    	try {
			return pessoaRepository.create(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return null;
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }
}
