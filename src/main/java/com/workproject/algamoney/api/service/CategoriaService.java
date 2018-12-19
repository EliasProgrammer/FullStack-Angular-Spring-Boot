package com.workproject.algamoney.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workproject.algamoney.api.model.Categoria;
import com.workproject.algamoney.api.repository.CategoriaRepository;
import com.workproject.algamoney.api.service.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public List<Categoria> findAll() {
		return repo.findAll();
	}

	public Categoria save(Categoria categoria) {
		return repo.save(categoria);
	}

	public Categoria findById(Long codigo) {
		Optional<Categoria> usr = repo.findById(codigo);
		return usr.orElseThrow(() -> new ObjectNotFoundException());
	}
}
