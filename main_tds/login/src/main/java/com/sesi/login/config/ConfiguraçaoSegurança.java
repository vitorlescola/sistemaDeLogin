package com.sesi.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//import com.sesi.login.service.DetalhesUsuarioService;

@Configuration
public class ConfiguraçaoSegurança {
	

    /*private final DetalhesUsuarioService detalhesUsuarioServico;

    public ConfiguraçaoSegurança(DetalhesUsuarioService detalhesUsuarioServico) {
        this.detalhesUsuarioServico = detalhesUsuarioServico;
    }*/

    @Bean
    public BCryptPasswordEncoder encoderSenha() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) -> 
                authorize
                    .requestMatchers("/login", "/registrar","/error").permitAll()
                    .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin((form) ->
                form
                    .loginPage("/login")
                    .defaultSuccessUrl("/home", true)
                    .permitAll()
            )
            .logout((logout) -> logout
                    .logoutUrl("/logout")  
                    .logoutSuccessUrl("/login?logout")  // Redireciona para /login após o logout
                    .invalidateHttpSession(true)  // Invalida a sessão do usuário
                    .deleteCookies("JSESSIONID")  // Remove o cookie da sessão
                    .permitAll()
            );

        return http.build();
    }

}