package io.projetos.deoliveiralimaigor.registroatividadesapi.response;

import java.util.Date;


public class AtividadeResponse {

    private String descricao;
    private String motivo;
    private Date data; 

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setMotivo(String motivo){
        this.motivo = motivo;
    }

    public String getMotivo(){
        return this.motivo;
    }

    public void setData(Date data){
        this.data = data;
    }

    public Date getData(){
        return this.data;
    }

    
}
