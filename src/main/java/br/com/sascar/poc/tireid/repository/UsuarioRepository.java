package br.com.sascar.poc.tireid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sascar.poc.tireid.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String login);
    Optional<Usuario> findByNome(String nome);
}
