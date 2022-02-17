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

import lombok.Data;


@Data 
@Entity(name = "categoria_atividade")
public class CategoriaAtividadeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "categoria_atividade", cascade = CascadeType.ALL)
    private Set<AtividadeEntity> atividades;
   


    
}
