package br.com.jorge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jorge.dto.request.PersonRequest;
import br.com.jorge.dto.response.PersonResponse;
import br.com.jorge.models.Person;
import br.com.jorge.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public PersonResponse find(String id) {
		return PersonResponse.createByEntity(personRepository.findById(Long.valueOf(id)).orElse(null));
	}
	
	public PersonResponse create(PersonRequest person) {
		return PersonResponse.createByEntity(personRepository.save(Person.createByRequest(person)));
	}
	
	public PersonResponse update(PersonRequest person) {
		return PersonResponse.createByEntity(personRepository.save(Person.createByRequest(person)));
	}
	
	public void delete(String id) {
		personRepository.deleteById(Long.valueOf(id));
	}
	
	public List<PersonResponse> list() {
		return personRepository.findAll().stream().map(PersonResponse::createByEntity).toList();
	}
	
}
