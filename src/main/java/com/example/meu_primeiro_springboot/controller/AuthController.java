package com.example.meu_primeiro_springboot.controller;

// Importa anotações para mapeamento de rotas
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importa classes do projeto
import com.example.meu_primeiro_springboot.model.Usuario;
import com.example.meu_primeiro_springboot.security.JwtUtil;
import com.example.meu_primeiro_springboot.service.UsuarioService;

// Importa classes para trabalhar com Map e Optional
import java.util.Map;
import java.util.Optional;

// Importa classes para resposta HTTP
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Marca como controlador REST que retorna dados JSON
@RestController
// Define prefixo "/auth" para todas as rotas deste controlador
@RequestMapping("/auth")
public class AuthController {

    // Injeta o serviço de usuários
    private final UsuarioService usuarioService;

    // Construtor com injeção de dependência
    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Mapeia requisições POST para "/auth/register"
    @PostMapping("/register")
    // Método para registrar novo usuário
    // @RequestBody converte JSON da requisição em Map
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        // Chama serviço para registrar usuário com dados do request
        Usuario usuario = usuarioService.registrarUsuario(request.get("username"), request.get("password"));
        // Retorna resposta HTTP 200 com dados do usuário criado
        return ResponseEntity.ok(usuario);
    }
    
    // Mapeia requisições POST para "/auth/login"
    @PostMapping("/login")
    // Método para fazer login do usuário
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
       // Busca usuário pelo username fornecido
       Optional<Usuario> usuario = usuarioService.buscarPorUsername(request.get("username"));
       
       // Verifica se usuário existe E se a senha confere
       if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
         // Se credenciais válidas, gera token JWT
         String token = JwtUtil.generateToken(usuario.get().getUsername());
         // Retorna token em formato JSON
         return ResponseEntity.ok(Map.of("token", token));
       }
       // Se credenciais inválidas, retorna erro 401 (Unauthorized)
       return ResponseEntity.status(401).body("Credenciais inválidas");
    }
}
