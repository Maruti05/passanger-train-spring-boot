package com.maruti.passangertrain.service.impl;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maruti.passangertrain.entity.CompositePassenger;
import com.maruti.passangertrain.entity.Passanger;
import com.maruti.passangertrain.entity.Train;
import com.maruti.passangertrain.exception.ServiceException;
import com.maruti.passangertrain.exception.custom.PassengerNotFoundException;
import com.maruti.passangertrain.repository.PassengerRepo;
import com.maruti.passangertrain.service.PassengerService;

@Service
public class PassengerServiceImpl implements PassengerService{
	
	private PassengerRepo passengerRepo;
	
	
	@Autowired
	public PassengerServiceImpl(PassengerRepo passengerRepo) {
		super();
		this.passengerRepo = passengerRepo;
	}



	@Override
	public Passanger insertPassenger(Passanger passanger) {
		passanger.setCompositePassenger(new CompositePassenger(UUID.randomUUID().getLeastSignificantBits(),LocalDate.now()));
		return passengerRepo.save(passanger);
	}



	@Override
	public Passanger getPassenger(Long id) throws ServiceException {
		
		return passengerRepo.findById(new CompositePassenger(id)).orElseThrow(()->new PassengerNotFoundException("Passenger Not found with Id: "+id));
	}



	@Override
	public String removePasseneger(Long id) throws ServiceException {
		if(!passengerRepo.existsById(new CompositePassenger(id)))
				throw new PassengerNotFoundException("Passenger Not found with Id: "+id);
		passengerRepo.deleteById(new CompositePassenger(id));
		return "Passenger removed succesfully";
	}

	

}
