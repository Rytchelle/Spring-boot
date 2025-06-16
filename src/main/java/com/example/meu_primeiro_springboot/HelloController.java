package com.example.meu_primeiro_springboot;

// Importa anotação para mapear URLs para métodos
import org.springframework.web.bind.annotation.RequestMapping;
// Importa anotação que marca esta classe como um controlador REST
import org.springframework.web.bind.annotation.RestController;
// Importa anotação para mapear requisições GET
import org.springframework.web.bind.annotation.GetMapping;
// Importa anotação para capturar parâmetros da requisição (não usado neste exemplo)
import org.springframework.web.bind.annotation.RequestParam;

// Marca esta classe como um controlador REST que retorna dados diretamente (não views)
@RestController
// Define o prefixo "/api" para todas as rotas deste controlador
@RequestMapping("/api")
public class HelloController {
    
    // Mapeia requisições GET para "/api/hello"
    @GetMapping("/hello")
    public String hello() {
        // Retorna uma mensagem de saudação em português
        return "Olá, mundo!! Bem-vindo ao Spring Boot";
    }
}
