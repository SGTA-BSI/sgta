package com.sgta.exercicio.negocio;

import com.sgta.exercicio.dao.ExercicioDAO;
import com.sgta.exercicio.dominio.Exercicio;

public class ExercicioBusiness {
	private ExercicioDAO exercicioDao = ExercicioDAO.getInstancia();
	private static ExercicioBusiness instancia = new ExercicioBusiness();
	private ExercicioBusiness(){
		
	}
	public static ExercicioBusiness getInstancia(){
		return instancia;
	}
	public void inserirExercicio(Exercicio exercicio){
		exercicioDao.inserirExercicio(exercicio);
	}
}
