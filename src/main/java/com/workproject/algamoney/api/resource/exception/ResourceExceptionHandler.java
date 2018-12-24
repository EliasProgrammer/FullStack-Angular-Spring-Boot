package com.workproject.algamoney.api.resource.exception;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.EmptyResultDataAccessException;
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
 * 
 * @author Elias
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	private String mensagemCampoInvalido;
	
	@PostConstruct
	public void init() {
		this.mensagemCampoInvalido = this.messageSource.getMessage("campos.invalidos.request", null, LocaleContextHolder.getLocale());
	}

	/**
	 * Manipula a exceção {@code ObjectNotFoundException, EmptyResultDataAccessException} quando lançada
	 */
	@ExceptionHandler({ObjectNotFoundException.class, EmptyResultDataAccessException.class})
	public ResponseEntity<StandardErro> objectNotFound(RuntimeException e,  HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		return ResponseEntity.status(status).build();
	}

	/**
	 * Manipula a exceção {@code HttpMessageNotReadableException} quando lançada
	 * 
	 * @param e
	 * @param request
	 * @return
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<StandardErro> usuarioDuplicado(HttpMessageNotReadableException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		return standardErroReturn(e, request, status, this.mensagemCampoInvalido);
	}

	/**
	 * Manipula a exceção {@code MethodArgumentNotValidException} quando lançada
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErro> beanValidationRequest(MethodArgumentNotValidException e,
			HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;

		ValidationError err = new ValidationError(status.value(), status.getReasonPhrase(),
				this.mensagemCampoInvalido, request.getRequestURI());

		for (FieldError error : e.getBindingResult().getFieldErrors()) {
			err.addError(messageSource.getMessage(error, LocaleContextHolder.getLocale()));
		}

		return ResponseEntity.status(status).body(err);
	}
	
	/**
	 * Método cria Erro padrão de retorno.
	 * @param e
	 * @param request
	 * @param status
	 * @param mensagem
	 * @return
	 */
	private ResponseEntity<StandardErro> standardErroReturn(HttpMessageNotReadableException e, HttpServletRequest request,
			HttpStatus status, String mensagem) {
		StandardErro err = new StandardErro(status.value(), e.getMessage(), mensagem, request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	

}
