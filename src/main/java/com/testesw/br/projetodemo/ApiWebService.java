package com.testesw.br.projetodemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.testesw.br.projetodemo.service.SwapiService;

@RestController
public class ApiWebService {
	
	@Autowired
	private SwapiService swapiService;

    @RequestMapping(value = "/api/planets", method = RequestMethod.GET)
            public  String getTesteBySimplePatch(){
        return "teste";
    }
    
    @RequestMapping(value = "/planets/{id}", method = RequestMethod.GET)
    public Object getPlanets(@PathVariable("id") String id) throws Exception {
    	return swapiService.getPlanets(id);
    }

    //"https://swapi.co/api/planets/1/
    
//    RestTemplate restTemplate = new RestTemplate();
//    
//    UriComponents uri = UriComponentsBuilder.newInstance()
//    		
//    		.scheme("https")
//    		.host("swapi.co")
//    		.path("/api")
//    		.queryParam("planets", "1")
//    		.build();
//    		
//    	
//    
//    		
//    		
//    ResponseEntity<StarWorsEntity>  entity =  restTemplate.getForEntity(uri.toString(), StarWorsEntity.class);
//    
    			

}
