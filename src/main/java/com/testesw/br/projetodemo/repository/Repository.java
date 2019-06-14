package com.testesw.br.projetodemo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.testesw.br.projetodemo.entity.StarWorsEntity;


public interface Repository extends MongoRepository<StarWorsEntity, Long>{

	
	StarWorsEntity findBy(Long id);



}
