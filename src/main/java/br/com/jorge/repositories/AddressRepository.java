package br.com.jorge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jorge.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
