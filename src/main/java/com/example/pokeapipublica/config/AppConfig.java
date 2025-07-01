package com.example.pokeapipublica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Classe de configuração da aplicação Spring.
 * Define beans que serão utilizados em outras partes da aplicação.
 */
@Configuration // Indica que esta classe fornece beans de configuração para o contexto da aplicação Spring.
public class AppConfig {
	
	/**
	 * Cria e configura um bean RestTemplate.
	 * O RestTemplate é usado para fazer requisições HTTP para APIs RESTful.
	 * @return Uma instância de RestTemplate.
	 */
	@Bean // Indica que o método produz um bean a ser gerenciado pelo Spring.
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	

}


