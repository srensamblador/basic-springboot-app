package com.srensamblador.springapp.dto;

import java.time.LocalDateTime;

/**
 * Modela una petición de búsqueda de precios
 * @author Samuel
 *
 */
public record PriceRequest(Long brandId, Long productId, LocalDateTime date) {

}
