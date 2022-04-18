package com.dbc.pessoaapi.dto;

import org.junit.jupiter.api.Test;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.fasterxml.jackson.databind.ObjectMapper;

class ContatoDTOTest {
    @Test
    void test(){

        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setTipoContato(2);

        @SuppressWarnings("unused")
		ContatoEntity contato1 = new ObjectMapper().convertValue(contatoDTO, ContatoEntity.class);



        ContatoEntity contato = new ContatoEntity();
        contato.setTipoContato(TipoContato.COMERCIAL);
    }
}