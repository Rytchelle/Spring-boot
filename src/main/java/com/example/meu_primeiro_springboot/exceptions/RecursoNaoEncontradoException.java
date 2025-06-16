package com.example.meu_primeiro_springboot.exceptions;

// Classe de exceção personalizada que estende RuntimeException
// Usada quando um recurso solicitado não é encontrado
public class RecursoNaoEncontradoException extends RuntimeException {

    // Construtor que recebe mensagem de erro personalizada
    public RecursoNaoEncontradoException(String mensagem) {
        // Chama construtor da classe pai (RuntimeException) com a mensagem
        super(mensagem);
    }
}
