package com.srensamblador.springapp.mapper;


import org.springframework.stereotype.Component;

import com.srensamblador.springapp.dto.PriceDTO;
import com.srensamblador.springapp.model.Price;


/**
 * Componente que transforma entidades {@link Price} a {@link PriceDTO}
 * @author Samuel
 *
 */
@Component
public class PriceMapper {
	
	public PriceDTO toDto(Price price) {
		var builder = PriceDTO.builder();
		builder
		.product(price.getId())
		.brand(price.getBrand().getId())
		.startDate(price.getStartDate())
		.endDate(price.getEndDate())
		.rate(price.getPriceList().getRate())
		.price(price.getPrice());
		
		
		return builder.build();
		
	}

}
