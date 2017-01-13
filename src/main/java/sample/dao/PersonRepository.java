package sample.dao;

import org.springframework.data.repository.CrudRepository;

import sample.model.Person;

public interface PersonRepository extends CrudRepository<Person, Integer>{
	
}
