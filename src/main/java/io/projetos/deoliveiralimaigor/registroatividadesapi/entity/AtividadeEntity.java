package io.projetos.deoliveiralimaigor.registroatividadesapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Date data;

    @ManyToOne
    @JsonBackReference
    private CategoriaAtividadeEntity categoriaAtividade;

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

    public void setData(Date data){
        this.data = data;
    }

    public Date getData(){
        return this.data;
    }
    public void setCategoriaAtividade(CategoriaAtividadeEntity categoriaAtividadeEntity){
        this.categoriaAtividade = categoriaAtividadeEntity;
    }

    public CategoriaAtividadeEntity getCategoriaAtividade(){
        return this.categoriaAtividade;
    }






}
