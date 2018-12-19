package com.workproject.algamoney.api.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workproject.algamoney.api.model.Pessoa;
import com.workproject.algamoney.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;

	public Pessoa criar(Pessoa pessoa) {
		return repo.save(pessoa);
	}
	
	

}
