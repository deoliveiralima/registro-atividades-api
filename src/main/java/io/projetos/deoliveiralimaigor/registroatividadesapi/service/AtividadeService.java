package io.projetos.deoliveiralimaigor.registroatividadesapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.AtividadeEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.CategoriaAtividadeEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.AtividadeRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.CategoriaAtividadeRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.request.AtividadeRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.request.DataRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.AtividadeResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.EditaAtividadeResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.ObtemAtividadeResponse;


@Service
public class AtividadeService { 

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private CategoriaAtividadeRepository categoriaAtividadeRepository;


    public AtividadeResponse salvaAtividade (AtividadeRequest atividadeRequest){
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        AtividadeEntity atividadeSalva = new AtividadeEntity(); 
        AtividadeResponse atividadeResponse = new AtividadeResponse();
        CategoriaAtividadeEntity categoriaAtividade = new CategoriaAtividadeEntity();

        categoriaAtividade = categoriaAtividadeRepository.findById(atividadeRequest.getCategoriaAtividadeId()).get();


        BeanUtils.copyProperties(atividadeRequest, atividadeEntity);
        atividadeEntity.setCategoriaAtividade(categoriaAtividade);

        try{
            atividadeSalva = atividadeRepository.save(atividadeEntity);

        }catch(Exception e){
            System.out.println(e);
        }

        BeanUtils.copyProperties(atividadeSalva, atividadeResponse);

        return atividadeResponse;

    }

    public AtividadeResponse obterAtividade(Long id){
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        ObtemAtividadeResponse atividadeResponse = new ObtemAtividadeResponse();
    
        try{
            
            atividadeEntity = (AtividadeEntity) atividadeRepository.findById(id).get();

        }catch(Exception e){
            System.out.println(e);
        }
        BeanUtils.copyProperties(atividadeEntity, atividadeResponse);
       
        return atividadeResponse;

    }

    public AtividadeResponse editaAtividade(Long id){
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        EditaAtividadeResponse atividadeResponse = new EditaAtividadeResponse();
    
        try{
            
            atividadeEntity = (AtividadeEntity) atividadeRepository.findById(id).get();

        }catch(Exception e){
            System.out.println(e);
        }
        BeanUtils.copyProperties(atividadeEntity, atividadeResponse);
        atividadeResponse.setCategoriaAtividadeId(atividadeEntity.getCategoriaAtividade().getId());
       
        return atividadeResponse;

    }

    public List<ObtemAtividadeResponse> listaAtividade(String direcao){
        List<AtividadeEntity> atividades = new ArrayList<>();
        List<ObtemAtividadeResponse> atividadesResponse = new ArrayList<>();
        

        try{
            
            atividades =  atividadeRepository.findAll(Sort.by(Sort.Direction.valueOf(direcao), "data"));
 
        }catch(Exception e){
            System.out.println(e); 
        }
        for (AtividadeEntity atividade : atividades) {
            ObtemAtividadeResponse atividadeResponse = new ObtemAtividadeResponse();

            BeanUtils.copyProperties(atividade, atividadeResponse);
            atividadesResponse.add(atividadeResponse); 
            
        }

        return atividadesResponse;
    }

    //=====================================================================

    public List<AtividadeResponse> listaAtividadePorData(DataRequest data){
        List<AtividadeEntity> atividades = new ArrayList<>();
        List<AtividadeResponse> atividadesResponse = new ArrayList<>();
 
        try{
            
            atividades =  atividadeRepository.findByData(data.getData());
 
        }catch(Exception e){
            System.out.println(e); 
        }
        for (AtividadeEntity atividade : atividades) {
            AtividadeResponse atividadeResponse = new AtividadeResponse();

            BeanUtils.copyProperties(atividade, atividadeResponse);
            atividadesResponse.add(atividadeResponse); 
            
        }

        return atividadesResponse;
    }
    //======================================================================== 

    public AtividadeResponse AtualizaAtividade (AtividadeRequest atividadeRequest, Long id){
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        AtividadeEntity atividadeSalva = new AtividadeEntity(); 
        AtividadeResponse atividadeResponse = new AtividadeResponse();
        CategoriaAtividadeEntity categoria = new CategoriaAtividadeEntity();
        

        try{
            categoria = categoriaAtividadeRepository.findById(atividadeRequest.getCategoriaAtividadeId()).get();
            atividadeEntity = atividadeRepository.findById(id).get();
            atividadeEntity.setCategoriaAtividade(categoria);
            
            BeanUtils.copyProperties(atividadeRequest, atividadeEntity);

            atividadeSalva = atividadeRepository.save(atividadeEntity);

        }catch(Exception e){
            System.out.println(e);
        }

        BeanUtils.copyProperties(atividadeSalva, atividadeResponse);

        return atividadeResponse;

    }


    public Boolean ExcluiAtividade (Long id){
        List<AtividadeEntity> atividades = new ArrayList<>();
        AtividadeEntity atividade = new AtividadeEntity();
        Boolean response = Boolean.FALSE;

        try{

            atividade = atividadeRepository.findById(id).get();
            atividadeRepository.deleteById(id);
            response = Boolean.TRUE;
            

        }catch(Exception e){
            System.out.println(e);
        }

        
        return response;

    }
    
}
