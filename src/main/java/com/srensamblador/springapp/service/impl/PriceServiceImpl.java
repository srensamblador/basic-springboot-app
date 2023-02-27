package com.srensamblador.springapp.service.impl;

import java.util.Optional;

import com.srensamblador.springapp.service.impl.command.GetPriceByDateCommand;
import org.springframework.stereotype.Service;

import com.srensamblador.springapp.command.CommandExecutor;
import com.srensamblador.springapp.dto.PriceDTO;
import com.srensamblador.springapp.dto.PriceRequest;
import com.srensamblador.springapp.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{
	
	private CommandExecutor executor;
	
	private final GetPriceByDateCommand getPriceByDateCommand;
	
	
	/**
	 * Constructor que inyecta dependencias
	 * @param executor ejecutor de comandos
	 * @param getPriceByDateCommand comando que implementa la búsqueda de precio por fecha
	 */
	public PriceServiceImpl(final CommandExecutor executor, final GetPriceByDateCommand getPriceByDateCommand) {
		this.executor = executor;
		this.getPriceByDateCommand = getPriceByDateCommand;
	}


	@Override
	public Optional<PriceDTO> getPriceByDate(PriceRequest request) {
		return this.executor.execute(getPriceByDateCommand, request);
	}
	
	
	
	

}
