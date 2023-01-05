package com.example.demo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.example.demo.domain.dtos.PessoaDTO;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String dataNascimento;
	@ElementCollection
	@CollectionTable(name = "endereco")
	private List<Endereco> endereco = new ArrayList<>();
	public Pessoa() {}
	public Pessoa(Integer id, String nome, String dataNascimento, List<Endereco> endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
	}
	public Pessoa(PessoaDTO objDto) {
		super();
		this.id = objDto.getId();
		this.nome = objDto.getNome();
		this.dataNascimento = objDto.getDataNascimento();
		this.endereco = objDto.getEndereco();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}
}
