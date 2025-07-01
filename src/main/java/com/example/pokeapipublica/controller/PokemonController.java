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

/**
 * Controlador REST para gerenciar operações relacionadas a Pokémons.
 * Expõe endpoints para CRUD de Pokémons e para buscar dados de uma API externa.
 */
@RestController // Indica que esta classe é um controlador REST, que lida com requisições HTTP.
@RequestMapping("/pokemon") // Define o caminho base para todos os endpoints neste controlador.
public class PokemonController {

	@Autowired // Injeta uma instância de PokemonService, gerenciada pelo Spring.
	private PokemonService pokemonService;
		
	/**
	 * Retorna uma lista de todos os Pokémons cadastrados.
	 * @return Uma lista de objetos Pokemon.
	 */
	@GetMapping // Mapeia requisições GET para /pokemon.
	public List<Pokemon> findAll() {
		return pokemonService.findAll();
	}

	/**
	 * Retorna um Pokémon específico pelo seu ID.
	 * @param id O ID do Pokémon a ser buscado.
	 * @return Um ResponseEntity contendo o Pokémon encontrado ou um status 404 se não encontrado.
	 */
	@GetMapping("/{id}") // Mapeia requisições GET para /pokemon/{id}.
	public ResponseEntity<Pokemon> findById(@PathVariable Long id) {
		Pokemon pokemon = pokemonService.findById(id); // Busca o Pokémon pelo ID.
		return ResponseEntity.ok(pokemon); // Retorna o Pokémon com status 200 OK.
	}

	/**
	 * Salva um novo Pokémon ou atualiza um existente.
	 * @param pokemon O objeto Pokémon a ser salvo.
	 * @return Um ResponseEntity contendo o Pokémon salvo e um status 201 Created.
	 */
	@PostMapping // Mapeia requisições POST para /pokemon.
	public ResponseEntity<Pokemon> save(@RequestBody Pokemon pokemon) {
		Pokemon newPokemon = pokemonService.save(pokemon); // Salva o Pokémon.
		return ResponseEntity.status(HttpStatus.CREATED).body(newPokemon); // Retorna o Pokémon salvo com status 201 Created.
	}

	/**
	 * Exclui um Pokémon pelo seu ID.
	 * @param id O ID do Pokémon a ser excluído.
	 * @return Um ResponseEntity com status 204 No Content após a exclusão.
	 */
	@DeleteMapping("/{id}") // Mapeia requisições DELETE para /pokemon/{id}.
	public ResponseEntity<Pokemon> deleteById(@PathVariable Long id) {
		pokemonService.deleteById(id); // Exclui o Pokémon pelo ID.
		return ResponseEntity.noContent().build(); // Retorna status 204 No Content.
	}

	/**
	 * Busca informações de um Pokémon em uma API externa (PokeAPI).
	 * @param nome O nome do Pokémon a ser buscado na API externa.
	 * @return Um ResponseEntity contendo o DTO com as informações do Pokémon ou um status 404 Not Found se não encontrado.
	 */
	@GetMapping("/external/{nome}") // Mapeia requisições GET para /pokemon/external/{nome}.
	public ResponseEntity<PokemonApiResponseDTO> buscarExterno(@PathVariable String nome) {
		try {
			PokemonApiResponseDTO response = pokemonService.getPokemonFromApi(nome); // Busca o Pokémon na API externa.
			return ResponseEntity.ok(response); // Retorna as informações do Pokémon com status 200 OK.
		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Em caso de erro (Pokémon não encontrado, por exemplo), retorna status 404 Not Found.

		}

	}

}


