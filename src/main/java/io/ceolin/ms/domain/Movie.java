package io.ceolin.ms.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import reactor.util.annotation.NonNull;

@Document(collection = "movies")
public class Movie {

	@Id
	private String id;

	@NonNull
	private String nome;

	@NonNull
	private String autor;

	public Movie(String id, String nome, String autor) {
		this.id = id;
		this.nome = nome;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
