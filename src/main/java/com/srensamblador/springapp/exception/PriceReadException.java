package com.srensamblador.springapp.exception;

/**
 * Excepción que representa un error de lectura de precios
 * @author Samuel
 *
 */
public class PriceReadException extends BusinessException{
	private static final long serialVersionUID = 1L;

	public PriceReadException(String message, Throwable cause) {
		super(message, cause);
	}

}
