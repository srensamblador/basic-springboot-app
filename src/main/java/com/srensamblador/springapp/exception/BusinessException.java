package com.srensamblador.springapp.exception;

/**
 * Clase base de las excepciones de negocio
 * @author Samuel
 *
 */
public abstract class BusinessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	protected BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
	

}
