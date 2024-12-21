package com.permisos.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(http -> {
                    http.requestMatchers("/api/usuario/login").permitAll();
                    
                    http.requestMatchers("/empleado/listar").hasRole("Jefe");
                    http.requestMatchers("/empleado/empleados").hasRole("Jefe");
                    
                    http.requestMatchers("/menu/listar").hasRole("Jefe");
                    
                    http.requestMatchers("/permisosRol/listar").hasRole("Jefe");
                    http.requestMatchers("/permisosRol/actualizar").hasRole("Jefe");
                    http.requestMatchers("/permisosRol/detalles/{idRol}").hasRole("Jefe");
                    
                    http.requestMatchers("/rol/listar").hasRole("Jefe");
                    http.requestMatchers("/rol/obtener/{id}").hasRole("Jefe");
                    
                    http.requestMatchers("/subMenus/listar").hasRole("Jefe");
                    http.requestMatchers("/subMenus/actualizar/{idSubMenus}").hasRole("Jefe");
                    http.requestMatchers("/subMenus/listarPorMenu/{idMenu}").hasRole("Jefe");
                    
                    http.requestMatchers("/tipoDocumento/listar").hasRole("Jefe");
                    http.requestMatchers("/permisosRol/detalles/{id}").hasRole("Jefe");
                    
                    http.requestMatchers("/usuarios/actualizar-rol").hasRole("Jefe");

                    http.anyRequest().authenticated();
                })
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);  

        return httpSecurity.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
