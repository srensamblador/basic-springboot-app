package com.srensamblador.springapp.command;


/**
 * Interfaz para implementar ejecutores de comandos
 * @author Samuel
 *
 */
public interface CommandExecutor {
	
	/**
	 * Ejecuta un comando
	 * @param <T> tipo de retorno del comando
	 * @param <R> tipo de los parámetros del execute() del comando
	 * @param command comando a ejecutar
	 * @param request parámetro a pasar al comando
	 * @return resultado de la ejecución del comando
	 */
	public <T, R> T execute(Command<T, R> command, R request);

}
