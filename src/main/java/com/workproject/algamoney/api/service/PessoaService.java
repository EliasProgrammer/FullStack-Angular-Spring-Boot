package com.workproject.algamoney.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workproject.algamoney.api.model.Pessoa;
import com.workproject.algamoney.api.repository.PessoaRepository;
import com.workproject.algamoney.api.utils.ValidationUtils;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;

	public Pessoa criar(Pessoa pessoa) {
		return repo.save(pessoa);
	}

	public Pessoa findById(Long codigo) {
		Optional<Pessoa> pessoa = repo.findById(codigo);
		return ValidationUtils.validaNullObject(pessoa);
	}

	public void delete(Long codigo) {
		repo.deleteById(codigo);
	}

	public List<Pessoa> findAll() {
		return repo.findAll();
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoa(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		return repo.save(pessoaSalva);
	}

	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoa(codigo);
		pessoaSalva.setAtivo(ativo);
		repo.save(pessoaSalva);
	}
	
	private Pessoa buscarPessoa(Long codigo) {
		return ValidationUtils.validaNullObject(repo.findById(codigo));
	}
	
	

}
