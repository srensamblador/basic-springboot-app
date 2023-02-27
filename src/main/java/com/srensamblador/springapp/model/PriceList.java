package com.srensamblador.springapp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modela una tarifa aplicable a los precios
 * @author Samuel
 *
 */
@Entity
@Table(name="PRICE_LIST")
@Data
@NoArgsConstructor
public class PriceList {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Double rate;
	
	@OneToMany(mappedBy="priceList")
	private Set<Price> prices;
	
	
	

}
