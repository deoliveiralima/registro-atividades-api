package io.projetos.deoliveiralimaigor.registroatividadesapi.response;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.CategoriaAtividadeEntity;
import lombok.Data;


@Data
public class ObtemAtividadeResponse extends AtividadeResponse {

    private CategoriaAtividadeEntity categoriaAtividade;
}
