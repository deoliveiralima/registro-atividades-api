package io.projetos.deoliveiralimaigor.registroatividadesapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.AtividadeEntity;

@Repository
@Component
public interface AtividadeRepository extends CrudRepository<AtividadeEntity, Long> {
    
     
}
