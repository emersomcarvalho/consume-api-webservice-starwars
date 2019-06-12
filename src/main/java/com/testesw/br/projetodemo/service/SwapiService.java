package com.testesw.br.projetodemo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testesw.br.projetodemo.model.Planet;

@Service
public class SwapiService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${swapi.endpoint:}")
	private String endpoint;
	
	public List<Planet> getPlanets(String id) throws Exception {
		System.out.println("Buscando planetas.");
		
		String response = restTemplate.getForObject(endpoint + "/planets", String.class);
		System.out.println("SWAPI Response: " + response);
		
		ResponseEntity<Planet> planet = restTemplate.getForEntity(endpoint + "/planets/" + id , Planet.class);
		System.out.println("planeta 1 ==== " + new ObjectMapper().writeValueAsString(planet.getBody()));
		
		
		return Arrays.asList(planet.getBody());
	}
}
