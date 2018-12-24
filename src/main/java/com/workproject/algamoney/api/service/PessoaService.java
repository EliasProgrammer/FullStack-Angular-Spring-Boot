package com.workproject.algamoney.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workproject.algamoney.api.model.Pessoa;
import com.workproject.algamoney.api.repository.PessoaRepository;
import com.workproject.algamoney.api.service.exception.ObjectNotFoundException;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;

	public Pessoa criar(Pessoa pessoa) {
		return repo.save(pessoa);
	}

	public Pessoa findById(Long codigo) {
		Optional<Pessoa> pessoa = repo.findById(codigo);
		return pessoa.orElseThrow(() -> new ObjectNotFoundException());
	}

	public void delete(Long codigo) {
		repo.deleteById(codigo);
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}
	
	

}
