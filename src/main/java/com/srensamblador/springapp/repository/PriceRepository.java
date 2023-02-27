package com.srensamblador.springapp.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.srensamblador.springapp.model.Price;

/**
 * Repositorio de precios
 * @author Samuel
 *
 */
public interface PriceRepository extends JpaRepository<Price, Long>{
	
	/**
	 * Consulta el precio a aplicar dado un producto y fecha. En caso de haber varios precios para esa fecha, se toma aquél con prioridad más alta.
	 * @param brandId
	 * @param productId
	 * @param date
	 * @return
	 */
	@Query("FROM Price p WHERE p.product.id = :productId AND p.brand.id = :brandId AND :date between p.startDate AND p.endDate ORDER BY p.priority DESC LIMIT 1")
	public Optional<Price> findByProductAndDate(@Param("brandId") Long brandId,@Param("productId") Long productId,  @Param("date") LocalDateTime date);

}
