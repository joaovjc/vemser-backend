package com.dbc.pessoaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public void delete(Integer id) throws Exception {
    	Optional<ContatoEntity> byId = contatoRepository.findById(id);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Contato não existe");
        contatoRepository.delete(byId.get());
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contatoCreate) throws Exception {
    	Optional<PessoaEntity> byId = pessoaRepository.findById(idPessoa);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Pessoa não existe");
    	ContatoEntity contato = new ContatoEntity();
    	contato.setDescricao(contatoCreate.getDescricao());
    	contato.setIdPessoa(contatoCreate.getIdPessoa());
    	contato.setNumero(contatoCreate.getNumero());
    	contato.setTipoContato(TipoContato.ofTipo(contatoCreate.getTipoContato()));
    	ContatoEntity save = contatoRepository.save(contato);
    	ContatoDTO contatoF = objectMapper.convertValue(save, ContatoDTO.class);
        return contatoF;
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoCreate) throws Exception {
    	Optional<ContatoEntity> byId = contatoRepository.findById(id);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Contato não existe");
    	ContatoEntity contato = byId.get();
    	contato.setDescricao(contatoCreate.getDescricao());
    	contato.setNumero(contatoCreate.getNumero());
    	contato.setTipoContato(TipoContato.ofTipo(contatoCreate.getTipoContato()));
    	ContatoEntity save = contatoRepository.save(contato);
    	ContatoDTO contatoF = objectMapper.convertValue(save, ContatoDTO.class);
        return contatoF;
        
    }


    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
        		.stream()
        		.map(t -> {
		        	ContatoDTO v = new ContatoDTO();
		        	v.setDescricao(t.getDescricao());
		        	v.setIdContato(t.getIdContato());
		        	v.setIdPessoa(t.getIdPessoa());
		        	v.setNumero(t.getNumero());
		        	v.setTipoContato(t.getTipoContato().getTipo());
		        	return v;
        		}).collect(Collectors.toList());
      	}

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.findAllByIdPessoa(idPessoa).stream().map(t -> {
        	ContatoDTO v = objectMapper.convertValue(t , ContatoDTO.class);
        	v.setTipoContato(t.getTipoContato().getTipo());
        	return v;
        	}).collect(Collectors.toList());
    }

    public ContatoDTO listByIdContato(Integer idContato) throws Exception {
    	Optional<ContatoEntity> byId = contatoRepository.findById(idContato);
    	if(byId.isEmpty())throw new RegraDeNegocioException("Esse id de Contato não existe");
    	ContatoDTO contato = objectMapper.convertValue(byId.get(), ContatoDTO.class);
    	contato.setTipoContato(byId.get().getTipoContato().getTipo());
    	return contato;
    }
}
