package br.com.sascar.poc.tireid.services.impl;

import br.com.sascar.poc.tireid.domain.Armazem;
import br.com.sascar.poc.tireid.domain.Pneu;
import br.com.sascar.poc.tireid.exceptions.BusinessException;
import br.com.sascar.poc.tireid.exceptions.RecursoNaoEncontradoException;
import br.com.sascar.poc.tireid.repository.ArmazemRepository;
import br.com.sascar.poc.tireid.repository.PneuRepository;
import br.com.sascar.poc.tireid.services.ArmazemService;
import br.com.sascar.poc.tireid.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class ArmazemServiceImpl implements ArmazemService {

    private final ArmazemRepository armazemRepository;
    private final PneuRepository pneuRepository;

    @Value("${armazem.nao.encontrado}")
    private String msgErroArmazemInexistente;

    @Value("${armazem.deletar.com.pneus}")
    private String msgErroDeletarComPneus;

    @Autowired
    public ArmazemServiceImpl(ArmazemRepository armazemRepository, PneuRepository pneuRepository) {
        this.armazemRepository = armazemRepository;
        this.pneuRepository = pneuRepository;
    }

    @Override
    public Armazem buscarPorId(Integer id) {
        return armazemRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroArmazemInexistente));
    }

    @Override
    public List<Armazem> buscarTodos() {
        return CollectionUtils.getListFromIterable(armazemRepository.findAll());
    }

    @Override
    public Armazem salvarArmazem(Armazem armazem) {
        return armazemRepository.save(armazem);
    }

    @Override
    public Armazem atualizarArmazem(Integer id, Armazem armazem) {
        Armazem armazemEncontrado = buscarPorId(id);
        armazemEncontrado.setNome(armazem.getNome());
        armazemEncontrado.setObservacoes(armazem.getObservacoes());
        return armazemRepository.save(armazemEncontrado);
    }

    @Override
    public Armazem buscarPorNome(String nomeArmazem) {
        return armazemRepository.findByNome(nomeArmazem)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroArmazemInexistente));
    }

    @Override
    public Boolean deletar(Integer id) {
        Armazem armazemEncontrado = buscarPorId(id);
        List<Pneu> pneusDoArmazem = pneuRepository.findAllByNomeArmazem(armazemEncontrado.getNome());
        if(pneusDoArmazem.isEmpty()){
            armazemRepository.delete(armazemEncontrado);
        } else {
            throw new BusinessException(msgErroDeletarComPneus);
        }
        return true;
    }
}
