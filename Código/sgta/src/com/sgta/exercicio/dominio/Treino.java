package com.sgta.exercicio.dominio;

import java.util.Collection;
import java.util.Date;

import com.sgta.usuario.dominio.Usuario;

public class Treino {
	private int id;
	private String nome;
	private Collection<ItemExercicio> exercicios;
	private Usuario usuario;
	private Date dataInicio;
	private Date dataFim;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Collection<ItemExercicio> getExercicios() {
		return this.exercicios;
	}
	public void setExercicios(Collection<ItemExercicio> exercicios) {
		this.exercicios = exercicios;
	}
	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
	

}
