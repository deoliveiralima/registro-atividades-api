package io.projetos.deoliveiralimaigor.registroatividadesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.projetos.deoliveiralimaigor.registroatividadesapi.request.LoginRequest;
import io.projetos.deoliveiralimaigor.registroatividadesapi.response.TokenResponse;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.TokenService;

@RestController
@RequestMapping("auth")
public class AuthController {
    
    
    @Autowired
     TokenService tokenService;

     
     AuthenticationManager authenticationManager;


    @PostMapping
    public ResponseEntity<TokenResponse> auth(@RequestBody @Validated LoginRequest loginRequest){

        TokenResponse tokenResponse = new TokenResponse();

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        String token = tokenService.generateToken(authentication);
        tokenResponse.setType("Bearer");
        tokenResponse.setToken(token);
        
    
        return ResponseEntity.ok(tokenResponse );


        
    }
}