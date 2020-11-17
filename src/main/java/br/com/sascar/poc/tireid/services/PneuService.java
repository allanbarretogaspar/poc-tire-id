package br.com.sascar.poc.tireid.services;

import br.com.sascar.poc.tireid.domain.Pneu;
import br.com.sascar.poc.tireid.dtos.PneuDTO;

import java.util.List;

public interface PneuService {
    Pneu buscarPorId(Integer id);
    List<Pneu> buscarTodos();
    Pneu salvarPneu(PneuDTO pneuDto);
    Pneu atualizarPneu(Integer id, PneuDTO pneuDTO);
    Boolean deletar(Integer id);
}
