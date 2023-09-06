package br.com.jorge.dto.response;

import br.com.jorge.models.Address;
import br.com.jorge.models.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

	private long id;
	private long cpf;
	private String name;
	private int age;
	private Address address;
	
	public static PersonResponse createByEntity(Person entity) {
		return PersonResponse.builder()
				.id(entity.getId())
				.cpf(entity.getCpf())
				.name(entity.getName())
				.age(entity.getAge())
				.address(entity.getAddress()).build();
	}
}
