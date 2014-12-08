package com.sgta.usuario.dominio;

public class Pessoa {
	private Usuario usuario;
	private String nome;
	private String dataDeNascimento; // por enquanto deixei como String
	private String sexo;
	private String cpf;
	private String identidade;
	private String endereco;
	private String numero;
	private String complemento;
	private String cidade;
	private String estado;
	private String bairro;
	private String telefone;
	private String celular;
	private String email;
	private String observacoes;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataDeNascimento() {
		return this.dataDeNascimento;
	}
	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getIdentidade() {
		return this.identidade;
	}
	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return this.numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return this.complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return this.cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return this.estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getBairro() {
		return this.bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getTelefone() {
		return this.telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return this.celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getObservacoes() {
		return this.observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	
	

}
