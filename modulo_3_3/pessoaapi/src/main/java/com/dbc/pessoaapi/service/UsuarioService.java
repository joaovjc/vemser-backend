package com.dbc.pessoaapi.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dbc.pessoaapi.dto.UserCreateDTO;
import com.dbc.pessoaapi.dto.UserDTO;
import com.dbc.pessoaapi.entity.GrupoEntity;
import com.dbc.pessoaapi.entity.UsuarioEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final GrupoService grupoService;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

	public UserDTO AdicionarUser(UserCreateDTO user) throws RegraDeNegocioException {
		
		if(usuarioRepository.findByLogin(user.getLogin()).isPresent()) throw new RegraDeNegocioException("esse login já existe!");
		Set<GrupoEntity> grupos = new HashSet<>();
		for (String grupo : user.getGrupos()) {
			GrupoEntity achraPorNome = grupoService.achraPorNome(grupo);
			grupos.add(achraPorNome);
		}
		
		UsuarioEntity userConvertido = new UsuarioEntity();
		
		userConvertido.setLogin(user.getLogin());
		userConvertido.setSenha(new BCryptPasswordEncoder().encode(user.getPassword()));
		userConvertido.setGrupos(grupos);
		
		UsuarioEntity userAtualizado = usuarioRepository.save(userConvertido);

		UserDTO userDTO = new UserDTO(userAtualizado.getIdUsuario(), userAtualizado.getUsername(), user.getGrupos());
		
		return userDTO;
	}
}