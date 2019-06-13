package com.testesw.br.projetodemo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testesw.br.projetodemo.service.SwapiService;

@RestController
public class ApiWebService {
	
	@Autowired
	private SwapiService swapiService;

    
    @RequestMapping(value = "/planets/{id}", method = RequestMethod.GET)
    public Object getPlanets(@PathVariable("id") String id) throws Exception {
    	return swapiService.getPlanets(id);
    }
    
    @RequestMapping(value = "/planets/nome", method = RequestMethod.GET)
    public Object getPlanet(@RequestBody String nome) throws Exception {
    	return swapiService.getStarWorsEntity(nome);
    }
    
  

}
