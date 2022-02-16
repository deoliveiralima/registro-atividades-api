package io.projetos.deoliveiralimaigor.registroatividadesapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.projetos.deoliveiralimaigor.registroatividadesapi.filter.TokenAuthenticationFilter;
import io.projetos.deoliveiralimaigor.registroatividadesapi.repository.UsuarioRepository;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.AuthenticationService;
import io.projetos.deoliveiralimaigor.registroatividadesapi.service.TokenService;



@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
	
    //Configurations for authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(authenticationService).passwordEncoder(new BCryptPasswordEncoder());
    }

    //Configuration for authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers(HttpMethod.POST, "/auth").permitAll()
			.antMatchers(HttpMethod.POST, "/usuario").permitAll()
			.antMatchers(HttpMethod.POST, "/perfil").permitAll()
        	.anyRequest().authenticated()
        	.and().csrf().disable()
        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        	.and().addFilterBefore(new TokenAuthenticationFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
    }

    //Configuration for static resources
    @Override
    public void configure(WebSecurity web) throws Exception {
		web
            .ignoring()
            .antMatchers("/h2/**");
    }

}