package com.maruti.passangertrain.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maruti.passangertrain.entity.CompositePassenger;
import com.maruti.passangertrain.entity.Passanger;
import com.maruti.passangertrain.entity.Train;
import com.maruti.passangertrain.exception.ServiceException;
import com.maruti.passangertrain.exception.custom.AlreadyBookedException;
import com.maruti.passangertrain.exception.custom.PassengerNotFoundException;
import com.maruti.passangertrain.exception.custom.TrainNotFoundException;
import com.maruti.passangertrain.repository.PassengerRepo;
import com.maruti.passangertrain.repository.TrainRepo;
import com.maruti.passangertrain.service.TrainService;
@Transactional
@Service
public class TrainServiceImpl implements TrainService{
	
	private TrainRepo triRepo;
	
	private PassengerRepo passengerRepo;
	
	@Autowired
	public TrainServiceImpl(TrainRepo triRepo,PassengerRepo passengerRepo) {
		this.triRepo = triRepo;
		this.passengerRepo = passengerRepo;
	}

	

	@Override
	public List<Train> getAllTrains() {
		return triRepo.findAll();
	}



	@Override
	public Train insertTrain(Train train) {
		return triRepo.save(train);
	}



	@Override
	public String removeTrain(Long id) throws ServiceException {
		if(!triRepo.existsById(id))
			throw new ServiceException("Train entity with id "+id+ " exists!");
			triRepo.deleteById(id);
		return "Succesfully deleted";
	}



	@Override
	public Train searchTrianById(Long id) throws ServiceException {
		return triRepo.findById(id).orElseThrow(()->new TrainNotFoundException("Train is not present with ID "+id));
	}



	@Override
	public Train assigneTrainToPassenger(Long trainId, LocalDate doj, Long passengerId) throws ServiceException {
		Train train=triRepo.findById(trainId).orElseThrow(()->new TrainNotFoundException("Train is not present with ID "+trainId));
		Passanger passanger=passengerRepo.findById(new CompositePassenger(passengerId,doj)).orElseThrow(()->new PassengerNotFoundException("Passenger Not found with Id: "+passengerId));
		boolean isAlreadyBooked=passanger.getCompositePassenger().getDateOfJourny().compareTo(doj)==0&&passanger.getFairAmount()!=0;
		if(isAlreadyBooked) throw new AlreadyBookedException("Same Day can`t book two trains");
		passanger.setFairAmount(train.getDistance()*500);
		train.getPassengers().add(passanger);
		passengerRepo.save(passanger);
		return triRepo.save(train);
	}

}
