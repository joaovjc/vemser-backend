package com.dbc.pessoaapi.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ContatoDTO extends ContatoCreateDTO{
	
    private Integer idContato;

}
