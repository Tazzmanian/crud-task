package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.service.PersonService;

@RestController
public class SampleRestController {

	@Autowired
	private PersonService personService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello World Sample rest controller";
	}

	@GetMapping("/people")
	private String allTasks() {
		return personService.findAll().toString();
	}
}