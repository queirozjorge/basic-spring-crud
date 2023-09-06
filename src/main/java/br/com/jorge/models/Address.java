package br.com.jorge.models;

import br.com.jorge.dto.request.AddressRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private int number;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String country;
	
	@Column(name = "POSTAL_CODE", nullable = false, length = 8)
	private long postalCode;
	
	public static Address createByRequest(AddressRequest request) {
		return Address.builder()
				.id(request.getId())
				.number(request.getNumber())
				.description(request.getDescription())
				.city(request.getCity())
				.state(request.getState())
				.country(request.getCountry()).build();
	}
}
