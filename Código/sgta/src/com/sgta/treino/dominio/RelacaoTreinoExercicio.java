package com.sgta.treino.dominio;

public class RelacaoTreinoExercicio {
	private int id;
	private int idAluno;
	private int idTreino;
	private int idExercicio;
	private int repeticao;
	private int serie;
	private int carga;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public int getIdTreino() {
		return idTreino;
	}

	public void setIdTreino(int idTreino) {
		this.idTreino = idTreino;
	}

	public int getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(int idExercicio) {
		this.idExercicio = idExercicio;
	}

	public int getRepeticao() {
		return repeticao;
	}

	public void setRepeticao(int repeticao) {
		this.repeticao = repeticao;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

}
