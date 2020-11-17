package br.com.sascar.poc.tireid.resources;

import br.com.sascar.poc.tireid.domain.Fabricante;
import br.com.sascar.poc.tireid.dtos.RestResponseDTO;
import br.com.sascar.poc.tireid.services.FabricanteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Classe de resource com os End-points para Fabricante
 *
 * @author luciano.fernandes
 */
@Api(value = "FabricanteResource", tags = {"Fabricante"})
@RestController
@RequestMapping(value = "/poc-tireid/fabricante")
public class FabricanteResource extends SystemResource{

    private final FabricanteService fabricanteService;

    @Autowired
    public FabricanteResource(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    /**
     * Retorna uma lista com todos os Fabricantes de Pneus cadastrados
     */
    @ApiOperation(
            value = "Retorna uma lista com todos os Fabricantes de Pneus cadastrados.",
            notes = "Retorna uma lista com todos os Fabricantes de Pneus cadastrados.",
            tags = {"buscar, fabricantes"})
    @GetMapping()
    public ResponseEntity<RestResponseDTO<List<Fabricante>>> buscarTodos(){
        List<Fabricante> listaFabricantes = fabricanteService.buscarTodos();
        return retornarSucesso(listaFabricantes);
    }

    /**
     * Retorna um Fabricante a partir do Id
     *
     * @param id
     */
    @ApiOperation(
            value = "Retorna um Fabricante a partir do Id.",
            notes = "Retorna um Fabricante a partir do Id.",
            tags = {"buscar, fabricante, id"})
    @GetMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Fabricante>> buscarFabricante(@PathVariable Integer id) {
        Fabricante fabricante = fabricanteService.buscarPorId(id);
        return retornarSucesso(fabricante);
    }
}
