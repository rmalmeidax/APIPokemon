package com.example.pokeapipublica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa a entidade Pokémon no banco de dados.
 * Utiliza JPA para mapeamento objeto-relacional e Lombok para geração automática de getters e setters.
 */
@Entity // Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
@Table(name = "pokemon") // Especifica o nome da tabela no banco de dados.
@Getter // Gera automaticamente os métodos getters para todos os campos.
@Setter // Gera automaticamente os métodos setters para todos os campos.
public class Pokemon {

	@Id // Indica que este campo é a chave primária da entidade.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática de valores para a chave primária.
	private Long id; // ID único do Pokémon.
	private String nome; // Nome do Pokémon.
	private String tipo; // Tipo do Pokémon.
	

	@Column(columnDefinition = "TEXT") // Define a coluna 'habilidade' como tipo TEXT no banco de dados.
	private String habilidade; // Habilidade do Pokémon.

	/**
	 * Construtor padrão.
	 */
	public Pokemon() {

	}

	/**
	 * Construtor para criar uma nova instância de Pokémon com todos os atributos.
	 * @param id O ID do Pokémon.
	 * @param nome O nome do Pokémon.
	 * @param tipo O tipo do Pokémon.
	 * @param habilidade A habilidade do Pokémon.
	 */
	public Pokemon(Long id, String nome, String tipo, String habilidade) {

		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.habilidade = habilidade;
	}

}


