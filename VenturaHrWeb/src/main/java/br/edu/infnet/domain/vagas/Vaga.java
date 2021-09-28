
package br.edu.infnet.domain.vagas;

import java.util.List;

public class Vaga {
    
    private Integer id;
    private String cargo;
    private String cidade;
    private String tipoContratacao;
    private Integer idUsuario;
    private List<Criterio> criterioLista;
    
    public Vaga(){
        
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTipoContratacao() {
        return tipoContratacao;
    }

    public void setTipoContratacao(String formaContratacao) {
        this.tipoContratacao = formaContratacao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Criterio> getCriterioList() {
        return criterioLista;
    }

    public void setCriterioList(List<Criterio> criterioLista) {
        this.criterioLista = criterioLista;
    }
    
    
}
