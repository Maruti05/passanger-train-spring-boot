package com.maruti.passangertrain.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CompositePassenger implements Serializable {
	private Long id;
	
	private LocalDate dateOfJourny;
	
	private String bookingNumber;

	@Override
	public int hashCode() {
		return Objects.hash(bookingNumber, dateOfJourny, id);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositePassenger other = (CompositePassenger) obj;
		return Objects.equals(bookingNumber, other.bookingNumber) && Objects.equals(dateOfJourny, other.dateOfJourny)
				&& Objects.equals(id, other.id);
	}


	public CompositePassenger(Long id, LocalDate dateOfJourny) {
		super();
		this.id = id;
		this.dateOfJourny = dateOfJourny;
	}


	public CompositePassenger(Long id) {
		super();
		this.id = id;
	}
	
	
	
}
