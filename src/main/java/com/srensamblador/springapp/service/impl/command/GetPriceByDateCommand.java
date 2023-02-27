package com.srensamblador.springapp.service.impl.command;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.srensamblador.springapp.command.Command;
import com.srensamblador.springapp.dto.PriceDTO;
import com.srensamblador.springapp.dto.PriceRequest;
import com.srensamblador.springapp.exception.PriceReadException;
import com.srensamblador.springapp.mapper.PriceMapper;
import com.srensamblador.springapp.model.Price;
import com.srensamblador.springapp.repository.PriceRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GetPriceByDateCommand implements Command<Optional<PriceDTO>, PriceRequest> {

	private final PriceRepository repository;
	private final PriceMapper mapper;

	/**
	 * Constructor que inyecta el repositorio
	 * 
	 * @param repository repositorio de precios
	 */
	public GetPriceByDateCommand(final PriceRepository repository, final PriceMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Optional<PriceDTO> execute(PriceRequest request) {
		try {
			final Optional<Price> price = repository.findByProductAndDate(request.brandId(), request.productId(),
					request.date());
			return price.map(mapper::toDto);
		} catch (DataAccessException e) {
			final var errorMessage = "An error has occurred fetching the prices";
			log.error(errorMessage);
			throw new PriceReadException(errorMessage, e);
		}
	}

}
