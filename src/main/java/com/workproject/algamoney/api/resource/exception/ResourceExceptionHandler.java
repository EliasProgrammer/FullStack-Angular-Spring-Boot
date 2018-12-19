package com.workproject.algamoney.api.resource.exception;

import static com.workproject.algamoney.api.utils.DefaultMessages.ERRO_VALIDACAO;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.workproject.algamoney.api.service.exception.ObjectNotFoundException;

/**
 * Classe manipuladora de Exceções dos Recursos da Aplicação.
 * @author Elias
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	/**
	 * Manipula a exceção {@code ObjectNotFoundException} quando lançada
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardErro> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		return ResponseEntity.status(status).build();
	}
	
	/**
	 * Manipula a exceção {@code HttpMessageNotReadableException} quando lançada
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardErro> usuarioDuplicado(HttpMessageNotReadableException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardErro err = new StandardErro(status.value(), e.getMessage(),
				ERRO_VALIDACAO.getMensagem(), 
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	/**
	 * Manipula a exceção {@code MethodArgumentNotValidException} quando lançada
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErro> beanValidationRequest(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
				
		ValidationError err = new ValidationError(status.value(), status.getReasonPhrase(), ERRO_VALIDACAO.getMensagem(), request.getRequestURI());
		
		for(FieldError error : e.getBindingResult().getFieldErrors()) {
			err.addError(error.getField(), error.getDefaultMessage());
		}
		
		return ResponseEntity.status(status).body(err);
		
	}
	
	
	
}
