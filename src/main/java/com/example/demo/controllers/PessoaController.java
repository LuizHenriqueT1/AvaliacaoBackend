package com.example.demo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Pessoa;
import com.example.demo.domain.dtos.PessoaDTO;
import com.example.demo.services.PessoaService;

@RestController
@RequestMapping(value = "/service/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> findById(@PathVariable Integer id) {
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(new PessoaDTO(obj));
	}
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll() {
		List<Pessoa> list = service.findAllPessoa();
		List<PessoaDTO> listDto = list.stream()
				.map(obj -> new PessoaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
	}
	@PostMapping
	public ResponseEntity<PessoaDTO> createPessoa(@Valid @RequestBody PessoaDTO objDto) {
		Pessoa newObj = service.createPessoa(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> updatePessoa(@PathVariable Integer id, @RequestBody PessoaDTO objDto) {
		Pessoa obj = service.updatePessoa(id, objDto);
		return ResponseEntity.ok().body(new PessoaDTO(obj));
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> deletePessoa(@PathVariable Integer id) {
		service.deletePessoa(id);
		return ResponseEntity.noContent().build();
	}
}
