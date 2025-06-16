package com.example.meu_primeiro_springboot.controller;

// Importa anotações para mapeamento de rotas
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importa o serviço de mensagens
import com.example.meu_primeiro_springboot.service.MensagemService;
// Importa anotação para requisições GET
import org.springframework.web.bind.annotation.GetMapping;
// Importa anotação para parâmetros de requisição (não usado aqui)
import org.springframework.web.bind.annotation.RequestParam;

// Marca como controlador REST que retorna dados diretamente
@RestController
// Define prefixo "/api" para todas as rotas deste controlador
@RequestMapping("/api")
public class MensagemController {
    
    // Injeta o serviço de mensagens
    private final MensagemService mensagemService;

    // Construtor com injeção de dependência
    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    // Mapeia requisições GET para "/api/mensagem"
    @GetMapping("/mensagem")
    // Método que retorna mensagem através do serviço
    public String mensagem() {
        // Delega operação para o serviço
        return mensagemService.obterMensagem();
    }
}
