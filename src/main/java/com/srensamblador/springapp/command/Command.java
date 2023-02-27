package com.srensamblador.springapp.command;

/**
 * Interfaz para implementar comandos
 * 
 * @author Samuel
 *
 * @param <T> tipo del retorno de la ejecución del comando
 * @param <R> tipo de los parámetros que se le pasan en ejecución
 */
public interface Command<T, R> {
	
	/**
	 * Ejecuta la implementación del comando
	 * @param request parámetro que necesita el comando en tiempo de ejecución
	 * @return resultado de su ejecución
	 */
	public T execute(R request);

}
