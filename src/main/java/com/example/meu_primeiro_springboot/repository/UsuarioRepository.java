package com.example.meu_primeiro_springboot.repository;

// Importa Optional para lidar com valores que podem ser nulos
import java.util.Optional;

// Importa interface JpaRepository que fornece operações CRUD básicas
import org.springframework.data.jpa.repository.JpaRepository;
// Importa anotação que marca esta interface como um repositório
import org.springframework.stereotype.Repository;

// Importa a entidade Usuario
import com.example.meu_primeiro_springboot.model.Usuario;

// Marca esta interface como um repositório Spring
@Repository
// Estende JpaRepository fornecendo operações CRUD para Usuario
// <Usuario, Long> indica que trabalha com entidade Usuario e ID do tipo Long
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Método personalizado para buscar usuário por username
    // Spring Data JPA cria automaticamente a implementação baseada no nome do método
    // "findBy" + "Username" = SELECT * FROM usuarios WHERE username = ?
    Optional<Usuario> findByUsername(String username);
}
