/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.UsuarioVenturaHR.app.usuarios;

import br.edu.infnet.UsuarioVenturaHR.infra.usuarios.UsuarioRepository;
import br.edu.infnet.UsuarioVenturaHR.domain.usuarios.Usuario;
import br.edu.infnet.UsuarioVenturaHR.domain.usuarios.Endereco;
import br.edu.infnet.UsuarioVenturaHR.service.usuarios.UsuarioService;
import br.edu.infnet.UsuarioVenturaHR.service.usuarios.ViaCEPClient;

import java.util.Collection;
import javax.servlet.RequestDispatcher;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author bruno
 */
@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {

    @Autowired
    private ViaCEPClient viaCepClient;

    //@Autowired
    //private UsuarioRepository repository;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity ListarUsuarios() {

        return ResponseEntity.ok().body(usuarioService.obterLista());
        //return usuarioService.obterLista();
        //return repository.listar();

    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity obterUsuarioById(@PathVariable int id) {

        ResponseEntity response = ResponseEntity.notFound().build();

        Usuario usuarioBanco = null;

        try {
            usuarioBanco = usuarioService.obterPorId(id);
        } catch (Exception e) {
        }

        if (usuarioBanco != null) {
            response = ResponseEntity.ok().body(usuarioBanco);
        }

        return response;

        //return usuarioService.obterPorId(id);
        //return repository.obter(id);
    }
    
    @GetMapping(path = {"/email/{email}"})
    public ResponseEntity ObterUsuarioByEmail(@PathVariable String email){
        
        ResponseEntity response = ResponseEntity.notFound().build();
        
         Usuario usuarioBanco = null;    
        
        try {
            usuarioBanco = usuarioService.obterPorEmail(email);
        } catch (Exception e) {
        }

        if (usuarioBanco != null) {
            response = ResponseEntity.ok().body(usuarioBanco);
        }
        
        return response;
    }
    
    @GetMapping(path = {"/deletar/{id}"})
    public ResponseEntity deletarUsuarioById(@PathVariable int id) {

        ResponseEntity response = ResponseEntity.notFound().build();

        Usuario usuarioBanco = null;

        try {
            usuarioBanco = usuarioService.obterPorId(id);
        } catch (Exception e) {
        }

        if (usuarioBanco != null) {
            usuarioService.excluir(id);
            response = ResponseEntity.ok().body(usuarioBanco);
        }

        return response;

        //return usuarioService.obterPorId(id);
        //return repository.obter(id);
    }

    @PostMapping(path = {"/cadastro"})
    public ResponseEntity criarUsuario(@RequestBody Usuario usuario) {

        String cep = usuario.getCep();

        Endereco enderecoCep;

        ResponseEntity response = ResponseEntity.badRequest().build();

        try {

            enderecoCep = viaCepClient.buscaEnderecoPor(cep);

            usuario.setBairro(enderecoCep.getBairro());
            usuario.setLogradouro(enderecoCep.getLogradouro());
            usuario.setComplemento(enderecoCep.getComplemento());
            usuario.setLocalidade(enderecoCep.getLocalidade());
            usuario.setUf(enderecoCep.getUf());

        } catch (Exception e) {
        }

        usuarioService.incluir(usuario);

        response = ResponseEntity.status(HttpStatus.CREATED).body(usuario);

        return response;

        //Usuario usuarioRetorno; 
        //usuarioRetorno = repository.adicionar(usuario);
    }

    @PostMapping(path = {"/editar"})
    public ResponseEntity editarUsuario(@RequestBody Usuario usuario) {

        ResponseEntity response = ResponseEntity.badRequest().build();

        if (usuario != null) {

            Usuario usuarioBanco;
            try {
                usuarioBanco = usuarioService.obterPorId(usuario.getId());
            } catch (Exception e) {
                
                usuarioBanco = null;
               
            }

            if (usuarioBanco != null) {

                try {
                    usuarioService.alterar(usuario);
                    response = ResponseEntity.ok().body(usuario);
                } catch (Exception e) {

                }
            }
        }

        return response;
    }

}
