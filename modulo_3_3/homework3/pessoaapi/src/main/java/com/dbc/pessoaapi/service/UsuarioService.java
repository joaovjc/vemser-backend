package com.dbc.pessoaapi.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.dto.UserCreateDTO;
import com.dbc.pessoaapi.dto.UserDTO;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

	public UserDTO AdicionarUser(UserCreateDTO user) throws RegraDeNegocioException {
		
		UsuarioEntity userConvertido = new UsuarioEntity();
		
		if(usuarioRepository.findByLogin(user.getLogin()).isPresent()) throw new RegraDeNegocioException("esse login já existe!");
		userConvertido.setLogin(user.getLogin());
		userConvertido.setSenha(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		UsuarioEntity userAtualizado = usuarioRepository.save(userConvertido);
		
		UserDTO userDTO = new UserDTO(userAtualizado.getIdUsuario(), userAtualizado.getUsername());
		
		return userDTO;
	}
}