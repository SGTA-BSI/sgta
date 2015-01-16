package com.sgta.exercicio.dao;

import com.sgta.bd.BD;

public class ExercicioDAO {
	private static ExercicioDAO instancia = new ExercicioDAO();
	private BD bd = BD.getInstancia();
	private ExercicioDAO() {
	}


	public static ExercicioDAO getInstancia() {
		return instancia;
	}

}
