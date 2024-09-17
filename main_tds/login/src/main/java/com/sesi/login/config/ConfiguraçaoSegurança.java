package com.sesi.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ConfiguraçaoSegurança {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
		    .authorizeHttpRequests((authorize)->
		        authorize
		            .requestMatchers("/login","/registrar").permitAll()
		            .anyRequest().authenticated()
		            )
		            .formLogin((form)->
		            form
		                .loginPage("/login")
		                .defaultSuccessURL("/home",true)
		                )
		    		) ;
		return http.build();
	}
}