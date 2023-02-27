package com.srensamblador.springapp.dto;

import org.springframework.http.HttpStatus;

/**
 * DTO para una respuesta de error del servicio
 * @author Samuel
 *
 */
public record ErrorResponse(HttpStatus status, String message) {

}
