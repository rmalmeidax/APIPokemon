package com.example.pokeapipublica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokeapipublica.DTO.PokemonApiResponseDTO;
import com.example.pokeapipublica.entity.Pokemon;
import com.example.pokeapipublica.service.PokemonService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;
		
	@GetMapping
	public List<Pokemon> findAll() {
		return pokemonService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pokemon> findById(@PathVariable Long id) {
		Pokemon pokemon = pokemonService.findById(id);
		return ResponseEntity.ok(pokemon);
	}

	@PostMapping
	public ResponseEntity<Pokemon> save(@RequestBody Pokemon pokemon) {
		Pokemon newPokemon = pokemonService.save(pokemon);
		return ResponseEntity.status(HttpStatus.CREATED).body(newPokemon);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pokemon> deleteById(@PathVariable Long id) {
		pokemonService.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/external/{nome}")

	public ResponseEntity<PokemonApiResponseDTO> buscarExterno(@PathVariable String nome) {
		try {
			PokemonApiResponseDTO response = pokemonService.getPokemonFromApi(nome);
			return ResponseEntity.ok(response);
		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

}
