package io.projetos.deoliveiralimaigor.registroatividadesapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.PerfilEntity;

@Repository
public interface PerfilRepository extends CrudRepository<PerfilEntity, Long> {
    
    
}
