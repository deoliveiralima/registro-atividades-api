package io.projetos.deoliveiralimaigor.registroatividadesapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.UsuarioEntity;


@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long > {

    Optional<UsuarioEntity> findByUsername(String username);

    
}
