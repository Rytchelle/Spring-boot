package com.example.meu_primeiro_springboot.security;

// Importa anotações de configuração do Spring
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Importa classes para configuração de autenticação
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// Importa classes para configuração de segurança web
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
// Importa classes para criptografia de senhas
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// Importa classes para configuração de filtros
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// Marca como classe de configuração Spring
@Configuration
// Habilita configuração de segurança web
@EnableWebSecurity
public class SecurityConfig {

    // Injeta filtro JWT personalizado
    private final JwtAuthFilter jwtAuthFilter;
    // Injeta serviço de detalhes do usuário
    private final UserDetailsService userDetailsService;

    // Construtor com injeção de dependências
    public SecurityConfig(JwtAuthFilter jwtAuthFilter, UserDetailsService userDetailsService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userDetailsService = userDetailsService;
    }

    // Define bean para cadeia de filtros de segurança
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable()) // Desabilita CSRF (não necessário para APIs REST)
            // Configura política de sessão como STATELESS (sem sessão no servidor)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            // Configura autorização de requisições
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll() // Permite acesso livre às rotas de autenticação
                .anyRequest().authenticated()) // Exige autenticação para todas as outras rotas
            // Adiciona filtro JWT antes do filtro padrão de autenticação
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        // Constrói e retorna a configuração
        return http.build();
    }

    // Define bean para gerenciador de autenticação
    @Bean
    public AuthenticationManager authenticationManager() {
        // Cria provedor de autenticação DAO
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        // Define serviço para carregar usuários
        authProvider.setUserDetailsService(userDetailsService);
        // Define codificador de senhas
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        // Retorna gerenciador com o provedor configurado
        return new ProviderManager(authProvider);
    }
}
