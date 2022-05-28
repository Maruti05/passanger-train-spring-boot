package com.maruti.passangertrain.exception.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maruti.passangertrain.dto.ErrorDto;
import com.maruti.passangertrain.exception.AppException;

@ControllerAdvice
public class GlobleExceptionHandler {
private static final Logger LOGGER=LoggerFactory.getLogger(GlobleExceptionHandler.class);
@ExceptionHandler
	public ResponseEntity<?> handleException(AppException ex,HttpServletRequest req){
		ErrorDto error=new ErrorDto();
		LOGGER.error(ex.getMessage());
		error.setError(ex.getLocalizedMessage());
		error.setHttpStatus(HttpStatus.NOT_FOUND);
		error.setTime_stamp(LocalDateTime.now());
		error.setCode(HttpStatus.NOT_FOUND.value());
		error.setPath(req.getRequestURI());
		return new ResponseEntity<ErrorDto>(error,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}

}
