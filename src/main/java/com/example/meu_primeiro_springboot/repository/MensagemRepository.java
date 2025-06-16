package com.example.meu_primeiro_springboot.repository;

// Importa anotação que marca esta classe como repositório
import org.springframework.stereotype.Repository;

// Marca esta classe como um repositório Spring
// Permite que seja injetada em outras classes
@Repository
public class MensagemRepository {

    // Método que simula busca de mensagem no banco de dados
    // Em um cenário real, faria consulta ao banco
    public String obterMensagem() {
        // Retorna uma mensagem fixa simulando dados do repositório
        return "Olá do repositório";
    }
}
