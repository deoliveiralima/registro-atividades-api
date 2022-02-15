package io.projetos.deoliveiralimaigor.registroatividadesapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.UsuarioEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
        Optional<UsuarioEntity> optional = usuarioRepository.findByUsername(username);

        if(optional.isPresent()){
            return optional.get();
        }

        throw new UsernameNotFoundException("Uer not found");
    }
    
}
