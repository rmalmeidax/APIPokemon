# PokeAPI Pública

Este projeto é uma aplicação Spring Boot que interage com a PokeAPI (https://pokeapi.co/) para buscar informações de Pokémons e também permite o gerenciamento (CRUD) de Pokémons em um banco de dados local.

## Estrutura do Projeto

O projeto segue a estrutura padrão de uma aplicação Spring Boot, organizada em pacotes que representam as diferentes camadas da aplicação:

- `com.example.pokeapipublica.DTO`: Contém os Data Transfer Objects (DTOs) para a comunicação entre as camadas e com a API externa.
- `com.example.pokeapipublica.config`: Classes de configuração da aplicação.
- `com.example.pokeapipublica.controller`: Controladores REST que expõem os endpoints da API.
- `com.example.pokeapipublica.entity`: Entidades JPA que representam as tabelas do banco de dados.
- `com.example.pokeapipublica.repository`: Interfaces de repositório para acesso aos dados, utilizando Spring Data JPA.
- `com.example.pokeapipublica.service`: Camada de serviço que contém a lógica de negócios da aplicação.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**: Framework para construção de aplicações Java.
- **Spring Data JPA**: Para persistência de dados e interação com o banco de dados.
- **Lombok**: Para reduzir o código boilerplate (getters, setters, construtores, etc.).
- **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
- **H2 Database**: Banco de dados em memória para desenvolvimento e testes (configurável).
- **RestTemplate**: Para consumir a PokeAPI externa.

## Como Rodar o Projeto

1.  **Pré-requisitos**:
    *   Java Development Kit (JDK) 17 ou superior instalado.
    *   Maven instalado.

2.  **Clonar o repositório**:

    ```bash
    git clone <URL_DO_REPOSITORIO>
    cd PokeAPIpublica
    ```

3.  **Compilar e Rodar**:

    Você pode compilar e rodar a aplicação usando Maven:
