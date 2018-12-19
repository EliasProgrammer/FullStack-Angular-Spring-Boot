package com.workproject.algamoney.api.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardErro {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 8495329944317601331L;
	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String error, String menssage, String path) {
		super(status, error, menssage, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}
	public void addError(String campo, String mensagem) {
		this.errors.add(new FieldMessage(campo, mensagem));
	}
	
	

}
