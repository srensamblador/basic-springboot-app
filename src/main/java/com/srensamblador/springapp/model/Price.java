package com.srensamblador.springapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Modela un precio
 * @author Samuel
 *
 */
@Entity
@Table(name="Price")
@Data
@NoArgsConstructor
public class Price {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="START_DATE")
	private LocalDateTime startDate;
	
	@Column(name="END_DATE")
	private LocalDateTime endDate;
	
	private Short priority;
	
	private BigDecimal price;
	
	@Column(name="CURR")
	private Currency currency;
	
	@ManyToOne
	@JoinColumn(name="BRAND_ID", nullable=false)
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="PRICE_LIST", nullable=false)
	private PriceList priceList;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	private Product product;
}
