package io.projetos.deoliveiralimaigor.registroatividadesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.AtividadeEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.AtividadeRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.request.AtividadeRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.AtividadeResponse;


@Service
public class AtividadeService { 

    @Autowired
    private AtividadeRepository atividadeRepository;


    public AtividadeResponse salvaAtividade (AtividadeRequest atividadeRequest){
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        AtividadeEntity atividadeSalva = new AtividadeEntity(); 
        AtividadeResponse atividadeResponse = new AtividadeResponse();

        BeanUtils.copyProperties(atividadeRequest, atividadeEntity);

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
        AtividadeResponse atividadeResponse = new AtividadeResponse();
    
        try{
            
            atividadeEntity = (AtividadeEntity) atividadeRepository.findById(id).get();

        }catch(Exception e){
            System.out.println(e);
        }
       
        return atividadeResponse;

    }

    public List<AtividadeResponse> listaAtividade(){
        List<AtividadeEntity> atividades = new ArrayList<>();
        List<AtividadeResponse> atividadesResponse = new ArrayList<>();
        

        try{
            
            atividades = (List<AtividadeEntity>) atividadeRepository.findAll();

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

    public AtividadeResponse AtualizaAtividade (AtividadeRequest atividadeRequest, Long id){
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        AtividadeEntity atividadeSalva = new AtividadeEntity(); 
        AtividadeResponse atividadeResponse = new AtividadeResponse();

        try{
            atividadeEntity = atividadeRepository.findById(id).get();
            
            BeanUtils.copyProperties(atividadeRequest, atividadeEntity);

            atividadeSalva = atividadeRepository.save(atividadeEntity);

        }catch(Exception e){
            System.out.println(e);
        }

        BeanUtils.copyProperties(atividadeSalva, atividadeResponse);

        return atividadeResponse;

    }


    public AtividadeResponse ExcluiAtividade (Long id){
        AtividadeEntity atividadeEntity = new AtividadeEntity();
        AtividadeResponse atividadeResponse = new AtividadeResponse();

        

        try{
            atividadeEntity = atividadeRepository.findById(id).get();
            atividadeRepository.deleteById(id);;
            BeanUtils.copyProperties(atividadeEntity, atividadeResponse);
        }catch(Exception e){
            System.out.println(e);
        }

        
        return atividadeResponse;

    }
    
}
