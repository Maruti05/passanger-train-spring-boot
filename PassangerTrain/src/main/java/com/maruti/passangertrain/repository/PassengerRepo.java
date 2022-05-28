package com.maruti.passangertrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maruti.passangertrain.entity.CompositePassenger;
import com.maruti.passangertrain.entity.Passanger;

@Repository
public interface PassengerRepo extends JpaRepository<Passanger, CompositePassenger>{

}
