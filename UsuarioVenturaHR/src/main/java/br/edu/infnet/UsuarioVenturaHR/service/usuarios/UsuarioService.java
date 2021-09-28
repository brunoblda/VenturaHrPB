/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.infnet.UsuarioVenturaHR.service.usuarios;

/**
 *
 * @author bruno
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.UsuarioVenturaHR.domain.usuarios.Usuario;
import br.edu.infnet.UsuarioVenturaHR.infra.usuarios.UsuarioRepositoryDB;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositoryDB usuarioRepositoryDB;
		
        public List<Usuario> obterLista(){
		return (List<Usuario>) usuarioRepositoryDB.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}
	
	public List<Usuario> obterLista(String campo){
		return (List<Usuario>) usuarioRepositoryDB.findAll(Sort.by(Sort.Direction.ASC, campo));
	}
	
	public void incluir(Usuario usuario) {
		usuarioRepositoryDB.save(usuario);
	}
	
	public void excluir(Integer id) {
		usuarioRepositoryDB.deleteById(id);
		
	}
        
        public void alterar(Usuario usuario){
                usuarioRepositoryDB.save(usuario);
        }
		
	public Usuario obterPorId(Integer id) {	
		return usuarioRepositoryDB.findById(id).orElse(null);
	}
        
        public Usuario obterPorEmail(String email) {	
		return usuarioRepositoryDB.findByEmail(email);
	}
	
	

}
