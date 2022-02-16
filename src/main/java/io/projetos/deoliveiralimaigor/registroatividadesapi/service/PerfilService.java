package io.projetos.deoliveiralimaigor.registroatividadesapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.PerfilEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.PerfilRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.request.PerfilRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.PerfilResponse;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public PerfilResponse salvaPerfil(PerfilRequest perfilRequest){
        PerfilEntity perfil = new PerfilEntity();
        PerfilEntity perfilSalvo = new PerfilEntity();
        PerfilResponse perfilResponse = new PerfilResponse();

        BeanUtils.copyProperties(perfilRequest, perfil);
    
        
        try{   
            perfilSalvo = perfilRepository.save(perfil);

        }catch(Exception e){
            System.out.println(e);
        }
        BeanUtils.copyProperties(perfilSalvo, perfilResponse);
        

        return perfilResponse;
    }
}
