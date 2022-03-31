package com.dbc.pessoaapi.controller;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbc.pessoaapi.dto.UserCreateDTO;
import com.dbc.pessoaapi.dto.UserDTO;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UsuarioService userService;

    @PostMapping
	public UserDTO AdicionarUser(@Valid @RequestBody UserCreateDTO user) throws RegraDeNegocioException{
		return userService.AdicionarUser(user);
	}

}