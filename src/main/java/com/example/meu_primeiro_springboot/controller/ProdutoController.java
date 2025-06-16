package com.example.meu_primeiro_springboot.controller;

// Importa anotações para mapeamento de rotas
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Importa classes do projeto
import com.example.meu_primeiro_springboot.exceptions.RecursoNaoEncontradoException;
import com.example.meu_primeiro_springboot.model.Produto;
import com.example.meu_primeiro_springboot.service.ProdutoService;

// Importa List para trabalhar com listas
import java.util.List;

// Importa classes para resposta HTTP
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
// Importa anotações para diferentes tipos de requisição HTTP
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Marca como controlador REST
@RestController
// Define prefixo "/api/produtos" para todas as rotas
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    // Injeta o serviço de produtos
    private final ProdutoService produtoService;

    // Construtor com injeção de dependência
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Mapeia requisições GET para "/api/produtos"
    @GetMapping
    // Método para listar todos os produtos
    public List<Produto> listarProdutos() {
        // Chama serviço para buscar todos os produtos
        return produtoService.listarProdutos();
    }

    // Mapeia GET para "/api/produtos/{id}" onde {id} é variável
    @GetMapping("/{id}")
    // @PathVariable captura o {id} da URL
    public ResponseEntity<?> buscarProduto(@PathVariable Long id) {
        // Busca produto pelo ID através do serviço
        Produto produto = produtoService.buscarPorId(id);
        // Retorna produto encontrado com status 200
        return ResponseEntity.ok(produto);
    }

    // Mapeia requisições POST para "/api/produtos"
    @PostMapping
    // @RequestBody converte JSON da requisição em objeto Produto
    public Produto criarProduto(@RequestBody Produto produto) {
        // Salva produto através do serviço e retorna produto salvo
        return produtoService.salvarProduto(produto);
    }
    
    // Mapeia requisições DELETE para "/api/produtos/{id}"
    @DeleteMapping("/{id}")
    // Método para deletar produto por ID
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        // Chama serviço para deletar produto
        produtoService.deletarProduto(id);
        // Retorna status 204 (No Content) indicando sucesso sem corpo de resposta
        return ResponseEntity.noContent().build();
    }
}
