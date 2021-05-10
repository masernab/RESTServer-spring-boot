package com.example.demo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	
	//Instancia de personService, se hará inyeccion de dependencia en el contructor.
	private final PersonService personService;

	//Inyeccion de dependencia en el contructor.
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	/*RUTAS*/
	
	@PostMapping
	//@RequestBody toma un JSON que viene del cliente y lo convierte a Java
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPeople(){
		return personService.getPeople();
	}

	@GetMapping(path = "{id}")
	public ResponseEntity<Optional<Person>> getPersonById(@PathVariable("id") String id) {
		return personService.getPersonById(id);
	}

	@PutMapping(path = "{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable("id") String id,@RequestBody Person person) {
		return personService.updatePerson(id, person);
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") String id) {
		return personService.deletePerson(id);
	}	
}
