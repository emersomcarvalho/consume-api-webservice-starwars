package com.testesw.br.projetodemo.model;

import java.util.List;

public class Planet {
	
	private String name;
	
	private List<String> films;
	
	public Planet() {
	}
	
	public Planet(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", films=" + films + "]";
	}
	
	

	
}
