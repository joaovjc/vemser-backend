package com.dbc.pessoaapi.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PessoaDTOComEnderecos extends PessoaDTO{
	
	List<EnderecoDTO> enderecos;
	
}
