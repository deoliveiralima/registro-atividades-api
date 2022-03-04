package io.projetos.deoliveiralimaigor.registroatividadesapi.response;

import java.util.Date;

import lombok.Data;


@Data
public class AtividadeResponse {

    private Long id;
    private String descricao;
    private String motivo;
    private Date data; 
    
    
}
