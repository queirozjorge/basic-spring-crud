package br.com.jorge.controllers;

import java.util.List;

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

import br.com.jorge.dto.request.PersonRequest;
import br.com.jorge.dto.response.PersonResponse;
import br.com.jorge.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping("/find/{id}")
	private ResponseEntity<PersonResponse> find(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(service.find(id));
	}
	
	@PostMapping("/create")
	private ResponseEntity<PersonResponse> create(@RequestBody PersonRequest person) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(person));
	}
	
	@PutMapping("/update")
	private ResponseEntity<PersonResponse> update(@RequestBody PersonRequest person) {
		return ResponseEntity.ok(service.update(person));
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<Void> delete(@PathVariable(name = "id") String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/list")
	private ResponseEntity<List<PersonResponse>> list() {
		return ResponseEntity.ok(service.list());
	}
}
