/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.UsuarioVenturaHR.service.usuarios;


import br.edu.infnet.UsuarioVenturaHR.domain.usuarios.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 *
 * @author bruno
 */


@FeignClient(url="https://viacep.com.br/ws/", name = "viacep")
public interface ViaCEPClient {
    @GetMapping("{cep}/json")
    Endereco buscaEnderecoPor(@PathVariable("cep") String cep);
}
