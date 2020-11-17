package br.com.sascar.poc.tireid.resources;

import br.com.sascar.poc.tireid.domain.Veiculo;
import br.com.sascar.poc.tireid.dtos.RestResponseDTO;
import br.com.sascar.poc.tireid.dtos.VeiculoDTO;
import br.com.sascar.poc.tireid.services.VeiculoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe de resource com os End-points para Veículo
 *
 * @author luciano.fernandes
 */
@Api(value = "VeiculoResource", tags = {"Veículo"})
@RestController
@RequestMapping(value = "/poc-tireid/veiculo")
public class VeiculoResource extends SystemResource{

    private final VeiculoService veiculoService;
    private final ModelMapper mapper;

    @Autowired
    public VeiculoResource(VeiculoService veiculoService, ModelMapper mapper) {
        this.veiculoService = veiculoService;
        this.mapper = mapper;
    }

    /**
     * Retorna uma lista com todos os Veículos cadastrados
     */
    @ApiOperation(
            value = "Retorna uma lista com todos os Veículos cadastrados.",
            notes = "Retorna uma lista com todos os Veículos cadastrados.",
            tags = {"buscar, veículos"})
    @GetMapping()
    public ResponseEntity<RestResponseDTO<List<Veiculo>>> buscarTodos(){
        List<Veiculo> listaVeiculo = veiculoService.buscarTodos();
        return retornarSucesso(listaVeiculo);
    }

    /**
     * Retorna um Veículo a partir do Id
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Retorna um Veículo a partir do Id.",
            notes = "Retorna um Veículo a partir do Id.",
            tags = {"buscar, veículo, Id"})
    @GetMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Veiculo>> buscarVeiculo(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.buscarPorId(id);
        return retornarSucesso(veiculo);
    }

    /**
     * Retorna um Veiculo a partir da Placa do Veículo
     *
     * @param placa placa do veículo
     */
    @ApiOperation(
            value = "Retorna um Veículo a partir da Placa.",
            notes = "Retorna um Veículo a partir da Placa.",
            tags = {"buscar, veículo, placa"})
    @GetMapping("/placa/{placa}")
    public ResponseEntity<RestResponseDTO<Veiculo>> buscarVeiculoPorPlaca(@PathVariable String placa) {
        Veiculo veiculo = veiculoService.buscarPorPlaca(placa);
        return retornarSucesso(veiculo);
    }

    /**
     * Salva um novo Veículo na base de dados
     *
     * @param veiculoDto objeto dto
     */
    @ApiOperation(
            value = "Salva um novo Veículo na base de dados.",
            notes = "Salva um novo Veículo na base de dados.",
            tags = {"salvar, veículo"})
    @PostMapping
    public ResponseEntity<RestResponseDTO<Veiculo>> cadastrarNovoVeiculo(@RequestBody @Valid VeiculoDTO veiculoDto){
        Veiculo veiculoSalvo = veiculoService.salvarVeiculo(mapper.map(veiculoDto, Veiculo.class));
        return retornarSucesso(veiculoSalvo);
    }

    /**
     * Atualiza um Veículo cadastrado
     *
     * @param veiculoDto objeto dto
     * @param id identificador
     */
    @ApiOperation(
            value = "Atualiza um Veículo cadastrado.",
            notes = "Atualiza um Veículo cadastrado.",
            tags = {"atualizar, veículo"})
    @PutMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Veiculo>> atualizarVeiculo(@RequestBody @Valid VeiculoDTO veiculoDto, @PathVariable Integer id){
        Veiculo veiculoAtualizado = veiculoService.atualizarVeiculo(id, mapper.map(veiculoDto, Veiculo.class));
        return retornarSucesso(veiculoAtualizado);
    }

    /**
     * Apaga um objeto Veículo cadastrado
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Apaga um objeto Veículo cadastrado.",
            notes = "Apaga um objeto Veículo cadastrado.",
            tags = {"deletar, veículo"})
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponseDTO<String>> deletarVeiculo(@PathVariable Integer id){
        veiculoService.deletar(id);
        return retornarSucesso("Veículo deletado com sucesso!");
    }
}
