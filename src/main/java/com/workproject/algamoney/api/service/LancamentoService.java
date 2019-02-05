package com.workproject.algamoney.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workproject.algamoney.api.model.Lancamento;
import com.workproject.algamoney.api.model.Pessoa;
import com.workproject.algamoney.api.repository.LancamentoRepository;
import com.workproject.algamoney.api.repository.PessoaRepository;
import com.workproject.algamoney.api.repository.filter.LancamentoFilter;
import com.workproject.algamoney.api.service.exception.PessoaInativaOuInexistenteException;
import com.workproject.algamoney.api.utils.ValidationUtils;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repo; 
	
	@Autowired
	private PessoaRepository pessoaRepo;
	
	public List<Lancamento> pesquisar(LancamentoFilter lancamentoFilter){
		return repo.filtrar(lancamentoFilter);
	}

	public Lancamento listarPorId(Long codigo) {
		return ValidationUtils.validaNullObject(repo.findById(codigo));
	}

	public Lancamento criar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepo.findById(lancamento.getPessoa().getCodigo());
		
		if(pessoa.get() == null || pessoa.get().isInativo()) {
			throw new PessoaInativaOuInexistenteException();
		}
		return repo.save(lancamento);
	}

	public void delete(Long codigo) {
		Lancamento lancamento = listarPorId(codigo);
		repo.delete(lancamento);
	}

}
