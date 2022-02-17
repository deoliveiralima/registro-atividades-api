package io.projetos.deoliveiralimaigor.registroatividadesapi.entity;

import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data 
@Entity(name = "categoria_atividade")
public class CategoriaAtividadeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoriaAtividade", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<AtividadeEntity> atividades;

   
    public void setAtividades(Set<AtividadeEntity> atividades){
        this.atividades = atividades;
        
    }

    public Set<AtividadeEntity> getAtividades(){
        return this.atividades;
    }

    
}
