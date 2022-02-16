package io.projetos.deoliveiralimaigor.registroatividadesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.projetos.deoliveiralimaigor.registroatividadesapi.request.UsuarioRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.UsuarioResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioResponse salvaUsuario(@RequestBody UsuarioRequest usuarioRequest){

       

        return usuarioService.salvaUsuario(usuarioRequest);
        


    }
    
}
