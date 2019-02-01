package com.workproject.algamoney.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workproject.algamoney.api.model.Lancamento;
import com.workproject.algamoney.api.repository.LancamentoRepository;
import com.workproject.algamoney.api.utils.ValidationUtils;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository repo;
	
	public List<Lancamento> listar(){
		return repo.findAll();
	}

	public Lancamento listarPorId(Long codigo) {
		return ValidationUtils.validaNullObject(repo.findById(codigo));
	}

	public Lancamento criar(Lancamento lancamento) {
		return repo.save(lancamento);
	}

}
