package com.workproject.algamoney.api.utils;

import java.io.Serializable;

/**
 * Classe específica para mensagens de Bean Validation.
 * @author Elias
 *
 */
public abstract class BeanValidationMensagens implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -5938265034572274659L;
	
	public static final String NOT_NULL = "O campo não pode ser null";
	public static final String NOT_EMPTY = "O campo não pode ser vazio";
	public static final String EMAIL = "Não é um endereço de e-mail válido";

}
