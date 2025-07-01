package com.example.pokeapipublica.DTO;

import com.example.pokeapipublica.entity.Pokemon;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) para representar um Pokémon.
 * Utilizado para transferir dados de Pokémon entre camadas da aplicação.
 * Utiliza Lombok para gerar automaticamente getters e setters.
 */
@Getter // Gera automaticamente os métodos getters para todos os campos
@Setter // Gera automaticamente os métodos setters para todos os campos
public class PokemonDTO {

	private Long id; // ID do Pokémon
	private String nome; // Nome do Pokémon
	private String tipo; // Tipo do Pokémon
	private String habilidade; // Habilidade do Pokémon

	/**
	 * Construtor padrão.
	 */
	public PokemonDTO() {

	}

	/**
	 * Construtor que inicializa um PokemonDTO a partir de uma entidade Pokemon.
	 * @param entity A entidade Pokemon a ser convertida para DTO.
	 */
	public PokemonDTO(Pokemon entity) {

		id = entity.getId();
		nome = entity.getNome();
		tipo = entity.getTipo();
		habilidade = entity.getHabilidade();
	}

}


