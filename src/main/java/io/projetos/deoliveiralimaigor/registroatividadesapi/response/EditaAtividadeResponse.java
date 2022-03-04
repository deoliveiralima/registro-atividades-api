package io.projetos.deoliveiralimaigor.registroatividadesapi.response;

import java.util.Date;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.CategoriaAtividadeEntity;
import lombok.Data;


@Data
public class EditaAtividadeResponse extends AtividadeResponse{


    private Long categoriaAtividadeId;
    
}
