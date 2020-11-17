package br.com.sascar.poc.tireid.resources;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sascar.poc.tireid.domain.Usuario;
import br.com.sascar.poc.tireid.domain.enums.Perfil;
import br.com.sascar.poc.tireid.dtos.RestResponseDTO;
import br.com.sascar.poc.tireid.dtos.UsuarioDTO;
import br.com.sascar.poc.tireid.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Classe de resource com os End-points para Armazem
 *
 * @author luciano.fernandes
 */
@Api(value = "UsuarioResource", tags = {"Usuário"})
@RestController
@RequestMapping(value = "/poc-tireid/usuario")
public class UsuarioResource extends SystemResource{

    private final UsuarioService usuarioService;
    private final ModelMapper mapper;

    @Autowired
    public UsuarioResource(UsuarioService usuarioService, ModelMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    /**
     * Retorna uma lista com todos os Armazens Lógicos cadastrados
     */
    @ApiOperation(
            value = "Retorna uma lista com todos os Usuários cadastrados.",
            notes = "Retorna uma lista com todos os Usuários cadastrados.",
            tags = {"buscar, usuarios"})
    @GetMapping()
    public ResponseEntity<RestResponseDTO<List<Usuario>>> buscarTodos(){
        List<Usuario> listaUsuario = usuarioService.buscarTodos();
        return retornarSucesso(listaUsuario);
    }

    /**
     * Retorna um Usuario a partir do Id
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Retorna um Usuario a partir do Id.",
            notes = "Retorna um Usuario a partir do Id.",
            tags = {"buscar, usuario, id"})
    @GetMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Usuario>> buscarUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return retornarSucesso(usuario);
    }

    /**
     * Retorna um Armazem a partir do Nome do Armazem
     *
     * @param nomeArmazem nome do armazem
     */
    @ApiOperation(
            value = "Retorna um Usuario a partir do nome.",
            notes = "Retorna um Usuario a partir do nome.",
            tags = {"buscar, usuario, nome"})
    @GetMapping("/nome/{nomeusuario}")
    public ResponseEntity<RestResponseDTO<Usuario>> buscarUsuarioPorNome(@PathVariable String nomeUsuario) {
        Usuario usuario = usuarioService.buscarPorNome(nomeUsuario);
        return retornarSucesso(usuario);
    }

    /**
     * Salva um novo Usuario na base de dados
     *
     * @param armazemDto objeto dto
     */
    @ApiOperation(
            value = "Salva um novo Usuario na base de dados.",
            notes = "Salva um novo Usuario na base de dados.",
            tags = {"salvar, usuario"})
    @PostMapping
    public ResponseEntity<RestResponseDTO<Usuario>> cadastrarNovoUsuario(@RequestBody @Valid UsuarioDTO usuarioDto){
    	Set<Perfil> perfis = new HashSet<Perfil>();
    	perfis.add(Perfil.ADMIN);
    	Usuario usuarioCadastrado = usuarioService.salvarUsuario(mapper.map(usuarioDto, Usuario.class));
        return retornarSucesso(usuarioCadastrado);
    }

    /**
     * Atualiza um Usuario cadastrado
     *
     * @param usuarioDto objeto dto
     * @param id identificador
     */
    @ApiOperation(
            value = "Atualiza um Usuario cadastrado.",
            notes = "Atualiza um Usuario cadastrado.",
            tags = {"atualizar, usuario"})
    @PutMapping("/{id}")
    public ResponseEntity<RestResponseDTO<Usuario>> atualizarUsuario(@RequestBody @Valid UsuarioDTO usuarioDto, @PathVariable Integer id){
    	Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, mapper.map(usuarioDto, Usuario.class));
        return retornarSucesso(usuarioAtualizado);
    }

    /**
     * Apaga um objeto Usuario cadastrado
     *
     * @param id identificador
     */
    @ApiOperation(
            value = "Apaga um objeto Usuario cadastrado.",
            notes = "Apaga um objeto Usuario cadastrado.",
            tags = {"deletar, usuario"})
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponseDTO<String>> deletarUsuario(@PathVariable Integer id){
        usuarioService.deletar(id);
        return retornarSucesso("Usuário deletado com sucesso!");
    }
}
