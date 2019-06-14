package com.testesw.br.projetodemo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testesw.br.projetodemo.entity.StarWorsEntity;
import com.testesw.br.projetodemo.repository.Repository;
import com.testesw.br.projetodemo.service.SwapiService;

@RestController
@RequestMapping("/contato")
public class ApiWebService {
	
	@Autowired
	private SwapiService swapiService;
	
	@Autowired
	private Repository repository;
	
    
    @RequestMapping(value = "/planets/{id}", method = RequestMethod.GET) // buscar swaip por is
    public Object getPlanets(@PathVariable("id") String id) throws Exception {
    	return swapiService.getPlanets(id);
    }
    
    @RequestMapping(value = "/planets/contato", method = RequestMethod.POST)				//add post
    public StarWorsEntity starAdd(@RequestBody StarWorsEntity contato) {
    	return repository.save(contato);
    }
    
    	@GetMapping														//add list
    	public List<StarWorsEntity> listar(){
    		return repository.findAll();
    	}

        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)				//add busca por id
        public ResponseEntity<StarWorsEntity> buscar(@PathVariable Long id){
        	StarWorsEntity contact = repository.findBy(id);
        	
        	if ( contact == null) {
        		
        		return ResponseEntity.notFound().build();
        	}
        	return ResponseEntity.ok(contact);
        }
    	
}

  


