package com.workproject.algamoney.api.service.exception;

/**
 * Classe de erro padrão para quando não for encontrado o objeto no banco. 
 * @author Elias
 */
public class ObjectNotFoundException extends RuntimeException {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException() {
		super();
	}

}
