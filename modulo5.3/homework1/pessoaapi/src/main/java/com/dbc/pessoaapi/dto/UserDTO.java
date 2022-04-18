package com.dbc.pessoaapi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO{
	
	private Integer id;
	private String login;
	private List<String> grupos;
}
