package com.Farmacia.Farmacia.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Farmacia.Farmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findByNome(String nome);

	public Optional<Produto> findById(Long id);

	public List<Produto> findAllByDescricaoContainingIgnoreCase(String descricao);

}