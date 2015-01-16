package com.sgta.exercicio.dominio;

public class ItemExercicio {
	private int id;
	private Exercicio exercicio;
	private int repeticoes;
	private int series;
	private int carga;
	
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Exercicio getExercicio() {
		return this.exercicio;
	}
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	public int getRepeticoes() {
		return this.repeticoes;
	}
	public void setRepeticoes(int repeticoes) {
		this.repeticoes = repeticoes;
	}
	public int getSeries() {
		return this.series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	
	public int getCarga() {
		return this.carga;
	}
	public void setCarga(int carga) {
		this.carga = carga;
	}
	

}
