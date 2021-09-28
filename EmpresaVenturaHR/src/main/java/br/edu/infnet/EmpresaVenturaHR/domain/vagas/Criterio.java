
package br.edu.infnet.EmpresaVenturaHR.domain.vagas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

/**
 *
 * @author bruno
 */

@Entity
public class Criterio{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private Integer perfil;
    private Integer peso;
    @JoinColumn(name = "id_vaga", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vaga idVaga;

    public Criterio() {
    }

    public Criterio(Integer id) {
        this.id = id;
    }

    public Criterio(Integer id, String descricao, int perfil, int peso) {
        this.id = id;
        this.descricao = descricao;
        this.perfil = perfil;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getPerfil() {
        return perfil;
    }

    public void setPerfil(Integer perfil) {
        this.perfil = perfil;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Vaga getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Vaga idVaga) {
        this.idVaga = idVaga;
    }

    
}
