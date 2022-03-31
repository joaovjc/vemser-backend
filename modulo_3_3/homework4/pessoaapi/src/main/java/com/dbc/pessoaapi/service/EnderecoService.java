package com.dbc.pessoaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public void delete(Integer id) throws Exception {
    	Optional<EnderecoEntity> byId = enderecoRepository.findById(id);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Contato não existe");
        enderecoRepository.delete(byId.get());
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreate) throws RegraDeNegocioException {
    	Optional<PessoaEntity> byId = pessoaRepository.findById(idPessoa);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Pessoa não existe");
    	
    	EnderecoEntity endereco = new EnderecoEntity();
    	endereco.setCep(enderecoCreate.getCep());
    	endereco.setCidade(enderecoCreate.getCidade());
    	endereco.setComplemento(enderecoCreate.getComplemento());
    	endereco.setEstado(enderecoCreate.getEstado());
    	endereco.setLogradouro(enderecoCreate.getLogradouro());
    	endereco.setNumero(enderecoCreate.getNumero());
    	endereco.setPais(enderecoCreate.getPais());
    	endereco.setTipo(TipoEndereco.ofTipo(enderecoCreate.getTipo()));
    	
    	EnderecoEntity save = enderecoRepository.save(endereco);
    	EnderecoDTO enderecoF = objectMapper.convertValue(save, EnderecoDTO.class);
        return enderecoF;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoCreate) throws Exception {
    	Optional<EnderecoEntity> byId = enderecoRepository.findById(id);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Pessoa não existe");
    	
    	EnderecoEntity endereco = objectMapper.convertValue(enderecoCreate, EnderecoEntity.class);
    	endereco.setTipo(TipoEndereco.ofTipo(enderecoCreate.getTipo()));
    	
    	EnderecoEntity save = enderecoRepository.save(endereco);
    	EnderecoDTO enderecoF = objectMapper.convertValue(save, EnderecoDTO.class);
        return enderecoF;
    }


    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll()
        		.stream()
        		.map(enderecoCreate -> {
        			EnderecoDTO endereco = new EnderecoDTO();

        			endereco.setCep(enderecoCreate.getCep());
        	    	endereco.setCidade(enderecoCreate.getCidade());
        	    	endereco.setComplemento(enderecoCreate.getComplemento());
        	    	endereco.setEstado(enderecoCreate.getEstado());
        	    	endereco.setLogradouro(enderecoCreate.getLogradouro());
        	    	endereco.setNumero(enderecoCreate.getNumero());
        	    	endereco.setPais(enderecoCreate.getPais());
        	    	endereco.setTipo(enderecoCreate.getTipo().getTipo());
        			
		        	return endereco;
        		}).collect(Collectors.toList());
    }

//    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
//    	return enderecoRepository.findAllByIdPessoa(idPessoa)
//    			.stream()
//    			.map(t -> {
//    				EnderecoDTO v = objectMapper.convertValue(t , EnderecoDTO.class);
//		        	v.setTipo(t.getTipo().getTipo());
//		        	return v;
//    			})
//    			.collect(Collectors.toList());
//    }

    public EnderecoDTO findById(Integer idEndereco) throws Exception {
    	Optional<EnderecoEntity> byId = enderecoRepository.findById(idEndereco);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Pessoa não existe");
    	
    	EnderecoDTO endereco = objectMapper.convertValue(byId.get(), EnderecoDTO.class);
    	return endereco;
    }
}
