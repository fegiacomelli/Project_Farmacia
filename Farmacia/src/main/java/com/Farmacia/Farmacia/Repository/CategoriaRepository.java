package com.Farmacia.Farmacia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Farmacia.Farmacia.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findByDescricao(String descricao);

  
    public Optional<Categoria> findById(Long id);
	
	public  List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);
	
	
	
	

}
