/**
 * Clase en la cual se realiza la configuracion de SpringSecurity
 */

package com.trabajotoo.saleisi.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.trabajotoo.saleisi.services.CustomSuccessHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("com.trabajotoo.saleisi.*")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	// UserDetailsService que creamos para realizar la autenticacion desde la
	// BD
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	CustomSuccessHandler customSuccesHandler;
	
	// Metodo en el cual se registra el AutheticationProvide donde registramos
	// el customUserDetailsService y el metodo de encriptado y desencriptado
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}
	
	// Encriptador y desencriptador de SpringSecurity
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// Registro del metodo de encriptado/desencriptado de SpringSecurity
	// y el customUserDetailsService
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
	    authenticationProvider.setPasswordEncoder(passwordEncoder());
	    return authenticationProvider;
	}
	
	// Configuracion general de acceso a las diferentes secciones de la pag. web
	// ademas de proteccion contras diferentes tipos de ataques y configuracion de
	// el formulario de login
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/register").permitAll()
		.antMatchers("/admin/**").access("hasRole('ADMIN')")
		.antMatchers("/coordinador/**").access("hasRole('COORD')")
		.antMatchers("/director/**").access("hasRole('DIR')")
		.and().formLogin().loginPage("/")
		.successHandler(customSuccesHandler).usernameParameter("nomUsuario")
		.passwordParameter("password");
	}

}
