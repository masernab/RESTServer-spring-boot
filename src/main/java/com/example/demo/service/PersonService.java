package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service
public class PersonService {

	// PersonDao es una interfaz
	private final PersonDao personDao;

	// para inyeccion de dependencia en el constructor
	@Autowired
	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}

	public ResponseEntity<Person> addPerson(Person person) {
		try {
			Person newPerson = personDao.save(person);
			return new ResponseEntity<Person>(newPerson, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<List<Person>> getPeople() {
		try {
			List<Person> people = personDao.findAll();
			return new ResponseEntity<List<Person>>(people, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Optional<Person>> getPersonById(String id) {
		try {
			Optional<Person> person = personDao.findById(id);
			if (person.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Person> updatePerson(String id, Person person) {
		try {
			Optional<Person> personData = personDao.findById(id);
			if (personData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				Person personUpdated = personDao.save(new Person(id, person.getName(), person.getLastName(),
						person.getAge(), person.getCedula(), person.getPhone()));
				return new ResponseEntity<Person>(personUpdated, HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<HttpStatus> deletePerson(String id) {
		try {
			Optional<Person> personData = personDao.findById(id);
			if (personData.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} else {
				personDao.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
