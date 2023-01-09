package com.demo.car.rental.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Car")
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class Car {

	@Id
	@Getter
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Getter
	@NotNull
	@JsonIgnore
	@Column(name = "Created", nullable = false)
	private LocalDateTime created = LocalDateTime.now();

	@Getter
	@NotNull
	@Length(min = 1, max = 100)
	@Column(name = "Model", nullable = false)
	private String model;

	@Getter
	@NonNull
	@Column(name = "Year", nullable = false)
	private Integer year;

	@Getter
	@Setter
	@DecimalMin(value = "0", message = "The price per hour can not be negative!")
	@Column(name = "Price_Per_Hour")
	private BigDecimal pricePerHour;

	@Getter
	@Setter
	@Column(name = "Status")
	private String status;

	@Getter
	@Setter
	@Column(name = "Available_From")
	private LocalDateTime availableFrom;

	@Getter
	@Setter
	@Column(name = "Available_To")
	private LocalDateTime availableTo;

	@Getter
	@OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
	private List<Booking> bookings;

	@JsonIgnore
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@JsonIgnore
	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public BigDecimal getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(BigDecimal pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getAvailableFrom() {
		return availableFrom;
	}

	public void setAvailableFrom(LocalDateTime availableFrom) {
		this.availableFrom = availableFrom;
	}

	public LocalDateTime getAvailableTo() {
		return availableTo;
	}

	public void setAvailableTo(LocalDateTime availableTo) {
		this.availableTo = availableTo;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", created=" + created + ", model=" + model + ", year=" + year + ", pricePerHour="
				+ pricePerHour + ", status=" + status + ", availableFrom=" + availableFrom + ", availableTo="
				+ availableTo + ", bookings=" + bookings + "]";
	}

}
