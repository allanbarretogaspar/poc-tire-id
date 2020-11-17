package br.com.sascar.poc.tireid.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sascar.poc.tireid.domain.Usuario;
import br.com.sascar.poc.tireid.repository.UsuarioRepository;
import br.com.sascar.poc.tireid.services.UsuarioService;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Usuario buscarPorId(Integer id) {
		
		return this.usuarioRepository.getOne(id);
	}

	@Override
	public List<Usuario> buscarTodos() {
		
		return this.usuarioRepository.findAll();
	}

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		
		usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario atualizarUsuario(Integer id, Usuario usuario) {
		Usuario usuarioEncontrado = buscarPorId(id);
		usuarioEncontrado.setAtivo(usuario.isAtivo());
		usuarioEncontrado.setEmail(usuario.getEmail());
		usuarioEncontrado.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
		return this.usuarioRepository.save(usuarioEncontrado);
	}

	@Override
	public Usuario buscarPorNome(String nomeUsuario) {
		
		return this.buscarPorNome(nomeUsuario);
	}

	@Override
	public void deletar(Integer id) {
		
		 this.usuarioRepository.deleteById(id);
	}
    
    
}
