package com.workproject.algamoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.workproject.algamoney.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
