package br.com.jorge.dto.request;

import br.com.jorge.models.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

	private long id;
	private long cpf;
	private String name;
	private int age;
	private Address address;
	
}
