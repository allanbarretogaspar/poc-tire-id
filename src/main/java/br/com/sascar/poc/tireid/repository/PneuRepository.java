package br.com.sascar.poc.tireid.repository;

import br.com.sascar.poc.tireid.domain.Pneu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PneuRepository extends JpaRepository<Pneu, Integer> {

    // Busca lista de Pneus de um determinado Armazem
    @Query(value = "SELECT DISTINCT p.pneu_id, p.fabricante_id FROM pneu AS p "
            + "INNER JOIN fabricante AS f "
            + "ON f.fabricante_id = p.fabricante_id "
            + "WHERE f.nome = :nomeArmazem", nativeQuery = true)
    List<Pneu> findAllByNomeArmazem(@Param("nomeArmazem") String nomeArmazem);

    // Busca lista de Pneus de um determinado Veículo
    @Query(value = "SELECT DISTINCT p.pneu_id, p.veiculo_id FROM pneu AS p "
            + "INNER JOIN veiculo AS v "
            + "ON v.veiculo_id = p.veiculo_id "
            + "WHERE v.placa = :placa", nativeQuery = true)
    List<Pneu> findAllByPlaca(@Param("placa") String placa);

}
