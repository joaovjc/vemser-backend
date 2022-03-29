package com.dbc.pessoaapi.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PessoaDTOComEnderecosEContatos extends PessoaDTOComContatos{
	
	List<EnderecoDTO> enderecos;
}
