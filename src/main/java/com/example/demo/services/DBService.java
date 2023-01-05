package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Pessoa;
import com.example.demo.repositories.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private PessoaRepository repository;

	public void instanciaDB() {
		Endereco e1 = new Endereco("Jardim Guarani", "02849020", 357, "São Paulo", true);
		Endereco e2 = new Endereco("Bairro Bela Vista", "01310‑900", 1298, "São Paulo", false);

		List<Endereco> listEndereco = new ArrayList<>();
		listEndereco.add(e1);
		listEndereco.add(e2);

		Pessoa p1 = new Pessoa(null, "Luiz Henrique", "18/06/2002", listEndereco);

		repository.saveAll(Arrays.asList(p1));
	}
}
