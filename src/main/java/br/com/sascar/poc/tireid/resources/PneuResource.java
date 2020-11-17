package br.com.sascar.poc.tireid.resources;

import br.com.sascar.poc.tireid.domain.Pneu;
import br.com.sascar.poc.tireid.dtos.PneuDTO;
import br.com.sascar.poc.tireid.dtos.RestResponseDTO;
import br.com.sascar.poc.tireid.services.PneuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Classe de resource com os End-points para Pneu
 *
 * @author luciano.fernandes
 */
@Api(value = "PneuResource", tags = {"Pneu"})
@RestController
@RequestMapping(value = "/poc-tireid/pneu")
public class PneuResource extends SystemResource{

    private final PneuService pneuService;


    @Autowired
    public PneuResource(PneuService pneuService) {
        this.pneuService = pneuService;
    }

    /**
     * Retorna uma lista com todos os Pneus cadastrados
     */
    @ApiOperation(
            value = "Retorna uma lista com todos os Pneus cadastrados.",
            notes = "Retorna uma lista com todos os Pneus cadastrados.",
            tags = {"buscar, pneus"})
    @GetMapping()
    public ResponseEntity<RestResponseDTO<List<Pneu>>> buscarTodos(){
        List<Pneu> listaPneu = pneuService.buscarTodos();
        return retornarSucesso(listaPneu);
    }

    /**
     * Retorna um Pneu a partir do Id
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Retorna um Pneu a partir do Id.",
            notes = "Retorna um Pneu a partir do Id.",
            tags = {"buscar, pneu, id"})
    @GetMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Pneu>> buscarPneu(@PathVariable Integer id) {
        Pneu pneu = pneuService.buscarPorId(id);
        return retornarSucesso(pneu);
    }

    /**
     * Salva um novo Pneu na base de dados
     *
     * @param pneuDto objeto dto
     */
    @ApiOperation(
            value = "Salva um novo Pneu na base de dados.",
            notes = "Salva um novo Pneu na base de dados.",
            tags = {"salvar, pneu"})
    @PostMapping
    public ResponseEntity<RestResponseDTO<Pneu>> cadastrarNovoPneu(@RequestBody @Valid PneuDTO pneuDto){
        Pneu pneuSalvo = pneuService.salvarPneu(pneuDto);
        return retornarSucesso(pneuSalvo);
    }

    /**
     * Atualiza um Pneu cadastrado
     *
     * @param pneuDto objeto dto
     * @param id identificador
     */
    @ApiOperation(
            value = "Atualiza um Pneu cadastrado.",
            notes = "Atualiza um Pneu cadastrado.",
            tags = {"atualizar, pneu"})
    @PutMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Pneu>> atualizarVeiculo(@RequestBody @Valid PneuDTO pneuDto, @PathVariable Integer id){
        Pneu pneuAtualizado = pneuService.atualizarPneu(id, pneuDto);
        return retornarSucesso(pneuAtualizado);
    }



    /**
     * Apaga um objeto Pneu cadastrado
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Apaga um objeto Pneu cadastrado.",
            notes = "Apaga um objeto Pneu cadastrado.",
            tags = {"deletar, pneu"})
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponseDTO<String>> deletarPneu(@PathVariable Integer id){
        pneuService.deletar(id);
        return retornarSucesso("Pneu deletado com sucesso!");
    }
}
