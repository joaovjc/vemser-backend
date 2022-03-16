package br.com.dbc.vemser.pessoaapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class EnderecoService {
	
	@Autowired
    private EnderecoRepository enderecoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ObjectMapper objectMapper;
	
    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO){
    	if(pessoaRepository.idExists(enderecoCreateDTO.getIdPessoa())== false)new RegraDeNegocioException("não existe uma pessoa com esse id");
        
    	Endereco endereco = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
		
		log.info("Criando pessoa");
		Endereco enderecoCriado = enderecoRepository.create(endereco);
		
		EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoCriado, EnderecoDTO.class);
    	
        return enderecoDTO;
    	
    }

    public List<EnderecoDTO> list(){
        return enderecoRepository.list()
        		.stream()
        		.map(endereco-> objectMapper.convertValue(endereco, EnderecoDTO.class))
        		.collect(Collectors.toList());
    }

    public EnderecoDTO update(Integer id,
    		EnderecoCreateDTO enderecoCreateDTO){
    	Endereco enderecoAtualizar = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
		
		log.info("Criando Endereco");
		Endereco endereco = enderecoRepository.update(id, enderecoAtualizar);
		
		EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
    	
        return enderecoDTO;
    }

    public void delete(Integer id){
    	enderecoRepository.delete(id);
    }

    public List<EnderecoDTO> listByIdPessoa(long id) {
        return enderecoRepository.listByIdPessoa(id)
        		.stream()
        		.map(endereco-> objectMapper.convertValue(endereco, EnderecoDTO.class))
        		.collect(Collectors.toList());
    }
}
