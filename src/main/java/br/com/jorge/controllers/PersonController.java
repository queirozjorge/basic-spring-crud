package br.com.jorge.controllers;

import java.util.List;

import br.com.jorge.config.RateLimiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.jorge.dto.request.PersonRequest;
import br.com.jorge.dto.response.PersonResponse;
import br.com.jorge.services.PersonService;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private RateLimiterService rateLimiterService;

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
	private ResponseEntity<Object> list() {
		if(rateLimiterService.accessApiEndpoint()) {
			return ResponseEntity.ok(service.list());
		} else {
			return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
					.body("Limite TPS atingindo. Tente novamente mais tarde.");
		}

	}
}
