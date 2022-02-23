package io.projetos.deoliveiralimaigor.registroatividadesapi.request;

import java.util.Date;

import lombok.Data;

@Data
public class AtividadeRequest {

    private String descricao;
    private String motivo;
    private String data;
    private Long categoriaAtividadeId;

   




    @Override
    public String toString(){

        return descricao + " | " + motivo +" | "+ data;
    }

    
}
