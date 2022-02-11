package io.projetos.deoliveiralimaigor.registroatividadesapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity (name = "atividades")
public class AtividadeEntity {

    @Id
    @GeneratedValue
    private Long id;


    @Column(nullable = false)
    private String descricao;

    private String motivo;

    @JsonFormat
    @Column(nullable = false)
    private String data;

    public Long getId(){
        return this.id;
    }

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

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }




}
