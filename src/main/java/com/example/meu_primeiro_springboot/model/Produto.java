package com.example.meu_primeiro_springboot.model;

// Importa anotações JPA para mapeamento objeto-relacional
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Marca esta classe como uma entidade JPA (representa uma tabela no banco)
@Entity
// Define o nome da tabela no banco de dados como "produtos"
@Table(name = "produtos")
public class Produto {

    // Marca este campo como chave primária da tabela
    @Id
    // Define que o ID será gerado automaticamente (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Campo para armazenar o nome do produto
    private String nome;
    // Campo para armazenar o preço do produto
    private Double preco;

    // Construtor padrão necessário para o JPA funcionar
    public Produto() {}

    // Construtor com parâmetros para criar um produto com nome e preço
    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    // Método getter para acessar o ID do produto
    public Long getId() {
        return id;
    }

    // Método getter para acessar o nome do produto
    public String getNome() {
        return nome;
    }

    // Método setter para modificar o nome do produto
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para acessar o preço do produto
    public Double getPreco() {
        return preco;
    }

    // Método setter para modificar o preço do produto
    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
