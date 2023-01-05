package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import com.example.demo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pessoa;
import com.example.demo.domain.dtos.PessoaDTO;
import com.example.demo.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> findAllPessoa() {
		return repository.findAll();
	}
	public Pessoa createPessoa(@Valid PessoaDTO objDto) {
		return repository.save(new Pessoa(objDto));
	}
	public Pessoa findById(Integer id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado" + id));
	}
	public Pessoa updatePessoa(Integer id, PessoaDTO objDto) {
		objDto.setId(id);
		Pessoa oldObj = findById(id);
		oldObj = new Pessoa(objDto);
		return repository.save(oldObj);
	}
	public void deletePessoa(Integer id) {
		repository.deleteById(id);
	}
}
