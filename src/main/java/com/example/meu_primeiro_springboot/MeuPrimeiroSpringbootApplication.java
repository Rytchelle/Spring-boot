package com.example.meu_primeiro_springboot;

// Importa a classe SpringApplication para inicializar a aplicação Spring Boot
import org.springframework.boot.SpringApplication;
// Importa a anotação que marca esta classe como uma aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotação que marca esta classe como o ponto de entrada da aplicação Spring Boot
// Combina @Configuration, @EnableAutoConfiguration e @ComponentScan
@SpringBootApplication
public class MeuPrimeiroSpringbootApplication {

	// Método principal que inicia a aplicação Spring Boot
	public static void main(String[] args) {
		// Executa a aplicação Spring Boot passando a classe principal e os argumentos
		SpringApplication.run(MeuPrimeiroSpringbootApplication.class, args);
	}

}
