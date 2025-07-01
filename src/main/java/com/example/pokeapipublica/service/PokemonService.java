package com.example.pokeapipublica.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.pokeapipublica.DTO.PokemonApiResponseDTO;
import com.example.pokeapipublica.entity.Pokemon;
import com.example.pokeapipublica.repository.PokemonRepository;

/**
 * Serviço responsável pela lógica de negócios relacionada a Pokémons.
 * Inclui operações de CRUD para Pokémons persistidos e busca de dados da PokeAPI externa.
 */
@Service // Indica que esta classe é um componente de serviço do Spring.
public class PokemonService {

	private PokemonApiResponseDTO pokemonApiResponseDTO; // Instância do DTO para a resposta da API de Pokémon.
	private PokemonRepository pokemonRepository; // Repositório para acesso aos dados de Pokémon no banco de dados.
	private RestTemplate restTemplate; // Cliente para fazer requisições HTTP a APIs RESTful.

	/**
	 * Construtor para injeção de dependências do repositório de Pokémon e do RestTemplate.
	 * @param pokemonRepository O repositório de Pokémon.
	 * @param restTemplate O RestTemplate para requisições HTTP.
	 */
	public PokemonService(PokemonRepository pokemonRepository, RestTemplate restTemplate) {

		this.pokemonRepository = pokemonRepository;
		this.restTemplate = restTemplate;
	}

	/**
	 * Busca informações de um Pokémon na PokeAPI externa.
	 * @param nome O nome do Pokémon a ser buscado.
	 * @return Um PokemonApiResponseDTO contendo os dados do Pokémon.
	 */
	public PokemonApiResponseDTO getPokemonFromApi(String nome) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + nome.toLowerCase(); // Constrói a URL da API.
		@SuppressWarnings("unchecked")
		Map<String, Object> response = restTemplate.getForObject(url, Map.class); // Faz a requisição e recebe a resposta como um mapa.

		PokemonApiResponseDTO dto = new PokemonApiResponseDTO(); // Cria um novo DTO.
		dto.setNome((String) response.get("name")); // Define o nome do Pokémon.
		dto.setPeso((Number) response.get("weight")); // Define o peso do Pokémon.
		dto.setAltura((Number) response.get("height")); // Define a altura do Pokémon.

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> tipos = (List<Map<String, Object>>) response.get("types"); // Obtém a lista de tipos.
		List<String> nomesTipos = tipos.stream().map(t -> (Map<String, Object>) t.get("type"))
				.map(type -> (String) type.get("name")).toList(); // Extrai os nomes dos tipos.

		dto.setTipos(nomesTipos); // Define os tipos do Pokémon.
		return dto; // Retorna o DTO preenchido.

	}
	
	/**
	 * Retorna uma lista de todos os Pokémons persistidos no banco de dados.
	 * @return Uma lista de objetos Pokemon.
	 */
	public List<Pokemon> findAll() {
		return pokemonRepository.findAll(); // Delega a busca ao repositório.
	}

	/**
	 * Busca um Pokémon persistido pelo seu ID.
	 * @param id O ID do Pokémon a ser buscado.
	 * @return O Pokémon encontrado.
	 * @throws RuntimeException se o ID não for encontrado.
	 */
	public Pokemon findById(Long id) {
		return pokemonRepository.findById(id).orElseThrow(() -> new RuntimeException("ID inexistente.")); // Busca pelo ID e lança exceção se não encontrar.

	}

	/**
	 * Salva um novo Pokémon ou atualiza um existente no banco de dados.
	 * @param pokemon O objeto Pokémon a ser salvo.
	 * @return O Pokémon salvo.
	 */
	public Pokemon save(Pokemon pokemon) {
		return pokemonRepository.save(pokemon); // Delega a operação de salvar ao repositório.

	}

	/**
	 * Exclui um Pokémon do banco de dados pelo seu ID.
	 * @param id O ID do Pokémon a ser excluído.
	 */
	public void deleteById(Long id) {
		pokemonRepository.deleteById(id); // Delega a operação de exclusão ao repositório.

	}

}


