package com.srensamblador.springapp.command;

import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

/**
 * Ejecuta comandos dentro de contexto transaccional
 * @author Samuel
 *
 */
@Component
public class TransactionalExecutor implements CommandExecutor{

	@Override
	@Transactional
	public <T, R> T execute(Command<T, R> command, R request) {
		return command.execute(request);
	}

}
