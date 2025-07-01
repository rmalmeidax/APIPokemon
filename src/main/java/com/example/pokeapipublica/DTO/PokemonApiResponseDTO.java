package com.example.pokeapipublica.DTO;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class PokemonApiResponseDTO {

	private String nome;
	private Number altura;
	private Number peso;
	private List<String> tipos;

}
