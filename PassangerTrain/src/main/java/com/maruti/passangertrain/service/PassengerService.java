package com.maruti.passangertrain.service;

import com.maruti.passangertrain.entity.Passanger;
import com.maruti.passangertrain.entity.Train;
import com.maruti.passangertrain.exception.ServiceException;

public interface PassengerService {

	Passanger insertPassenger(Passanger passanger);

	Passanger getPassenger(Long id) throws ServiceException;

	String removePasseneger(Long id) throws ServiceException;;

}
