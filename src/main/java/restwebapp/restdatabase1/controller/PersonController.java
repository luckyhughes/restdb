package restwebapp.restdatabase1.controller;

import java.util.List;

import restwebapp.restdatabase1.domain.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/person",method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getall() {
		System.out.println("getting person");

		List<Person> persons = (List<Person>) personRepository.findAll();
		
		ResponseEntity<List<Person>> responsetoSend = new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		return responsetoSend;
	}
	
	//   /person/anisha
	@RequestMapping(value = "/person/{personid}",method = RequestMethod.GET)
	public ResponseEntity<Person> getOne(@PathVariable("personid") Long pid){
		 
		Person person= personRepository.findOne(pid);
		
		
		ResponseEntity<Person> response = new ResponseEntity<Person>(person, HttpStatus.OK);
		return response;
		
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/person/search",method = RequestMethod.GET)
	public ResponseEntity<List<Person>> getlastname(@RequestParam(value="lastName", required=false) String lastName, @RequestParam(value="firstName", required=false) String firstName){
		 
		List<Person> person = null;
		System.out.println("names are: " + firstName + " , " + lastName);
		if(lastName!=null){
		person= personRepository.findByLastName(lastName);
		}
		else if(firstName!=null){
	    person= personRepository.findByfirstName(firstName);
		}
		else if(firstName!=null && lastName!=null){
	    //person= personRepository.findNames(firstName,lastName);
		}
		
		ResponseEntity<List<Person>> response = new ResponseEntity<List<Person>>(person, HttpStatus.OK);
		return response;
		
	}
	
	@RequestMapping("/greeting")
    public String greeting() {
        return "hello";
    }

}
