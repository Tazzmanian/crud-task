package sample.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	// Works
	public List<Person> findById(int id);

	// default
	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContaining(
			String firstName, String lastName, String date, String email, String phone);

	// Sort by last name
	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAsc(
			String firstName, String lastName, String date, String email, String phone);

	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDesc(
			String firstName, String lastName, String date, String email, String phone);

	// Sort by date
	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByBirthDateAsc(
			String firstName, String lastName, String date, String email, String phone);

	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByBirthDateDesc(
			String firstName, String lastName, String date, String email, String phone);

	// combined sort
	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAscBirthDateAsc(
			String firstName, String lastName, String date, String email, String phone);

	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameAscBirthDateDesc(
			String firstName, String lastName, String date, String email, String phone);

	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDescBirthDateAsc(
			String firstName, String lastName, String date, String email, String phone);

	public List<Person> findByFirstNameContainingOrLastNameContainingOrBirthDateContainingOrEmailContainingOrPhoneContainingOrderByLastNameDescBirthDateDesc(
			String firstName, String lastName, String date, String email, String phone);
}
