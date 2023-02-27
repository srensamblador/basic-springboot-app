package com.srensamblador.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modela una marca de productos
 * @author Samuel
 *
 */
@Entity
@Table(name="BRAND")
@Data
@NoArgsConstructor
public class Brand {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
}
