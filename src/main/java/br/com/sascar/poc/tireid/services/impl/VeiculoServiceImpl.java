package br.com.sascar.poc.tireid.services.impl;

import br.com.sascar.poc.tireid.domain.Pneu;
import br.com.sascar.poc.tireid.domain.Veiculo;
import br.com.sascar.poc.tireid.exceptions.BusinessException;
import br.com.sascar.poc.tireid.exceptions.RecursoNaoEncontradoException;
import br.com.sascar.poc.tireid.repository.PneuRepository;
import br.com.sascar.poc.tireid.repository.VeiculoRepository;
import br.com.sascar.poc.tireid.services.VeiculoService;
import br.com.sascar.poc.tireid.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;

@PropertySource("classpath:ValidationMessages.properties")
@Service
public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final PneuRepository pneuRepository;

    @Value("${veiculo.nao.encontrado}")
    private String msgErroVeiculoInexistente;

    @Value("${veiculo.deletar.com.pneus}")
    private String msgErroDeletarComPneus;

    @Autowired
    public VeiculoServiceImpl(VeiculoRepository veiculoRepository, PneuRepository pneuRepository) {
        this.veiculoRepository = veiculoRepository;
        this.pneuRepository = pneuRepository;
    }

    @Override
    public Veiculo buscarPorId(Integer id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroVeiculoInexistente));
    }

    @Override
    public List<Veiculo> buscarTodos() {
        return CollectionUtils.getListFromIterable(veiculoRepository.findAll());
    }

    @Override
    public Veiculo salvarVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo atualizarVeiculo(Integer id, Veiculo veiculo) {
        Veiculo veiculoEncontrado = buscarPorId(id);
        veiculoEncontrado.setModelo(veiculo.getModelo());
        veiculoEncontrado.setPlaca(veiculo.getPlaca());
        veiculoEncontrado.setNumeroFrota(veiculo.getNumeroFrota());
        veiculoEncontrado.setNumeroPneus(veiculo.getNumeroPneus());
        veiculoEncontrado.setVeiculoRfid(veiculo.getVeiculoRfid());
        veiculoEncontrado.setNumeroEixos(veiculo.getNumeroEixos());
        veiculoEncontrado.setPneusGeminados(veiculo.getPneusGeminados());
        veiculoEncontrado.setNumeroSteps(veiculo.getNumeroSteps());
        return veiculoRepository.save(veiculoEncontrado);
    }

    @Override
    public Veiculo buscarPorPlaca(String placa) {
        return veiculoRepository.findByPlaca(placa)
                .orElseThrow(() -> new RecursoNaoEncontradoException(msgErroVeiculoInexistente));
    }

    @Override
    public Boolean deletar(Integer id) {
        Veiculo veiculoEncontrado = buscarPorId(id);
        List<Pneu> pneusDoVeiculo = pneuRepository.findAllByPlaca(veiculoEncontrado.getPlaca());
        if(pneusDoVeiculo.isEmpty()){
            veiculoRepository.delete(veiculoEncontrado);
        } else {
            throw new BusinessException(msgErroDeletarComPneus);
        }
        return true;
    }
}
