package com.maruti.passangertrain.exception.custom;

import com.maruti.passangertrain.exception.ServiceException;

public class AlreadyBookedException extends ServiceException {

	public AlreadyBookedException() {
		// TODO Auto-generated constructor stub
	}

	public AlreadyBookedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AlreadyBookedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public AlreadyBookedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AlreadyBookedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
