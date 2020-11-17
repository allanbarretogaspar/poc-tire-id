package br.com.sascar.poc.tireid.repository;

import br.com.sascar.poc.tireid.domain.Fabricante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Integer> {

}
