package com.workproject.algamoney.api.utils;

import java.io.Serializable;
import java.util.Optional;

import com.workproject.algamoney.api.service.exception.ObjectNotFoundException;

/**
 * Classe de validações rotineiras
 * @author Elias
 */
public final class ValidationUtils implements Serializable {
	
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	public static <T> T validaNullObject(Optional<T> optional) {
		return optional.orElseThrow(() -> new ObjectNotFoundException());
	}
	
}
