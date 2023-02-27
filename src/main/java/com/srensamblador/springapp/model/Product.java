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
 * Modela un producto
 * 
 * @author Samuel
 *
 */
@Entity
@Table(name="Product")
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="product")
	private Set<Price> prices;
	
}
