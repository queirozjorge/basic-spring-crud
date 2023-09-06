package br.com.jorge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jorge.dto.request.AddressRequest;
import br.com.jorge.dto.response.AddressResponse;
import br.com.jorge.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;
	
	@PostMapping("/find/{id}")
	private ResponseEntity<AddressResponse> find(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(service.find(id));
	}
	
	@PostMapping("/create")
	private ResponseEntity<AddressResponse> create(@RequestBody AddressRequest address) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.create(address));
	}
	
	@PostMapping("/update")
	private ResponseEntity<AddressResponse> update(@RequestBody AddressRequest address) {
		return ResponseEntity.ok(service.update(address));
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<Void> delete(@PathVariable(name = "id") String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/list")
	private ResponseEntity<List<AddressResponse>> list() {
		return ResponseEntity.ok(service.list());
	}
	
}
