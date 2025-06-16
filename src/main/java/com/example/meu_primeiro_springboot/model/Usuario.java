package com.example.meu_primeiro_springboot.model;

// Importa anotações JPA para mapeamento objeto-relacional
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Marca esta classe como uma entidade JPA (tabela no banco de dados)
@Entity
// Define o nome da tabela no banco de dados
@Table(name = "usuarios")
public class Usuario {
    
    // Marca este campo como chave primária
    @Id
    // Define que o ID será gerado automaticamente pelo banco (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Define que este campo deve ser único e não pode ser nulo
    @Column(unique = true, nullable = false)
    private String username;

    // Define que este campo não pode ser nulo
    @Column(nullable = false)
    private String password;

    // Construtor padrão necessário para o JPA
    public Usuario() {}

    // Construtor com parâmetros para criar um usuário com username e password
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Método getter para acessar o ID do usuário
    public Long getId() {
        return id;
    }

    // Método getter para acessar o username do usuário
    public String getUsername() {
        return username;
    }

    // Método getter para acessar a password do usuário
    public String getPassword() {
        return password;
    }

    // Método setter para modificar o username do usuário
    public void setUsername(String username) {
        this.username = username;
    }

    // Método setter para modificar a password do usuário
    public void setPassword(String password) {
        this.password = password;
    }
}
