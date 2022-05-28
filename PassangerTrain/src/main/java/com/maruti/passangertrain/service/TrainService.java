package com.maruti.passangertrain.service;

import java.time.LocalDate;
import java.util.List;

import com.maruti.passangertrain.entity.Train;
import com.maruti.passangertrain.exception.ServiceException;

public interface TrainService {

	Train insertTrain(Train train);

	List<Train> getAllTrains();

	String removeTrain(Long id) throws ServiceException;

	Train searchTrianById(Long id) throws ServiceException;

	Train assigneTrainToPassenger(Long trainId, LocalDate doj, Long passengerId) throws ServiceException;

}
