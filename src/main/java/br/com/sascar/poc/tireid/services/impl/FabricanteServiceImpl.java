package br.com.sascar.poc.tireid.services.impl;

import br.com.sascar.poc.tireid.domain.Fabricante;
import br.com.sascar.poc.tireid.exceptions.RecursoNaoEncontradoException;
import br.com.sascar.poc.tireid.repository.FabricanteRepository;
import br.com.sascar.poc.tireid.services.FabricanteService;
import br.com.sascar.poc.tireid.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class FabricanteServiceImpl implements FabricanteService {

    private final FabricanteRepository fabricanteRepository;

    @Value("${fabricante.nao.encontrado}")
    private String msgErroFabricanteInexixtente;

    @Autowired
    public FabricanteServiceImpl(FabricanteRepository fabricanteRepository) {
        this.fabricanteRepository = fabricanteRepository;
    }


    @Override
    public List<Fabricante> buscarTodos() {
        return CollectionUtils.getListFromIterable(fabricanteRepository.findAll());
    }

    @Override
    public Fabricante buscarPorId(Integer id) {
        return fabricanteRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroFabricanteInexixtente));
    }

}
