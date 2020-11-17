package br.com.sascar.poc.tireid.resources;

import br.com.sascar.poc.tireid.domain.Armazem;
import br.com.sascar.poc.tireid.dtos.ArmazemDTO;
import br.com.sascar.poc.tireid.dtos.RestResponseDTO;
import br.com.sascar.poc.tireid.services.ArmazemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe de resource com os End-points para Armazem
 *
 * @author luciano.fernandes
 */
@Api(value = "ArmazemResource", tags = {"Armazém"})
@RestController
@RequestMapping(value = "/poc-tireid/armazem")
public class ArmazemResource extends SystemResource{

    private final ArmazemService armazemService;
    private final ModelMapper mapper;

    @Autowired
    public ArmazemResource(ArmazemService armazemService, ModelMapper mapper) {
        this.armazemService = armazemService;
        this.mapper = mapper;
    }

    /**
     * Retorna uma lista com todos os Armazens Lógicos cadastrados
     */
    @ApiOperation(
            value = "Retorna uma lista com todos os Armazens Lógicos cadastrados.",
            notes = "Retorna uma lista com todos os Armazens Lógicos cadastrados.",
            tags = {"buscar, armazens"})
    @GetMapping()
    public ResponseEntity<RestResponseDTO<List<Armazem>>> buscarTodos(){
        List<Armazem> listaArmazem = armazemService.buscarTodos();
        return retornarSucesso(listaArmazem);
    }

    /**
     * Retorna um Armazem a partir do Id
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Retorna um Armazem a partir do Id.",
            notes = "Retorna um Armazem a partir do Id.",
            tags = {"buscar, armazem, id"})
    @GetMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Armazem>> buscarArmazem(@PathVariable Integer id) {
        Armazem armazem = armazemService.buscarPorId(id);
        return retornarSucesso(armazem);
    }

    /**
     * Retorna um Armazem a partir do Nome do Armazem
     *
     * @param nomeArmazem nome do armazem
     */
    @ApiOperation(
            value = "Retorna um Armazem a partir do nome.",
            notes = "Retorna um Armazem a partir do nome.",
            tags = {"buscar, armazem, nome"})
    @GetMapping("/nome/{nomeArmazem}")
    public ResponseEntity<RestResponseDTO<Armazem>> buscarArmazemPorNome(@PathVariable String nomeArmazem) {
        Armazem armazem = armazemService.buscarPorNome(nomeArmazem);
        return retornarSucesso(armazem);
    }

    /**
     * Salva um novo Armazem na base de dados
     *
     * @param armazemDto objeto dto
     */
    @ApiOperation(
            value = "Salva um novo Armazem na base de dados.",
            notes = "Salva um novo Armazem na base de dados.",
            tags = {"salvar, armazem"})
    @PostMapping
    public ResponseEntity<RestResponseDTO<Armazem>> cadastrarNovoArmazem(@RequestBody @Valid ArmazemDTO armazemDto){
        Armazem armazemCadastrado = armazemService.salvarArmazem(mapper.map(armazemDto, Armazem.class));
        return retornarSucesso(armazemCadastrado);
    }

    /**
     * Atualiza um Armazem cadastrado
     *
     * @param armazemDto objeto dto
     * @param id identificador
     */
    @ApiOperation(
            value = "Atualiza um Armazem cadastrado.",
            notes = "Atualiza um Armazem cadastrado.",
            tags = {"atualizar, armazem"})
    @PutMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Armazem>> atualizarArmazem(@RequestBody @Valid ArmazemDTO armazemDto, @PathVariable Integer id){
        Armazem armazemAtualizado = armazemService.atualizarArmazem(id, mapper.map(armazemDto, Armazem.class));
        return retornarSucesso(armazemAtualizado);
    }

    /**
     * Apaga um objeto Armazem cadastrado
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Apaga um objeto Armazem cadastrado.",
            notes = "Apaga um objeto Armazem cadastrado.",
            tags = {"deletar, armazem"})
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponseDTO<String>> deletarArmazem(@PathVariable Integer id){
        armazemService.deletar(id);
        return retornarSucesso("Armazem deletado com sucesso!");
    }
}
