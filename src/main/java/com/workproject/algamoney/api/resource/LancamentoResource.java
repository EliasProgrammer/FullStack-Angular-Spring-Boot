package com.workproject.algamoney.api.resource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.workproject.algamoney.api.event.RecursoCriadoEvent;
import com.workproject.algamoney.api.exceptionHandler.StandardErro;
import com.workproject.algamoney.api.model.Lancamento;
import com.workproject.algamoney.api.repository.filter.LancamentoFilter;
import com.workproject.algamoney.api.service.LancamentoService;
import com.workproject.algamoney.api.service.exception.PessoaInativaOuInexistenteException;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoService service;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	public Page<Lancamento> pesquisar(LancamentoFilter lancamentoFilter, Pageable pageable){
		return service.pesquisar(lancamentoFilter, pageable);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> listarPorId(@PathVariable Long codigo){
		Lancamento lancamento = service.listarPorId(codigo);
		return ResponseEntity.ok(lancamento);
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> criar(@RequestBody @Valid Lancamento lancamento, HttpServletResponse response) throws MethodArgumentNotValidException{
		Lancamento lancamentoSalvo = service.criar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long codigo) {
		service.delete(codigo);
	}
	
	@ExceptionHandler(PessoaInativaOuInexistenteException.class)
	public ResponseEntity<StandardErro> handlePessoaInativaOuInexistenteException(
			PessoaInativaOuInexistenteException ex,
			HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		String mensagem = this.messageSource.getMessage("pessoa.inexistente.inativa", null, LocaleContextHolder.getLocale());
		
		StandardErro err = new StandardErro(status.value(), ExceptionUtils.getRootCauseMessage(ex), mensagem, request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

}
