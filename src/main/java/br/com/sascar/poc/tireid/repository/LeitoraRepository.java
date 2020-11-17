package br.com.sascar.poc.tireid.repository;

import br.com.sascar.poc.tireid.domain.Leitora;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeitoraRepository extends JpaRepository<Leitora, Integer> {
    Optional<Leitora> findByNome(String nome);
}
