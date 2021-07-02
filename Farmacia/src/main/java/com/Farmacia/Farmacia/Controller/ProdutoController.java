package com.Farmacia.Farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Farmacia.Farmacia.Repository.ProdutoRepository;
import com.Farmacia.Farmacia.model.Produto;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping("/todas")
	public List<Produto> buscaAll(){
	    return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Produto> buscaId(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@GetMapping("/{descricao}")
	public List<Produto> findDescricao(@RequestBody String descricao){
		return repository.findAllByDescricaoContainingIgnoreCase(descricao); 
	}
	
	@PostMapping
	public  ResponseEntity<Produto> addCat(@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping
	public ResponseEntity<Produto> putCat (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	@DeleteMapping("/id/{id}")
	public void deletar (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	

}
