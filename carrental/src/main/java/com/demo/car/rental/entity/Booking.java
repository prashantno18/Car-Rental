package com.demo.car.rental.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "Booking")
@NoArgsConstructor
@ToString
public class Booking {


	public Booking(LocalDateTime beginningDateTime, LocalDateTime endDateTime, Car car) {
		this.beginning=beginningDateTime;
		this.end=endDateTime;
		this.car=car;
	}

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", insertable = false, updatable = false, nullable = false)
	private Long id;

	@Getter
	@NotNull
	@Column(name = "Created", nullable = false)
	private LocalDateTime created = LocalDateTime.now();

	@Getter
	@NotNull
	@NonNull
	@Column(name = "Date_From", nullable = false)
	private LocalDateTime beginning;

	@Getter
	@NonNull
	@Column(name = "Date_To", nullable = false)
	private LocalDateTime end;

	@Getter
	@NonNull
	@ManyToOne
	@JoinColumn(name = "Car_Id", nullable = false)
	private Car car;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getBeginning() {
		return beginning;
	}

	public void setBeginning(LocalDateTime beginning) {
		this.beginning = beginning;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", created=" + created + ", beginning=" + beginning + ", end=" + end + ", car="
				+ car + "]";
	}
	
}

