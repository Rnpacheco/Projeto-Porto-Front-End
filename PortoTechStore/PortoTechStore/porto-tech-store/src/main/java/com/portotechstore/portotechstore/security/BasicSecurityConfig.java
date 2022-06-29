package com.portotechstore.portotechstore.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		//Faz a validação do usuário se ele é válido ou não
		auth.userDetailsService(userDetailsService);
		
		auth.inMemoryAuthentication()
		.withUser("root")
		.password(passwordEncoder().encode("root"))
		.authorities("ROLE_USER");
	}
	
	@Bean  // Cria o objeto e deixa ele disponivel para outras classes usarem ele como dependencia
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		//Assim que o método for instanciado já cria o http
		http.authorizeRequests()//Chama a autorização e autoriza o client a acessar a base de dados sem precisar de um token
		.antMatchers("/usuarios/logar").permitAll() //Da acesso a esse endpoint, para ele logar precisa ter acesso a esse endpoint
		.antMatchers("/usuarios/cadastrar").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll() //Aceitar no heroku por exemplo
		//.anyRequest().authenticated()//As demais requisiçoes com exceção das de cimas terão que ser autenticadas
		.anyRequest().permitAll()
		.and().httpBasic() //Padrão de chave do token
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Politica de session
		.and().cors() //Cors[pesquisar] especificação do W3C que quando implementado em um navegador permite que um site x acesse recursos de outros sites.
		.and().csrf().disable(); //Csrf = um tipo de ataque que ocorre quando uma requisição é feita e tenta fazer um usuário falso se passar por outro.
	}
}