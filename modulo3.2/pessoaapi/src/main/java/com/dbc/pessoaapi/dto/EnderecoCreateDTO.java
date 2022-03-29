package com.dbc.pessoaapi.dto;

import lombok.Data;

@Data
public class EnderecoCreateDTO {
	
    private Integer tipo;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

}
