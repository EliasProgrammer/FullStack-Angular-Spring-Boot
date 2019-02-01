package com.workproject.algamoney.api.exceptionHandler;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardErro {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8495329944317601331L;
	
	private List<String> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String error, String menssage, String path) {
		super(status, error, menssage, path);
	}

	public List<String> getErrors() {
		return errors;
	}
	public void addError(String mensagem) {
		this.errors.add(mensagem);
	}
	
	

}
