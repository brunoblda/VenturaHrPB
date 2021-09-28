
package br.edu.infnet.EmpresaVenturaHR.infra.vagas;

import br.edu.infnet.EmpresaVenturaHR.domain.vagas.Vaga;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VagaRepository extends CrudRepository<Vaga, Integer>{
          
    @Query("from Vaga v where v.idUsuario = :idUsuario")
    public List<Vaga> findByIdUsuario(int idUsuario);
    
    @Query("from Vaga v where v.cargo = :cargo")
    public List<Vaga> findByCargo(String cargo);
            
    @Query("from Vaga v where v.cidade = :cidade")
    public List<Vaga> findByCidade(String cidade);
    
}
