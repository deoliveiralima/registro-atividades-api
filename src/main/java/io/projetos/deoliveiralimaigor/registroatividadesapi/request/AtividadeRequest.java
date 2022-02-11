package io.projetos.deoliveiralimaigor.registroatividadesapi.request;

import java.util.Date;


public class AtividadeRequest {

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




    @Override
    public String toString(){

        return descricao + " | " + motivo +" | "+ data;
    }

    
}
