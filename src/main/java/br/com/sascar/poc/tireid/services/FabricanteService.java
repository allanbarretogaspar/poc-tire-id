package br.com.sascar.poc.tireid.services;

import br.com.sascar.poc.tireid.domain.Fabricante;

import java.util.List;

public interface FabricanteService {
    List<Fabricante> buscarTodos();
    Fabricante buscarPorId(Integer id);
}
