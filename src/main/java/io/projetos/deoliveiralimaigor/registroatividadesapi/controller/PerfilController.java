package io.projetos.deoliveiralimaigor.registroatividadesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.projetos.deoliveiralimaigor.registroatividadesapi.request.PerfilRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.PerfilResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.PerfilService;

@RestController
@RequestMapping("perfil")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @ResponseBody
    @PostMapping
    public PerfilResponse salvaPerfil(@RequestBody PerfilRequest perfilRequest){

        
        return perfilService.salvaPerfil(perfilRequest); 


    }
    
}
