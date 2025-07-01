package com.example.pokeapipublica.DTO;

import com.example.pokeapipublica.entity.Pokemon;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PokemonDTO {

	
	private Long id;
	private String nome;
	private String tipo;
	private String habilidade;

	public PokemonDTO() {

	}

	public PokemonDTO(Pokemon entity) {

		id = entity.getId();
		nome = entity.getNome();
		tipo = entity.getTipo();
		habilidade = entity.getHabilidade();
	}

}
