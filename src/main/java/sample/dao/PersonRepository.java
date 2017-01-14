package sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import sample.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	// Works
	public List<Person> findById(int id);
	
	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContaining(String firstName, String lastName, String date, String email, String phone);
	
}
