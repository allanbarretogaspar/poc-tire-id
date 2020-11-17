package br.com.sascar.poc.tireid.services.impl;

import br.com.sascar.poc.tireid.domain.Pneu;
import br.com.sascar.poc.tireid.dtos.PneuDTO;
import br.com.sascar.poc.tireid.exceptions.RecursoNaoEncontradoException;
import br.com.sascar.poc.tireid.repository.PneuRepository;
import br.com.sascar.poc.tireid.services.ArmazemService;
import br.com.sascar.poc.tireid.services.FabricanteService;
import br.com.sascar.poc.tireid.services.PneuService;
import br.com.sascar.poc.tireid.services.VeiculoService;
import br.com.sascar.poc.tireid.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class PneuServiceImpl implements PneuService {

    private final PneuRepository pneuRepository;
    private final FabricanteService fabricanteService;
    private final VeiculoService veiculoService;
    private final ArmazemService armazemService;

    @Value("${pneu.nao.encontrado}")
    private String msgErroPneuInexistente;

    @Autowired
    public PneuServiceImpl(PneuRepository pneuRepository, FabricanteService fabricanteService, VeiculoService veiculoService, ArmazemService armazemService) {
        this.pneuRepository = pneuRepository;
        this.fabricanteService = fabricanteService;
        this.veiculoService = veiculoService;
        this.armazemService = armazemService;
    }

    @Override
    public Pneu buscarPorId(Integer id) {
        return pneuRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroPneuInexistente));
    }

    @Override
    public List<Pneu> buscarTodos() {
        return CollectionUtils.getListFromIterable(pneuRepository.findAll());
    }

    @Override
    public Pneu salvarPneu(PneuDTO pneuDto) {
        Pneu pneu = new Pneu();
        return pneuRepository.save(mapDtoToObject(pneuDto, pneu));
    }

    @Override
    public Pneu atualizarPneu(Integer id, PneuDTO pneuDTO) {
        Pneu pneu = buscarPorId(id);
        return pneuRepository.save(mapDtoToObject(pneuDTO, pneu));
    }

    private Pneu mapDtoToObject(PneuDTO pneuDTO, Pneu pneu){
        pneu.setFabricante(fabricanteService.buscarPorId(pneuDTO.getFabricanteId()));
        pneu.setModelo(pneuDTO.getModelo());
        pneu.setDimensoes(pneuDTO.getDimensoes());
        pneu.setNumeroSerie(pneuDTO.getNumeroSerie());
        pneu.setDataFabricacao(pneuDTO.getDataFabricacao());
        pneu.setNotaFiscal(pneuDTO.getNotaFiscal());
        pneu.setDataCompra(pneuDTO.getDataCompra());
        pneu.setPneuRfid(pneuDTO.getPneuRfid());
        pneu.setMarcaFogo(pneuDTO.getMarcaFogo());
        if(pneuDTO.getVeiculoId()!= null){
            pneu.setVeiculo(veiculoService.buscarPorId(pneuDTO.getVeiculoId()));
        } else {
            pneu.setVeiculo(null);
        }
        if(pneuDTO.getArmazemId()!= null){
            pneu.setArmazem(armazemService.buscarPorId(pneuDTO.getArmazemId()));
        } else {
            pneu.setArmazem(null);
        }
        pneu.setPosicaoMontagem(pneuDTO.getPosicaoMontagem());
        return pneu;
    }


    @Override
    public Boolean deletar(Integer id) {
        Pneu pneuEncontrado = buscarPorId(id);
        pneuRepository.delete(pneuEncontrado);
        return true;
    }
}
