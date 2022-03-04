package io.projetos.deoliveiralimaigor.registroatividadesapi.response;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class CategoriaAtividadeResponse {
    private String nome;
    private Long id;
    private List<AtividadeResponse> atividades;

    public void setAtividaes(List<AtividadeResponse> atividades){
        this.atividades = atividades;
    }
    public  List<AtividadeResponse> getAtividades(){

        return this.atividades;
    }
    
}
