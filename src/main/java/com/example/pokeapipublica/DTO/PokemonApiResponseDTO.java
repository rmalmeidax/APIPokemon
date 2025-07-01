package com.example.pokeapipublica.DTO;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) para representar a resposta da API de Pokémon.
 * Utiliza Lombok para gerar automaticamente getters, setters e construtor com argumentos obrigatórios.
 */
@RequiredArgsConstructor // Gera um construtor com argumentos para campos final e @NonNull
@Getter // Gera automaticamente os métodos getters para todos os campos
@Setter // Gera automaticamente os métodos setters para todos os campos
public class PokemonApiResponseDTO {

	private String nome; // Nome do Pokémon
	private Number altura; // Altura do Pokémon
	private Number peso; // Peso do Pokémon
	private List<String> tipos; // Lista de tipos do Pokémon

}


