package com.example.meu_primeiro_springboot.service;

// Importa anotação que marca esta classe como serviço
import org.springframework.stereotype.Service;

// Importa o repositório de mensagens
import com.example.meu_primeiro_springboot.repository.MensagemRepository;

// Marca esta classe como um serviço Spring (camada de lógica de negócio)
@Service
public class MensagemService {
    
    // Injeta o repositório de mensagens para acesso aos dados
    private final MensagemRepository mensagemRepository;

    // Construtor que recebe o repositório por injeção de dependência
    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }

    // Método que obtém mensagem através do repositório
    public String obterMensagem() {
        // Delega a operação para o repositório
        return mensagemRepository.obterMensagem();
    }
}
