package io.projetos.deoliveiralimaigor.registroatividadesapi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.AtividadeEntity;

@Repository
@Component
public interface AtividadeRepository extends CrudRepository<AtividadeEntity, Long> {
    public List<AtividadeEntity> findAllByOrderByDataAsc();
    public List<AtividadeEntity> findAllByOrderByDataDesc();
    public List<AtividadeEntity> findAll(Sort by);
    public List<AtividadeEntity> findByData(Date data);
 
     
}
