//package com.example.demo.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//import org.springframework.stereotype.Repository;
//
//import com.example.demo.model.Person;
//
////Dado un @Qualifier en PersonService sa sabe que se llama a este repository
//@Repository("fakePersonDao")
//public class FakePersonDataAccessService implements PersonDao{
//
//	//Una base de datos falsa de personas en memoria
//	public static List<Person> DBPersonas = new ArrayList<>();
//	
//	@Override
//	public Person addPerson(UUID id, Person person) {
//		Person newPerson = new Person(id, person.getName(), person.getAge()); 
//		DBPersonas.add(newPerson);
//		return newPerson;
//	}
//
//	@Override
//	public List<Person> getPeople() {
//		return DBPersonas;
//	}
//
//	@Override
//	public Optional<Person> getPersonById(UUID id) {
//		return DBPersonas.stream().filter(person -> person.getId().equals(id)).findFirst();
//	}
//
//	@Override
//	public int updatePerson(UUID id, Person person) {
//		Person personUpdated = new Person(id, person.getName(), person.getAge());
//		return getPersonById(id).map(persona -> {
//			int indexPerson = DBPersonas.indexOf(persona);
//			if(indexPerson >= 0) {
//				DBPersonas.set(indexPerson, personUpdated);	
//				return 1;
//			}else {
//				return 0;
//			}
//		}).orElse(0);
//	}
//
//	@Override
//	public String deletePerson(UUID id) {
//		return getPersonById(id).map(persona -> {
//			int indexPersona = DBPersonas.indexOf(persona);
//			if(indexPersona >= 0) {
//				DBPersonas.remove(indexPersona);	
//				return "Borrado";
//			}else {
//				return "Error";
//			}
//		}).orElse("Error");
//	}
//	
//	
//}
