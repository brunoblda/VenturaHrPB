
package br.edu.infnet.EmpresaVenturaHR.app.vagas;

import br.edu.infnet.EmpresaVenturaHR.domain.vagas.Criterio;
import br.edu.infnet.EmpresaVenturaHR.domain.vagas.Vaga;
import br.edu.infnet.EmpresaVenturaHR.service.vagas.VagaService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author bruno
 */

@RestController
@RequestMapping(path = {"/vagas"})
public class VagaController {
    
    @Autowired
    private VagaService vagaService;
    
    @GetMapping(path = "/vagas")
    public ResponseEntity listarVagas(){
        
        List<Vaga> lista = (List<Vaga>) vagaService.obterLista();
        
        return ResponseEntity.ok().body(lista);
    }
    
    @GetMapping(path = "/usuario/{idUsuario}")
    public ResponseEntity obterPorUsuario(@PathVariable int idUsuario){
        
        ResponseEntity response = ResponseEntity.notFound().build();
        
        List<Vaga> lista = null;
        
        try {
            lista = vagaService.obterListaPorUsuario(idUsuario);
        } catch (Exception e) {
        }
        
        if (lista != null) {
            response = ResponseEntity.ok().body(lista);
        }
          
        return response;
    }
    
    @GetMapping(path = "/cargo/{pesquisa}")
    public ResponseEntity obterPorCargo(@PathVariable String pesquisa){
        
        ResponseEntity response = ResponseEntity.notFound().build();
        
        List<Vaga> lista = null;
        
        try {
            lista = vagaService.obterListaPorCargo(pesquisa);
        } catch (Exception e) {
        }
        
        if (lista != null) {
            response = ResponseEntity.ok().body(lista);
        }
  
            
        return response;
    }
    
    @GetMapping(path = "/cidade/{pesquisa}")
    public ResponseEntity getByCity(@PathVariable String pesquisa){
        
        ResponseEntity response = ResponseEntity.notFound().build();
        
        List<Vaga> lista = null;
        
        try {
            lista = vagaService.obterListaPorCidade(pesquisa);
        } catch (Exception e) {
        }
        
        if (lista != null) {
            response = ResponseEntity.ok().body(lista);
        }            
            
         return response;
    }
    
    @PostMapping
    public ResponseEntity publicarVaga(@RequestBody Vaga vaga){
        
        ResponseEntity retorno = ResponseEntity.badRequest().build();
        
        List<Criterio> listaCriterio = vaga.getCriterioList();
        
        if(listaCriterio != null && !listaCriterio.isEmpty()){
            
            for (Criterio criterio : listaCriterio){
                
                criterio.setIdVaga(vaga);
            }
            
            Vaga vagaSalva = vagaService.incluir(vaga);
            
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .buildAndExpand(vagaSalva)
                    .toUri();

            retorno = ResponseEntity.created(location).body(vagaSalva);
        }
        return retorno;
    }
    
}
