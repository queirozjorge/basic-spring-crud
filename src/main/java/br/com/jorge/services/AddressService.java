package br.com.jorge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jorge.dto.request.AddressRequest;
import br.com.jorge.dto.response.AddressResponse;
import br.com.jorge.models.Address;
import br.com.jorge.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public AddressResponse find(String id) {
		return AddressResponse.createByEntity(addressRepository.findById(Long.valueOf(id)).orElse(null));
	}
	
	public AddressResponse create(AddressRequest address) {
		return AddressResponse.createByEntity(addressRepository.save(Address.createByRequest(address)));
	}
	
	public AddressResponse update(AddressRequest address) {
		return AddressResponse.createByEntity(addressRepository.save(Address.createByRequest(address)));
	}
	
	public void delete(String id) {
		addressRepository.deleteById(Long.valueOf(id));
	}
	
	public List<AddressResponse> list() {
		return addressRepository.findAll().stream().map(AddressResponse::createByEntity).toList();
	}
	
}
