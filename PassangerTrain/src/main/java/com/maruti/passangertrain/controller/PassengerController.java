package com.maruti.passangertrain.controller;

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

import com.maruti.passangertrain.entity.Passanger;
import com.maruti.passangertrain.entity.Train;
import com.maruti.passangertrain.exception.AppException;
import com.maruti.passangertrain.exception.ServiceException;
import com.maruti.passangertrain.service.PassengerService;
import com.maruti.passangertrain.service.TrainService;

@RestController
@RequestMapping("api/v1/passenger")
public class PassengerController {

	private PassengerService passengerService;
	
	@Autowired
	public PassengerController(PassengerService passengerService) {
		this.passengerService = passengerService;
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertPassenger(@RequestBody Passanger passanger){
		return new ResponseEntity<Passanger>(passengerService.insertPassenger(passanger),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPassenger(@PathVariable Long id) throws AppException{
		return new ResponseEntity<Passanger>(passengerService.getPassenger(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> removePasseneger(@PathVariable Long id) throws AppException{
		return new ResponseEntity<String>(passengerService.removePasseneger(id),HttpStatus.OK);
	}
}
