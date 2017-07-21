package restwebapp.restdatabase1.controller;

import java.util.List;

import restwebapp.restdatabase1.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import restwebapp.restdatabase1.repository.PersonRepository;

@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value = "/person", method = RequestMethod.POST)
	public ResponseEntity<Person> save(@RequestBody Person person) {
		System.out.println("saving person" + person);
		personRepository.save(person);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "/person")
	public ResponseEntity<List<Person>> getall() {
		System.out.println("getting person");

		List<Person> persons = (List<Person>) personRepository.findAll();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
	
	@RequestMapping("/greeting")
    public String greeting() {
        return "hello";
    }

}
