package com.srensamblador.springapp.service;

import java.util.Optional;

import com.srensamblador.springapp.dto.PriceDTO;
import com.srensamblador.springapp.dto.PriceRequest;

/**
 * Servicio de precios
 * @author Samuel
 *
 */
public interface PriceService {
	
	
	/**
	 * Devuelve el precio para un producto y marca dada una fecha
	 * @param request objeto que modela la consulta
	 * @return opcional con el DTO del precio, si existe
	 */
	public Optional<PriceDTO> getPriceByDate(PriceRequest request);

}
