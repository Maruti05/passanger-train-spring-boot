package com.maruti.passangertrain.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maruti.passangertrain.entity.Train;
import com.maruti.passangertrain.exception.AppException;
import com.maruti.passangertrain.exception.ServiceException;
import com.maruti.passangertrain.service.TrainService;

@RestController
@RequestMapping("api/v1/train")
public class TrainController {

	private TrainService trainService;
	
	@Autowired
	public TrainController(TrainService trainService) {
		this.trainService = trainService;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertTrain(@RequestBody Train train){
		return new ResponseEntity<Train>(trainService.insertTrain(train),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllTrains(){
		return new ResponseEntity<List<Train>>(trainService.getAllTrains(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeTrain(@PathVariable Long id) throws AppException{
		return new ResponseEntity<String>(trainService.removeTrain(id),HttpStatus.OK);
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<?> searchTrianById(@PathVariable Long id)throws AppException{
		return new ResponseEntity<Train>(trainService.searchTrianById(id),HttpStatus.OK);
	}
	
	@PostMapping("/assign/{trainId}/{doj}/{passengerId}")
	public ResponseEntity<?> assigneTrainToPassenger(@PathVariable Long trainId,@PathVariable LocalDate doj,@PathVariable Long passengerId )throws AppException{
		return new ResponseEntity<Train>(trainService.assigneTrainToPassenger(trainId,doj,passengerId),HttpStatus.OK);
	}
}
