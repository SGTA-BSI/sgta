package com.sgta.exercicio.negocio;

import java.util.List;

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
	public List<Exercicio> retornaTodosExercicios() {
		return exercicioDao.retornaTodosExercicios();
	}
	
	public Exercicio retornaExercicio(String nomeExercicio){
		return exercicioDao.retornaExercicio(nomeExercicio);
	}
	
	public Exercicio retornaExercicioByID(int idExercicio){
		return exercicioDao.retornaExercicioByID(idExercicio);
	}
}
