package com.dbc.pessoaapi.dto;

import lombok.Data;

@Data
public class ContatoCreateDTO {
	
    private Integer idPessoa;
    private Integer tipoContato;
    private String numero;
    private String descricao;
}
