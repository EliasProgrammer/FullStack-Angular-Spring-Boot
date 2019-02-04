package com.workproject.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.workproject.algamoney.api.model.Lancamento;
import com.workproject.algamoney.api.repository.query.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery{
	
}
