package com.srensamblador.springapp.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.srensamblador.springapp.configuration.MoneySerializer;

import lombok.Builder;
import lombok.Data;

/**
 * DTO para el precio de un producto
 *
 * @author Samuel
 */
@Data
@Builder
public class PriceDTO {

	/**
	 * Identificador del producto
	 */
	private Long product;

	/**
	 * Identificador de la marca del producto
	 */
	private Long brand;

	/**
	 * Tarifa a aplicar
	 */
	private Double rate;

	/**
	 * Fecha inicial del rango al cuál afecta el precio
	 */
	@JsonAlias("start_date")
	private LocalDateTime startDate;

	/**
	 * Fecha final del rango al cuál afecta el precio
	 */
	@JsonAlias("end_date")
	private LocalDateTime endDate;

	/**
	 * Precio a aplicar
	 */
	@JsonSerialize(using = MoneySerializer.class)
	private BigDecimal price;

}
