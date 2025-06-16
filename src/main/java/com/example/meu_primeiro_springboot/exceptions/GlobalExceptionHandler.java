package com.example.meu_primeiro_springboot.exceptions;

// Importa classes para trabalhar com data/hora e coleções
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

// Importa classes do Spring para resposta HTTP
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// Importa anotações para tratamento global de exceções
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Marca como classe que trata exceções globalmente em todos os controladores REST
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    // Método que trata especificamente RecursoNaoEncontradoException
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Object> handleRecursoNaoEncontrado(RecursoNaoEncontradoException ex) {
        // Cria mapa para estruturar resposta de erro
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now()); // Adiciona timestamp do erro
        body.put("status", HttpStatus.NOT_FOUND.value()); // Adiciona código de status (404)
        body.put("error", "Recurso não encontrado"); // Adiciona tipo do erro
        body.put("message", ex.getMessage()); // Adiciona mensagem específica da exceção
        
        // Retorna resposta com status 404 e corpo estruturado
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    // Método que trata qualquer exceção não específica (fallback)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        // Cria mapa para resposta de erro genérico
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now()); // Timestamp do erro
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); // Status 500
        body.put("error", "Erro interno do servidor"); // Tipo de erro genérico
        body.put("message", ex.getMessage()); // Mensagem da exceção
        
        // Retorna resposta com status 500 e corpo estruturado
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
