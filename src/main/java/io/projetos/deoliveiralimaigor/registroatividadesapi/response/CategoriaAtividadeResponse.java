package io.projetos.deoliveiralimaigor.registroatividadesapi.response;

import java.util.Set;

import lombok.Data;

@Data
public class CategoriaAtividadeResponse {
    private String nome;
    private Long id;
    private Set<AtividadeResponse> atividades;

    public void setAtividaes(Set<AtividadeResponse> atividades){
        this.atividades = atividades;
    }
    public  Set<AtividadeResponse> getAtividades(){

        return this.atividades;
    }
    
}
