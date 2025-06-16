package com.example.meu_primeiro_springboot.repository;

// Importa interface JpaRepository que fornece operações CRUD
import org.springframework.data.jpa.repository.JpaRepository;
// Importa anotação que marca esta interface como repositório
import org.springframework.stereotype.Repository;

// Importa a entidade Produto
import com.example.meu_primeiro_springboot.model.Produto;

// Marca esta interface como um repositório Spring
@Repository
// Estende JpaRepository para herdar operações CRUD básicas
// <Produto, Long> indica que trabalha com entidade Produto e chave primária Long
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Interface vazia - herda todos os métodos do JpaRepository:
    // save(), findAll(), findById(), deleteById(), etc.
}
