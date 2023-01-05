package com.example.demo.domain.dtos;

import com.example.demo.domain.Endereco;
import com.example.demo.domain.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDTO extends Pessoa {

	private Integer id;
	private String nome;
	private String dataNascimento;

	private List<Endereco> endereco = new ArrayList<>();
	
	public PessoaDTO ( ) {}

	public PessoaDTO(Integer id, String nome, String dataNascimento, List<Endereco> endereco) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.dataNascimento = obj.getDataNascimento();
		this.endereco = obj.getEndereco();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String getDataNascimento() {
		return dataNascimento;
	}

	@Override
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public List<Endereco> getEndereco() {
		return endereco;
	}

	@Override
	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}
