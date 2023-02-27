package com.srensamblador.springapp.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import com.srensamblador.springapp.dto.PriceDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.srensamblador.springapp.dto.PriceRequest;
import com.srensamblador.springapp.service.PriceService;

/**
 * Controlador de precios
 * @author Samuel
 *
 */
@RestController
@RequestMapping("/prices")
public class PriceController {
	
	private final PriceService service;
	
	public PriceController(final PriceService service) {
		this.service = service;		
	}
	
	/**
	 * Consulta el precio a aplicar a un producto en una fecha dada.
	 * @param brandId id de la marca del producto
	 * @param productId id del producto
	 * @param date fecha a consultar
	 * @return DTO con el precio, si hay uno a aplicar en esa fecha
	 */
	@GetMapping("")
	public ResponseEntity<PriceDTO> getPrice(@RequestParam("brand") Long brandId, @RequestParam("product") Long productId,
                                             @RequestParam("date") LocalDateTime date){
		final var request = new PriceRequest(brandId, productId, date);
		final Optional<PriceDTO> price = service.getPriceByDate(request);
		return ResponseEntity.of(price);
	}

}
