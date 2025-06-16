package com.example.meu_primeiro_springboot.service;

// Importa classes do Spring Security para autenticação
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
// Importa anotação de serviço
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Importa entidade Usuario e repositório
import com.example.meu_primeiro_springboot.model.Usuario;
import com.example.meu_primeiro_springboot.repository.UsuarioRepository;

// Marca como serviço Spring
@Service
// Implementa UserDetailsService do Spring Security para autenticação
public class UsuarioDetailsService implements UserDetailsService {

    // Injeta repositório de usuários
    private final UsuarioRepository usuarioRepository;

    // Construtor com injeção de dependência
    public UsuarioDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Método obrigatório da interface UserDetailsService
    // Carrega dados do usuário para autenticação
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        // Busca usuário no banco pelo username
        Usuario usuario = usuarioRepository.findByUsername(username)
                            // Se não encontrar, lança exceção
                            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
       
        // Constrói objeto UserDetails do Spring Security
        return User.builder()
                .username(usuario.getUsername()) // Define o username
                .password(usuario.getPassword()) // Define a senha (já criptografada)
                .roles("USER") // Define o papel/role do usuário
                .build(); // Constrói o objeto
    }
}
