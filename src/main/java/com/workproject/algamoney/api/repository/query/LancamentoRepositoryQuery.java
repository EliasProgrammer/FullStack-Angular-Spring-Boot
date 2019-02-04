package com.workproject.algamoney.api.repository.query;

import java.util.List;

import com.workproject.algamoney.api.model.Lancamento;
import com.workproject.algamoney.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
