package br.com.sascar.poc.tireid.services;

import br.com.sascar.poc.tireid.domain.Armazem;

import java.util.List;

public interface ArmazemService {
    Armazem buscarPorId(Integer id);
    List<Armazem> buscarTodos();
    Armazem salvarArmazem(Armazem armazem);
    Armazem atualizarArmazem(Integer id, Armazem armazem);
    Armazem buscarPorNome(String nomeArmazem);
    Boolean deletar(Integer id);
}
