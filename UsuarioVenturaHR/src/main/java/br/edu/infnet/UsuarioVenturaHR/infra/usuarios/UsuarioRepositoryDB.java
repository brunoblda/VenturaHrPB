package br.edu.infnet.UsuarioVenturaHR.infra.usuarios;

/**
 *
 * @author bruno
 */
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.UsuarioVenturaHR.domain.usuarios.Usuario;

@Repository
public interface UsuarioRepositoryDB extends CrudRepository<Usuario, Integer> {

	public List<Usuario> findAll(Sort sort);
        
        @Query("from Usuario u where u.email = :email")
        public Usuario findByEmail(String email);
        

}