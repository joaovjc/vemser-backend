package com.dbc.pessoaapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
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

//    public List<PessoaDTO> listByName(String nome) {
//        return pessoaRepository.listByName(nome).stream()
//                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
//                .collect(Collectors.toList());
//    }
}
