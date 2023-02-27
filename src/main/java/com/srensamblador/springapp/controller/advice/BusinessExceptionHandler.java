package com.srensamblador.springapp.controller.advice;

import com.srensamblador.springapp.dto.ErrorResponse;
import com.srensamblador.springapp.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Manejador de excepciones de negocio. Recoge las excepciones controladas de la aplicación y compone una respuesta de error.
 * @author Samuel
 *
 */
@ControllerAdvice
public class BusinessExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));

	}
}
