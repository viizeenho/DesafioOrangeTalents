package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.example.demo.model.Endereco;
import com.example.demo.model.Usuario;
import com.example.demo.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository repository;

	@GetMapping
	public ResponseEntity<List<Endereco>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> getById (@PathVariable Long id){
		return repository.findById(id)
		.map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping
	public ResponseEntity<Endereco> put(@RequestBody Long id, @RequestBody Endereco endereco){
		return ResponseEntity.ok(repository.save(endereco));
	}
	
	@DeleteMapping("{id}")
	public void delete (@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
