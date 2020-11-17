package br.com.sascar.poc.tireid.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sascar.poc.tireid.domain.Usuario;
import br.com.sascar.poc.tireid.domain.enums.Perfil;
import br.com.sascar.poc.tireid.repository.UsuarioRepository;
import br.com.sascar.poc.tireid.security.UserSS;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UsuarioRepository usuarioRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = this.usuarioRepository.findByLogin(username).orElse(null);
		
		if(usuario == null) {
			
			throw new UsernameNotFoundException(username);
		}
		Set<Perfil>perfis = new HashSet<>();
		perfis.add(Perfil.ADMIN);
		
		return new UserSS(usuario.getId(), usuario.getLogin(), usuario.getSenha(), perfis);
	}

}
