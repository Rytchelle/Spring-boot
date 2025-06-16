package com.example.meu_primeiro_springboot.security;

// Importa classes para trabalhar com chaves de segurança
import java.security.Key;
// Importa classe Date para trabalhar com datas
import java.util.Date;

// Importa classes da biblioteca JWT
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// Classe utilitária para operações com JWT (JSON Web Token)
public class JwtUtil {

    // Gera uma chave secreta para assinar os tokens usando algoritmo HS256
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // Define tempo de expiração do token (24 horas em milissegundos)
    private static final long EXPIRATION_TIME = 86400000;

    // Método estático para gerar um token JWT
    public static String generateToken(String username) {
        return Jwts.builder() // Inicia construção do token
                .setSubject(username) // Define o "subject" (usuário) do token
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Define data de expiração
                .signWith(key, SignatureAlgorithm.HS256) // Assina token com chave e algoritmo
                .compact(); // Gera string final do token
    }

    // Método para extrair o username de um token JWT
    public static String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build() // Configura parser com chave
                    .parseClaimsJws(token).getBody().getSubject(); // Extrai subject (username)
    }

    // Método para validar se um token JWT é válido
    public static boolean validateToken(String token) {
        try {
            // Tenta fazer parse do token com a chave
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true; // Se não lançar exceção, token é válido
        }
        catch(JwtException e) {
            return false; // Se lançar exceção, token é inválido
        }
    }
}
