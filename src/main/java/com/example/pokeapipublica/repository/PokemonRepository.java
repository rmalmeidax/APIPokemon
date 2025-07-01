package com.example.pokeapipublica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pokeapipublica.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{

}
