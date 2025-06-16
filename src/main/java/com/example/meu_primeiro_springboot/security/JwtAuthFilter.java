package com.example.meu_primeiro_springboot.security;

// Importa IOException para tratamento de exceções de I/O
import java.io.IOException;

// Importa classes do Spring Security para autenticação
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
// Importa anotação de componente Spring
import org.springframework.stereotype.Component;
// Importa classe base para filtros que executam uma vez por requisição
import org.springframework.web.filter.OncePerRequestFilter;

// Importa classes para trabalhar com requisições HTTP
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Marca como componente Spring para ser gerenciado pelo container
@Component
// Estende OncePerRequestFilter para garantir execução única por requisição
public class JwtAuthFilter extends OncePerRequestFilter {

    // Injeta serviço para carregar detalhes do usuário
    private final UserDetailsService userDetailsService;

    // Construtor com injeção de dependência
    public JwtAuthFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    // Método principal do filtro, executado a cada requisição
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // Extrai header "Authorization" da requisição
        String authHeader = request.getHeader("Authorization");
        
        // Verifica se header existe e começa com "Bearer "
        if (authHeader == null || !authHeader.startsWith("Bearer")) {
            // Se não tem token, continua cadeia de filtros sem autenticar
            filterChain.doFilter(request, response);
            return;
        }

        // Remove "Bearer " do início para obter apenas o token
        String token = authHeader.substring(7);
        // Extrai username do token JWT
        String username = JwtUtil.extractUsername(token);

        // Verifica se username existe e se não há autenticação no contexto
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Carrega detalhes do usuário pelo username
            UserDetails userdetails = userDetailsService.loadUserByUsername(username);
            
            // Valida se o token é válido
            if (JwtUtil.validateToken(token)) {
                // Cria token de autenticação do Spring Security
                UsernamePasswordAuthenticationToken authToken = 
                    new UsernamePasswordAuthenticationToken(userdetails, null, userdetails.getAuthorities());
                // Define autenticação no contexto de segurança
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            // Continua cadeia de filtros
            filterChain.doFilter(request, response);
        }
    }
}
