package com.example.pokeapipublica.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pokeapipublica.DTO.PokemonApiResponseDTO;
import com.example.pokeapipublica.entity.Pokemon;
import com.example.pokeapipublica.repository.PokemonRepository;

@Service
public class PokemonService {

	private PokemonApiResponseDTO pokemonApiResponseDTO;
	private PokemonRepository pokemonRepository;
	private RestTemplate restTemplate;

	public PokemonService(PokemonRepository pokemonRepository, RestTemplate restTemplate) {

		this.pokemonRepository = pokemonRepository;
		this.restTemplate = restTemplate;
	}

	public PokemonApiResponseDTO getPokemonFromApi(String nome) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + nome.toLowerCase();
		Map<String, Object> response = restTemplate.getForObject(url, Map.class);

		PokemonApiResponseDTO dto = new PokemonApiResponseDTO();
		dto.setNome((String) response.get("name"));
		dto.setPeso((Number) response.get("weight"));
		dto.setAltura((Number) response.get("height"));

		List<Map<String, Object>> tipos = (List<Map<String, Object>>) response.get("types");
		List<String> nomesTipos = tipos.stream().map(t -> (Map<String, Object>) t.get("type"))
				.map(type -> (String) type.get("name")).toList();

		dto.setTipos(nomesTipos);
		return dto;

	}
	// Busca geral

	public List<Pokemon> findAll() {
		return pokemonRepository.findAll();
	}

	// Busca por Id

	public Pokemon findById(Long id) {
		return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("ID inexistente."));

	}

	// save/post

	public Pokemon save(Pokemon pokemon) {
		return pokemonRepository.save(pokemon);

	}

	public void deleteById(Long id) {
		pokemonRepository.deleteById(id);

	}

}
