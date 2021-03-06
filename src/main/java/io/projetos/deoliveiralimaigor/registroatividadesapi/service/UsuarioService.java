package io.projetos.deoliveiralimaigor.registroatividadesapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.UsuarioEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.UsuarioRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.request.UsuarioRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.UsuarioResponse;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioResponse salvaUsuario(UsuarioRequest usuarioRequest){


        UsuarioEntity usuario = new UsuarioEntity();
        UsuarioEntity usuarioSalvo = new UsuarioEntity();
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        
        BeanUtils.copyProperties(usuarioRequest, usuario);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);

        try{
            usuarioSalvo = usuarioRepository.save(usuario);

        }catch(Exception e){
            System.out.println(e);
        }
        

        BeanUtils.copyProperties(usuarioSalvo, usuarioResponse);

       
        return usuarioResponse;
    }
    
}
