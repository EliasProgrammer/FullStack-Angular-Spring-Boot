package com.workproject.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workproject.algamoney.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
