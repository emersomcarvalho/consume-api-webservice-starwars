package com.testesw.br.projetodemo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping(value= "/contato")
public class ApiWebService {
	
	@Autowired
	private SwapiService swapiService;
	
	@Autowired
	private Repository repository;
	
	// buscar swaipi por id
    @RequestMapping(value = "/planets/{id}", method = RequestMethod.GET) 
    public Object getPlanets(@PathVariable("id") String id) throws Exception {
    	return swapiService.getPlanets(id);
    }
    
    //add post
    @RequestMapping(value = "", method = RequestMethod.POST)			
    public StarWorsEntity starAdd(@RequestBody StarWorsEntity contato) {
    	return repository.save(contato);
    }
    
    //add list
   	@GetMapping														
    public List<StarWorsEntity> planets(){
    	return repository.findAll();
    	}
   	
     // buscar por id
     @GetMapping("/{id}")				
      public ResponseEntity<StarWorsEntity> search(@PathVariable long id){
       StarWorsEntity contact = repository.findById(id);
        	
        	if ( contact == null) {
        		
        		return ResponseEntity.notFound().build();
        	}
        	
        	return ResponseEntity.ok(contact);
        }
     //delete id
     @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
     public void delete(@PathVariable("id") Long id) { 
        repository.deleteById(id);
    	
    	
     	
     }
}



