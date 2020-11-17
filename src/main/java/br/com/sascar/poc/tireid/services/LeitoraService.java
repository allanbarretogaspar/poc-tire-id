package br.com.sascar.poc.tireid.services;

import br.com.sascar.poc.tireid.domain.Leitora;

import java.util.List;

public interface LeitoraService {
    Leitora buscarPorId(Integer id);
    List<Leitora> buscarTodos();
    Leitora salvarLeitora(Leitora leitora);
    Leitora atualizarLeitora(Integer id, Leitora leitora);
    Leitora buscarPorNome(String nomeLeitora);
    Boolean deletar(Integer id);
}
