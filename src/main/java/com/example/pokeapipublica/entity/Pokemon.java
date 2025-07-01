package com.example.pokeapipublica.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pokemon")
@Getter
@Setter
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String tipo;
	

	@Column(columnDefinition = "TEXT")
	private String habilidade;

	public Pokemon() {

	}

	public Pokemon(Long id, String nome, String tipo, String habilidade) {

		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.habilidade = habilidade;
	}

}
