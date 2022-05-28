package com.maruti.passangertrain.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Passanger {
	
	private String name;

	private Integer age;
	
	private String gender;
	
	private Double fairAmount;
	
	@EmbeddedId
	private CompositePassenger compositePassenger;
	
	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "passengers",cascade = CascadeType.ALL)
	private Set<Train> trains;

}
