package com.dbc.pessoaapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.dto.PessoaDTOComContatos;
import com.dbc.pessoaapi.dto.PessoaDTOComEnderecos;
import com.dbc.pessoaapi.dto.PessoaDTOComEnderecosEContatos;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
//    	PessoaEntity pessoaEntity = new PessoaEntity();
//    	pessoaEntity.setCpf(null);
//    	pessoaEntity.setDataNascimento(null);
//    	pessoaEntity.setEmail(null);
//    	pessoaEntity.setNome(null);
        pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = new PessoaDTO();
        return pessoaDTO;
    }
    
    public List<PessoaDTOComContatos> listComContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComContatos> pessoaDTOList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTOComContatos.class);
                        pessoaDTO.setContatos(pessoa.getContatos().stream()
                        		.map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                        		.toList()
                        );

                        return pessoaDTO;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComContatos.class);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            );
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }
    
    public List<PessoaDTOComEnderecos> listComEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComEnderecos> pessoaDTOList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecos enderecoDTO = objectMapper.convertValue(pessoa, PessoaDTOComEnderecos.class);
                        enderecoDTO.setEnderecos(pessoa.getEnderecos().stream()
                        		.map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                        		.toList()
                        );

                        return enderecoDTO;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComEnderecos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecos.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
            		.map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
            		.toList()
            );
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }
    
    public List<PessoaDTOComEnderecosEContatos> listComEnderecosEContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaDTOComEnderecosEContatos> pessoaDTOList = new ArrayList<>();
        if(idPessoa == null){
            pessoaDTOList.addAll(pessoaRepository.findAll().stream()
                    .map(pessoa -> {
                        PessoaDTOComEnderecosEContatos enderecoDTO = objectMapper.convertValue(pessoa, PessoaDTOComEnderecosEContatos.class);
                        enderecoDTO.setEnderecos(pessoa.getEnderecos().stream()
                        		.map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                        		.toList()
                        		);
                        enderecoDTO.setContatos(pessoa.getContatos().stream()
                                   .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                                   .collect(Collectors.toList())
                        		);

                        return enderecoDTO;
                    }).collect(Collectors.toList())
            );
        } else {
            PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa)
                    .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
            PessoaDTOComEnderecosEContatos pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTOComEnderecosEContatos.class);
            pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
            		.map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
            		.toList()
            		);
            pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                    .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                    .collect(Collectors.toList())
            		);
            pessoaDTOList.add(pessoaDTO);
        }
        return pessoaDTOList;
    }
    
    public List<PessoaDTO> listPor(String nome, String cpf, Date inicio, Date fim) throws RegraDeNegocioException{
    	List<PessoaDTO> dtos = new ArrayList<>();
    	
    	if(nome!=null) {
    		dtos.addAll(pessoaRepository.findAllByNomeIgnoreCase(nome)
    				.stream()
    				.map(t -> objectMapper.convertValue(t, PessoaDTO.class))
    				.toList()
    				);
    	}else if(cpf!=null) {
    		PessoaEntity pessoa = pessoaRepository.findByCpf(cpf).stream().findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada!"));
    		dtos.add(objectMapper.convertValue(pessoa, PessoaDTO.class));
    	}else if(inicio!=null) {
    		dtos.addAll(pessoaRepository.findAllByDataNascimentoBetween(inicio, fim)
    				.stream()
    				.map(t -> objectMapper.convertValue(t, PessoaDTO.class))
    				.toList()
    				);
    	}else {
    		throw new RegraDeNegocioException("preencha algum dos campos");
    	}
    	
		return dtos;
    }
    
    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream().map(t -> objectMapper.convertValue(t, PessoaDTO.class)).toList();
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizar) throws Exception {
        PessoaEntity pessoa = objectMapper.convertValue(pessoaAtualizar, PessoaEntity.class);
        pessoa.setIdPessoa(id);
        PessoaEntity update = pessoaRepository.save(pessoa);
        PessoaDTO pessoaDTO = objectMapper.convertValue(update, PessoaDTO.class);
        return pessoaDTO;
    }

    public void delete(Integer id) throws Exception {
    	Optional<PessoaEntity> findById = pessoaRepository.findById(id);
        pessoaRepository.delete(findById.get());
    }

    
}
