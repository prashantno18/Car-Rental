package com.demo.car.rental.wrapper;

import javax.validation.constraints.NotNull;

import com.demo.car.rental.entity.Car;
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
public class BookingDetails {
	
	@NotNull(message = "Car can not be null!")
	private Long carId;
	
	private Car car;
	
	@NotNull(message = "Date from can not be null!")
	private String beginning;

	@NotNull(message = "Date to can not be null!")
	private String end;

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getBeginning() {
		return beginning;
	}

	public void setBeginning(String beginning) {
		this.beginning = beginning;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "BookingDetails [carId=" + carId + ", car=" + car + ", beginning=" + beginning + ", end=" + end + "]";
	}


	
}
