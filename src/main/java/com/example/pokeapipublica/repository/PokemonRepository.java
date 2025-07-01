package com.example.pokeapipublica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pokeapipublica.entity.Pokemon;

/**
 * Interface de repositório para a entidade Pokemon.
 * Estende JpaRepository para fornecer operações CRUD básicas e funcionalidades de paginação e ordenação
 * para a entidade Pokemon, com o tipo da chave primária sendo Long.
 */
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}


