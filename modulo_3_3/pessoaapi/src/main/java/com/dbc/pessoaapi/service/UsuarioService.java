package com.dbc.pessoaapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }
}