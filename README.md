# 📘 README – Curso Spring Boot para Iniciantes

Este README resume os principais conteúdos aprendidos no vídeo **“CURSO GRATIS SPRING BOOT PARA INICIANTES | 2025”**.  
O vídeo apresenta um curso completo em Java com Spring Boot, ideal para iniciantes.

---

## 🎯 Objetivos do Curso

- Introduzir o **framework Spring Boot**: o que é e por que usá-lo.
- Ensinar a criar **aplicações web com CRUD completo**.
- Demonstrar práticas como **injeção de dependência**, **controllers**, **services**, **repositórios** e **exceções**.
- Cobrir configurações de **segurança (JWT)** e **persistência com banco de dados**.
- Mostrar como **estruturar e iniciar um projeto real**.

---

## 📋 Conteúdo Programático (marcos principais)

Conforme o vídeo, o curso aborda:

- ✅ **Introdução ao Spring Boot** – visão geral e benefícios.
- ✅ **Setup do projeto** – usando Spring Initializr (dependências como Web, JPA, H2/MySQL, etc.).
- ✅ **Criando estrutura básica** – `Application.java`, pacotes `controller`, `service`, `repository`, `model`.
- ✅ **Endpoints REST com @RestController** – `HelloController`, `ProdutoController`, etc.
- ✅ **Camada de serviço (Service)** – lógica de negócio isolada dos controladores.
- ✅ **Repositórios JPA** – interfaces para acesso a dados (`JpaRepository`).
- ✅ **Tratamento de exceções** – exceção customizada (`RecursoNaoEncontradoException`) e handler global (`@ControllerAdvice`).
- ✅ **Persistência com banco** – configuração de `application.properties`, uso de H2 ou outro DB.
- ✅ **Segurança com Spring Security e JWT** – filtros e utilitários de autenticação.
- ✅ **Testes unitários e integração** – classe de teste `MeuPrimeiroSpringbootApplicationTests`.

---

## ✅ Exemplos de funcionalidades incorporadas

- Endpoints **CRUD** para entidades como `Produto` e `Usuario`, com métodos HTTP (`GET`, `POST`, `PUT`, `DELETE`).
- **Autenticação JWT** – classes `JwtUtil`, `JwtAuthFilter` e configuração em `SecurityConfig`.
- **Tratamento global de erros** com respostas padronizadas de erro.
- **Injeção de dependência** – uso de `@Autowired` nos serviços e repositórios.
- **Testes automáticos** para garantir que a aplicação inicia corretamente.

---

## 👨‍🏫 O que você aprendeu

- **Padronização de projetos Spring Boot**.
- **Boas práticas**: divisão de lógica por camadas (MVC).
- Criação de **API REST segura e manutenível**.
- **Mapeamento objeto-relacional (ORM)** com JPA.
- **Autenticação JWT** no backend.
- Como **estruturar testes** e configuração da aplicação com Spring Boot.

---

## 💡 Como estruturar seu README

Abaixo está um exemplo de estrutura para esse repositório:

```bash
spring-boot-curso/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.example.meu_primeiro_springboot/
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── model/
│   │   │       ├── exceptions/
│   │   │       ├── security/
│   │   │       └── MeuPrimeiroSpringbootApplication.java
│   └── resources/
│       └── application.properties
│
├── test/
│   └── MeuPrimeiroSpringbootApplicationTests.java
│
├── pom.xml
└── README.md
