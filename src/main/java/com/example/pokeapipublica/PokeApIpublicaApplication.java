package com.example.pokeapipublica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot para a PokeAPI pública.
 * Esta classe é responsável por iniciar a aplicação.
 */
@SpringBootApplication // Anotação que combina @Configuration, @EnableAutoConfiguration e @ComponentScan.
                       // Ela habilita a configuração automática do Spring Boot e a varredura de componentes.
public class PokeApIpublicaApplication {

	/**
	 * Método principal que inicia a aplicação Spring Boot.
	 * @param args Argumentos de linha de comando passados para a aplicação.
	 */
	public static void main(String[] args) {
		SpringApplication.run(PokeApIpublicaApplication.class, args);
	}

}


