
package br.edu.infnet.UsuarioVenturaHR.infra.usuarios;

import java.util.HashMap;
import org.springframework.stereotype.Repository;
import br.edu.infnet.UsuarioVenturaHR.domain.usuarios.Usuario;
import java.util.Collection;

/**
 *
 * @author bruno
 */
@Repository
public class UsuarioRepository {
/*    
    private HashMap<Integer, Usuario> usuarios;
    
    static int num = 3;
    
    
    public UsuarioRepository(){
        
        usuarios = new HashMap<>();
        usuarios.put(1, new Usuario(1,"Bruno Luiz", "Brasilia", "61988985447", "bruno@email.com", "1234", "Candidato", "334.234.567-78", null, null , null, null , null, null, null, null));
        usuarios.put(2, new Usuario(2,"Carlos Gomes", "São Paulo", "48899751234", "Carlos@email.com", "1234", "Candidato", "335.234.777-98", "Carlos tecnologia sa", "45.343.789/0001-45" , null, null , null, null , null, null));
        usuarios.put(3, new Usuario(3,"Andrea Ferreira", "Rio de Janeiro", "31956985117", "Andrea@email.com", "1234", "Empresa", "023.294.117-32", "Andrea solucoes sa", "13.647.789/0001-33" , null, null , null, null , null, null));       
    }
        
     public Collection<Usuario> listar(){
            
            return usuarios.values();
        }
     
     public Usuario obter(int id){
         
         return usuarios.get(id);
     }
    
     public Usuario adicionar(Usuario usuario){
         
         num = num+1;
         
         usuario.setId(num);
         
         usuarios.put(num, usuario);
         
         return usuario;
         
     }
  
    */
}
