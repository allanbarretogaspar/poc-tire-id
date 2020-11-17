package br.com.sascar.poc.tireid.repository;

import br.com.sascar.poc.tireid.domain.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArmazemRepository extends JpaRepository<Armazem, Integer> {
    Optional<Armazem> findByNome(String nome);
}
