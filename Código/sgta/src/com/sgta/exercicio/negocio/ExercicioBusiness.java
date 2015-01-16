package com.sgta.exercicio.negocio;

import com.sgta.exercicio.dao.ExercicioDAO;

public class ExercicioBusiness {
	private ExercicioDAO exercicioDao = ExercicioDAO.getInstancia();
	private static ExercicioBusiness instancia = new ExercicioBusiness();
	private ExercicioBusiness(){
		
	}
	public static ExercicioBusiness getInstancia(){
		return instancia;
	}

}
