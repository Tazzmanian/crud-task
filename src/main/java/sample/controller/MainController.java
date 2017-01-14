package sample.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import sample.model.Person;
import sample.service.PersonService;

@Controller
public class MainController {

	@Autowired
	private PersonService personService;

	private String validateInput(Person person) {

		String errMsg = "";

		if (person.getFirstName() == null || !person.getFirstName().matches("[a-zA-Z]+")) {
			errMsg = errMsg + " First name,";
		}

		if (person.getLastName() == null || !person.getLastName().matches("[a-zA-Z]+")) {
			errMsg = errMsg + " Last name,";
		}

		if (person.getEmail() == null
				|| !person.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
			errMsg = errMsg + " Email,";
		}

		if (person.getPhone() == null || !person.getPhone().matches("[0-9]+")) {
			errMsg = errMsg + " Phone number,";
		}

		if (person.getBirthDate() == null
				|| !person.getBirthDate().toString().matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
			errMsg = errMsg + " Date of birth,";
		}

		if (errMsg.equals("")) {
			errMsg = "";
		} else {
			errMsg = "Error:" + errMsg;
		}

		return errMsg;
	}

	@GetMapping("/")
	public String home(HttpServletRequest request) {
		request.setAttribute("people", personService.findAll());
		request.setAttribute("mode", "ADD");
		return "index";
	}

	@GetMapping("/add")
	public String save(@ModelAttribute("person") Person person, BindingResult bindingResult,
			HttpServletRequest request) {
		String msg = validateInput(person);
		if (msg == "") {
			personService.save(person);
			request.setAttribute("errMsg", "Saved!!!");

		} else {
			request.setAttribute("errMsg", msg);
			request.setAttribute("person", person);
		}

		request.setAttribute("people", personService.findAll());
		request.setAttribute("mode", "ADD");
		return "index";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("person", personService.findPerson(id));
		request.setAttribute("mode", "EDIT");
		request.setAttribute("people", personService.findAll());
		return "index";
	}
}