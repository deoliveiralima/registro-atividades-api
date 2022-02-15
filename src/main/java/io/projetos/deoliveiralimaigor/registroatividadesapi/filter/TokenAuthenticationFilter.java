package io.projetos.deoliveiralimaigor.registroatividadesapi.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.projetos.deoliveiralimaigor.registroatividadesapi.entity.UsuarioEntity;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.UsuarioRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.TokenService;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private  TokenService tokenService;

    @Autowired
	private  UsuarioRepository usuarioRepository;

    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

        String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			token = null;
		}
		
		token = token.substring(7, token.length());

		filterChain.doFilter(request, response);   
	}

    private void authenticate(String tokenFromHeader) {
		Long id = tokenService.getTokenId(tokenFromHeader);
		
		Optional<UsuarioEntity> optionalUser = usuarioRepository.findById(id);
		
		if(optionalUser.isPresent()) {
			
			UsuarioEntity usuario = optionalUser.get();
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getPerfis());
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
	}

	private String getTokenFromHeader(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
    
}
