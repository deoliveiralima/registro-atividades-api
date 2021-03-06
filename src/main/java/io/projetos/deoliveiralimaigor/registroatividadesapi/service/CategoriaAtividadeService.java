package io.projetos.deoliveiralimaigor.registroatividadesapi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.AtividadeEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.CategoriaAtividadeEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.CategoriaAtividadeRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.request.CategoriaAtividadeRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.AtividadeResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.CategoriaAtividadeResponse;

@Service
public class CategoriaAtividadeService {
    @Autowired
    private CategoriaAtividadeRepository categoriaAtividadeRepository;

    public CategoriaAtividadeResponse salvaCategoriaAtividade(CategoriaAtividadeRequest categoriaAtividadeRequest){
        CategoriaAtividadeEntity categoriaAtividade = new CategoriaAtividadeEntity();
        CategoriaAtividadeEntity categoriaAtividadeSalva = new  CategoriaAtividadeEntity();
        CategoriaAtividadeResponse categoriaAtividadeResponse = new CategoriaAtividadeResponse();

        BeanUtils.copyProperties(categoriaAtividadeRequest, categoriaAtividade);
        try{
            categoriaAtividadeSalva = categoriaAtividadeRepository.save(categoriaAtividade);

            
        }catch(Exception e){
            System.out.println(e);
        }
        BeanUtils.copyProperties(categoriaAtividadeSalva, categoriaAtividadeResponse);


        return categoriaAtividadeResponse;
        
    }

    public List<CategoriaAtividadeResponse> listaCategoriaAtividade(){
        List<CategoriaAtividadeEntity> categoriaAtividades = new ArrayList();
        List<CategoriaAtividadeResponse> categoriaAtividadesResponse =  new ArrayList();
       
        
        try{
            categoriaAtividades =  (List<CategoriaAtividadeEntity>) categoriaAtividadeRepository.findAll();
            
        }catch(Exception e){
            System.out.println(e);
        }
        for (CategoriaAtividadeEntity categoriaAtividade : categoriaAtividades) {
            CategoriaAtividadeResponse categoriaAtividadeResponse = new CategoriaAtividadeResponse();
            BeanUtils.copyProperties(categoriaAtividade, categoriaAtividadeResponse);
            categoriaAtividadesResponse.add(categoriaAtividadeResponse);

        }
    
        return categoriaAtividadesResponse;
        
    }

    public CategoriaAtividadeResponse obtemCategoriaAtividade(Long id){
        CategoriaAtividadeEntity categoriaAtividade = new CategoriaAtividadeEntity();
        CategoriaAtividadeResponse categoriaAtividadeResponse = new CategoriaAtividadeResponse();
        List<AtividadeResponse> atividadesResponse = new ArrayList();
        
        try{
            categoriaAtividade = categoriaAtividadeRepository.findById(id).get();

        }catch(Exception e){
            System.out.println(e);
        }

        BeanUtils.copyProperties(categoriaAtividade, categoriaAtividadeResponse);

        for (AtividadeEntity atividadeEntity : categoriaAtividade.getAtividades()) {
            
            AtividadeResponse atividadeResponse = new AtividadeResponse();
            BeanUtils.copyProperties(atividadeEntity, atividadeResponse);

            atividadesResponse.add(atividadeResponse);
            
        }
        categoriaAtividadeResponse.setAtividaes(atividadesResponse);
        

        return categoriaAtividadeResponse;
        
    }

    public CategoriaAtividadeResponse atualizaCategoriaAtividade(CategoriaAtividadeRequest categoriaAtividadeRequest, Long id){
        CategoriaAtividadeEntity categoriaAtividade = new CategoriaAtividadeEntity();
        CategoriaAtividadeEntity categoriaAtividadeSalva = new  CategoriaAtividadeEntity();
        CategoriaAtividadeResponse categoriaAtividadeResponse = new CategoriaAtividadeResponse();

        BeanUtils.copyProperties(categoriaAtividadeRequest, categoriaAtividade);
        try{
            categoriaAtividade = categoriaAtividadeRepository.findById(id).get();
            BeanUtils.copyProperties(categoriaAtividadeRequest, categoriaAtividade);
            categoriaAtividadeSalva = categoriaAtividadeRepository.save(categoriaAtividade);

            
        }catch(Exception e){
            System.out.println(e);
        }
        BeanUtils.copyProperties(categoriaAtividadeSalva, categoriaAtividadeResponse);


        return categoriaAtividadeResponse;
        
    }

    public Boolean excluiCategoriaAtividade(Long id){
        CategoriaAtividadeEntity categoriaAtividade = new CategoriaAtividadeEntity();
        CategoriaAtividadeResponse categoriaAtividadeResponse = new CategoriaAtividadeResponse();
        Boolean response= Boolean.FALSE;
        
        try{
            categoriaAtividadeRepository.deleteById(id);
            response = Boolean.TRUE;
            
        }catch(Exception e){
            System.out.println(e);
        }
        BeanUtils.copyProperties(categoriaAtividade, categoriaAtividadeResponse);

        return response;
        
    }

}
