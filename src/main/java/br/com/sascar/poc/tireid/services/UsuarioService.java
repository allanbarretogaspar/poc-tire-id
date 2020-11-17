package br.com.sascar.poc.tireid.services;

import java.util.List;

import br.com.sascar.poc.tireid.domain.Usuario;

public interface UsuarioService {
    Usuario buscarPorId(Integer id);
    List<Usuario> buscarTodos();
    Usuario salvarUsuario(Usuario usuario);
    Usuario atualizarUsuario(Integer id, Usuario usuario);
    Usuario buscarPorNome(String nomeUsuario);
    void deletar(Integer id);
}
