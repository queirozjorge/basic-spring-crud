package br.com.jorge.dto.response;

import br.com.jorge.models.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {

	private long id;
	private int number;
	private String description;
	private String city;
	private String state;
	private String country;
	private long postalCode;
	
	public static AddressResponse createByEntity(Address entity) {
		return AddressResponse.builder()
				.id(entity.getId())
				.number(entity.getNumber())
				.description(entity.getDescription())
				.city(entity.getCity())
				.state(entity.getState())
				.country(entity.getCountry())
				.postalCode(entity.getPostalCode()).build();
	}
}
