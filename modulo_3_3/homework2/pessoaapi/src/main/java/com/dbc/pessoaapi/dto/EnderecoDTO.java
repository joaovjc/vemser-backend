package com.dbc.pessoaapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EnderecoDTO extends EnderecoCreateDTO {

	private Integer idEndereco;

}
