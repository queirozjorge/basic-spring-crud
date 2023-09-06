package br.com.jorge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jorge.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
