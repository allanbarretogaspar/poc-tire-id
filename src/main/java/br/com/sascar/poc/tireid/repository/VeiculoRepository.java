package br.com.sascar.poc.tireid.repository;

import br.com.sascar.poc.tireid.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {
    Optional<Veiculo> findByPlaca(String placa);
}
