package com.dbc.pessoaapi.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.dbc.pessoaapi.validation.ValidPassword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {
	
	@NotEmpty
	private String login;
	@ValidPassword
	private String password;
	@NotEmpty
	private List<String> grupos;
}
