
package br.edu.infnet.EmpresaVenturaHR.service.vagas;

/**
 *
 * @author bruno
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.EmpresaVenturaHR.domain.vagas.Vaga;
import br.edu.infnet.EmpresaVenturaHR.domain.vagas.Criterio;
import br.edu.infnet.EmpresaVenturaHR.infra.vagas.VagaRepository;

@Service
public class VagaService {
    
    @Autowired
	private VagaRepository vagaRepository;
		
        public List<Vaga> obterLista(){
            return (List<Vaga>) vagaRepository.findAll();
		
	}        
        
        public List<Vaga> obterListaPorUsuario(Integer idUsuario){
            return (List<Vaga>) vagaRepository.findByIdUsuario(idUsuario);
		
	}

        
        public List<Vaga> obterListaPorCargo(String pesquisa){
            return (List<Vaga>) vagaRepository.findByCargo(pesquisa);
		
	}
        
        public List<Vaga> obterListaPorCidade(String pesquisa){
            return (List<Vaga>) vagaRepository.findByCidade(pesquisa);
		
	}

	public Vaga incluir(Vaga vaga) {
            
		vagaRepository.save(vaga);
                
                return vaga;
	}
            		
	public Vaga obterPorId(Integer id) {	
		return vagaRepository.findById(id).orElse(null);
	}       
    
}
