package com.example.meu_primeiro_springboot.service;

// Importa List para trabalhar com listas
import java.util.List;
// Importa Optional para valores que podem ser nulos (não usado aqui)
import java.util.Optional;

// Importa anotação que marca esta classe como serviço
import org.springframework.stereotype.Service;

// Importa exceção personalizada e entidades
import com.example.meu_primeiro_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.repository.ProdutoRepository;

// Marca esta classe como um serviço Spring (lógica de negócio)
@Service
public class ProdutoService {

    // Injeta o repositório de produtos para acesso aos dados
    private final ProdutoRepository produtoRepository;

    // Construtor que recebe o repositório por injeção de dependência
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Método para listar todos os produtos
    public List<Produto> listarProdutos() {
        // Chama o método findAll() do repositório para buscar todos os produtos
        return produtoRepository.findAll();
    }

    // Método para buscar produto por ID
    public Produto buscarPorId(Long id) {
        // Busca produto por ID, se não encontrar lança exceção personalizada
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado."));
    }

    // Método para salvar um produto (criar ou atualizar)
    public Produto salvarProduto(Produto produto) {
        // Chama o método save() do repositório para persistir o produto
        return produtoRepository.save(produto);
    }

    // Método para deletar um produto por ID
    public void deletarProduto(Long id) {
        // Verifica se o produto existe antes de tentar deletar
        if (!produtoRepository.existsById(id)) {
            // Se não existe, lança exceção personalizada
            throw new RecursoNaoEncontradoException("Produto com ID "+id +" não encontrado.");
        }
        // Se existe, deleta o produto pelo ID
        produtoRepository.deleteById(id);
    }
}
