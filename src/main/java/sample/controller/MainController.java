package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import sample.service.PersonService;

@Controller
public class MainController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
}