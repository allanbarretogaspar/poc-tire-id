package br.com.sascar.poc.tireid.services;

import br.com.sascar.poc.tireid.domain.Veiculo;

import java.util.List;

public interface VeiculoService {
    Veiculo buscarPorId(Integer id);
    List<Veiculo> buscarTodos();
    Veiculo salvarVeiculo(Veiculo veiculo);
    Veiculo atualizarVeiculo(Integer id, Veiculo veiculo);
    Veiculo buscarPorPlaca(String placa);
    Boolean deletar(Integer id);
}
