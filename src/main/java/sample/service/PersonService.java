package sample.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import sample.dao.PersonRepository;
import sample.model.Person;

@Service
@Transactional
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> findAll() {
		List<Person> people = new ArrayList<>();
		for(Person person: personRepository.findAll()){
			people.add(person);
		}
		return people;
}
}
