package com.demo.car.rental.wrapper;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDetails {

	private Long id;

	private String created;

	@NotBlank(message = "Plate number can not be blank or null!")
	private String plateNumber;

	@NotBlank(message = "Car model can not be blank or null!")
	private String model;

	@Min(value = 1950, message = "Car year cannot be before 1950 ")
	@NotNull(message = "Car year can not be blank or null!")
	private Integer year;

	private BigDecimal pricePerHour;

	private String availabeFrom;

	private String availabeTo;

	public CarDetails(@NotBlank(message = "Plate number can not be blank or null!") String plateNumber,
			@NotBlank(message = "Car model can not be blank or null!") String model,
			@Min(value = 1950, message = "Car year cannot be before 1950 ") @NotNull(message = "Car year can not be blank or null!") Integer year,
			BigDecimal pricePerHour, String availabeFrom, String availabeTo) {
		super();
		this.plateNumber = plateNumber;
		this.model = model;
		this.year = year;
		this.pricePerHour = pricePerHour;
		this.availabeFrom = availabeFrom;
		this.availabeTo = availabeTo;
	}
	
	
	
	
}