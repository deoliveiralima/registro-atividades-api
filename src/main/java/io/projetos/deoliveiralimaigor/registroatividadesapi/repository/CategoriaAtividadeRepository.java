package io.projetos.deoliveiralimaigor.registroatividadesapi.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.CategoriaAtividadeEntity;

@Repository
public interface CategoriaAtividadeRepository extends CrudRepository<CategoriaAtividadeEntity, Long>{
    
}
