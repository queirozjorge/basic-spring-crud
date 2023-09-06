package br.com.jorge.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

	private long id;
	private int number;
	private String description;
	private String city;
	private String state;
	private String country;
	private long postalCode;
	
}
