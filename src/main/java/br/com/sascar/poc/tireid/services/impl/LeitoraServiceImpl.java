package br.com.sascar.poc.tireid.services.impl;

import br.com.sascar.poc.tireid.domain.Leitora;
import br.com.sascar.poc.tireid.exceptions.RecursoNaoEncontradoException;
import br.com.sascar.poc.tireid.repository.LeitoraRepository;
import br.com.sascar.poc.tireid.services.LeitoraService;
import br.com.sascar.poc.tireid.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class LeitoraServiceImpl implements LeitoraService {

    private final LeitoraRepository leitoraRepository;

    @Value("${leitora.nao.encontrado}")
    private String msgErroLeitoraInexistente;

    @Autowired
    public LeitoraServiceImpl(LeitoraRepository leitoraRepository) {
        this.leitoraRepository = leitoraRepository;
    }

    @Override
    public Leitora buscarPorId(Integer id) {
        return leitoraRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroLeitoraInexistente));
    }

    @Override
    public List<Leitora> buscarTodos() {
        return CollectionUtils.getListFromIterable(leitoraRepository.findAll());
    }

    @Override
    public Leitora salvarLeitora(Leitora leitora) {
        return leitoraRepository.save(leitora);
    }

    @Override
    public Leitora atualizarLeitora(Integer id, Leitora leitora) {
        Leitora leitoraEncontrada = buscarPorId(id);
        leitoraEncontrada.setNome(leitora.getNome());
        leitoraEncontrada.setEndereco(leitora.getEndereco());
        leitoraEncontrada.setCategoria(leitora.getCategoria());
        return leitoraRepository.save(leitoraEncontrada);
    }

    @Override
    public Leitora buscarPorNome(String nomeLeitora) {
        return leitoraRepository.findByNome(nomeLeitora)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroLeitoraInexistente));
    }

    @Override
    public Boolean deletar(Integer id) {
        Leitora leitoraEncontrada = buscarPorId(id);
        leitoraRepository.delete(leitoraEncontrada);
        return true;
    }
}
