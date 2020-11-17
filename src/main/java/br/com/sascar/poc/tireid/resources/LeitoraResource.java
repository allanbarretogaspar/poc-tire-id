package br.com.sascar.poc.tireid.resources;

import br.com.sascar.poc.tireid.domain.Leitora;
import br.com.sascar.poc.tireid.dtos.LeitoraDTO;
import br.com.sascar.poc.tireid.dtos.RestResponseDTO;
import br.com.sascar.poc.tireid.services.LeitoraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe de resource com os End-points para Leitora
 *
 * @author luciano.fernandes
 */
@Api(value = "LeitoraResource", tags = {"Leitora"})
@RestController
@RequestMapping(value = "/poc-tireid/leitora")
public class LeitoraResource extends SystemResource{

    private final LeitoraService leitoraService;
    private final ModelMapper mapper;

    @Autowired
    public LeitoraResource(LeitoraService leitoraService, ModelMapper mapper) {
        this.leitoraService = leitoraService;
        this.mapper = mapper;
    }

    /**
     * Retorna uma lista com todas as Leitora cadastradas
     */
    @ApiOperation(
            value = "Retorna uma lista com todas as Leitora cadastradas.",
            notes = "Retorna uma lista com todas as Leitora cadastradas.",
            tags = {"buscar, leitoras"})
    @GetMapping()
    public ResponseEntity<RestResponseDTO<List<Leitora>>> buscarTodos(){
        List<Leitora> listaLeitora = leitoraService.buscarTodos();
        return retornarSucesso(listaLeitora);
    }

    /**
     * Retorna uma Leitora a partir do Id
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Retorna uma Leitora a partir do Id.",
            notes = "Retorna uma Leitora a partir do Id.",
            tags = {"buscar, leitora, id"})
    @GetMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Leitora>> buscarLeitora(@PathVariable Integer id) {
        Leitora leitora = leitoraService.buscarPorId(id);
        return retornarSucesso(leitora);
    }

    /**
     * Retorna uma Leitora a partir do Nome da Leitora
     *
     * @param nomeLeitora nome da leitora
     */
    @ApiOperation(
            value = "Retorna uma Leitora a partir do Nome da Leitora.",
            notes = "Retorna uma Leitora a partir do Nome da Leitora.",
            tags = {"buscar, leitora, nome"})
    @GetMapping("/nome/{nomeLeitora}")
    public ResponseEntity<RestResponseDTO<Leitora>> buscarLeitoraPorNome(@PathVariable String nomeLeitora) {
        Leitora leitora = leitoraService.buscarPorNome(nomeLeitora);
        return retornarSucesso(leitora);
    }

    /**
     * Salva uma nova Leitora na base de dados
     *
     * @param leitoraDto objeto dto
     */
    @ApiOperation(
            value = "Salva uma nova Leitora na base de dados.",
            notes = "Salva uma nova Leitora na base de dados.",
            tags = {"salvar, leitora"})
    @PostMapping
    public ResponseEntity<RestResponseDTO<Leitora>> cadastrarNovaLeitora(@RequestBody @Valid LeitoraDTO leitoraDto){
        Leitora leitoraSalva = leitoraService.salvarLeitora(mapper.map(leitoraDto, Leitora.class));
        return retornarSucesso(leitoraSalva);
    }

    /**
     * Atualiza uma Leitora cadastrada
     *
     * @param leitoraDto objeto dto
     * @param id identificador
     */
    @ApiOperation(
            value = "Atualiza uma Leitora cadastrada.",
            notes = "Atualiza uma Leitora cadastrada.",
            tags = {"atualizar, leitora"})
    @PutMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Leitora>> atualizarLeitora(@RequestBody @Valid LeitoraDTO leitoraDto, @PathVariable Integer id){
        Leitora leitoraAtualizada = leitoraService.atualizarLeitora(id, mapper.map(leitoraDto, Leitora.class));
        return retornarSucesso(leitoraAtualizada);
    }

    /**
     * Apaga um objeto Leitora cadastrado
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Apaga um objeto Leitora cadastrado.",
            notes = "Apaga um objeto Leitora cadastrado.",
            tags = {"deletar, leitora"})
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponseDTO<String>> deletarLeitora(@PathVariable Integer id){
        leitoraService.deletar(id);
        return retornarSucesso("Leitora deletada com sucesso!");
    }
}
