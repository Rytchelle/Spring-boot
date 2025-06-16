package com.example.meu_primeiro_springboot.service;

// Importa Optional para lidar com valores que podem ser nulos
import java.util.Optional;

// Importa classe para criptografia de senhas
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// Importa interface para codificação de senhas
import org.springframework.security.crypto.password.PasswordEncoder;
// Importa anotação que marca esta classe como serviço
import org.springframework.stereotype.Service;

// Importa entidade Usuario e repositório
import com.example.meu_primeiro_springboot.model.Usuario;
import com.example.meu_primeiro_springboot.repository.UsuarioRepository;

// Marca esta classe como um serviço Spring (camada de negócio)
@Service
public class UsuarioService {

    // Injeta o repositório de usuários para acesso aos dados
    private final UsuarioRepository usuarioRepository;
    // Codificador de senhas para criptografia
    private final PasswordEncoder passwordEncoder;

    // Construtor que recebe o repositório por injeção de dependência
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        // Inicializa o codificador BCrypt para criptografar senhas
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Método para registrar um novo usuário no sistema
    public Usuario registrarUsuario(String username, String password) {
        // Criptografa a senha usando BCrypt antes de salvar
        String senhaCriptografada = passwordEncoder.encode(password);
        // Cria novo objeto Usuario com senha criptografada
        Usuario usuario = new Usuario(username, senhaCriptografada);
        // Salva o usuário no banco de dados e retorna o objeto salvo
        return usuarioRepository.save(usuario);
    }

    // Método para buscar usuário pelo username
    public Optional<Usuario> buscarPorUsername(String username) {
        // Delega a busca para o repositório e retorna Optional
        return usuarioRepository.findByUsername(username);
    }
}
