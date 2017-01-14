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
		for (Person person : personRepository.findAll()) {
			people.add(person);
		}
		return people;
	}

	public void save(Person person) {
		personRepository.save(person);
	}

	public Person findPerson(int id) {
		return personRepository.findOne(id);
	}

	public void delete(int id) {
		if (personRepository.exists(id)) {
			personRepository.delete(id);
		}
	}

	public List<Person> search(String str, String sortLastName, String sortDate) {
		// return personRepository.findById(Integer.parseInt(str));

		if (sortLastName.matches("asc") && sortDate.matches("non")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAsc(
							str, str, str, str, str);
		} else if (sortLastName.matches("des") && sortDate.matches("non")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDesc(
							str, str, str, str, str);
		} else if (sortLastName.matches("non") && sortDate.matches("asc")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByBirthDateAsc(
							str, str, str, str, str);
		} else if (sortLastName.matches("non") && sortDate.matches("des")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByBirthDateDesc(
							str, str, str, str, str);
		} else if (sortLastName.matches("asc") && sortDate.matches("asc")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAscBirthDateAsc(
							str, str, str, str, str);
		} else if (sortLastName.matches("asc") && sortDate.matches("des")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAscBirthDateDesc(
							str, str, str, str, str);
		} else if (sortLastName.matches("des") && sortDate.matches("asc")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDescBirthDateAsc(
							str, str, str, str, str);
		} else if (sortLastName.matches("des") && sortDate.matches("des")) {
			return personRepository
					.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDescBirthDateDesc(
							str, str, str, str, str);
		}

		return personRepository
				.findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContaining(
						str, str, str, str, str);
	}
}
