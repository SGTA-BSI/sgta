package com.sgta.treino.negocio;

import com.sgta.treino.dao.TreinoDAO;
import com.sgta.treino.dominio.RelacaoTreinoExercicio;
import com.sgta.treino.dominio.Treino;

public class TreinoBusiness {
	private TreinoDAO treinoDao = TreinoDAO.getInstancia();
	private static TreinoBusiness instancia = new TreinoBusiness();
	private TreinoBusiness(){
		
	}
	public static TreinoBusiness getInstancia(){
		return instancia;
	}
	public void inserirTreino(Treino treino){
		treinoDao.inserirTreino(treino);
	} 
	
	public Treino buscarTreino(String nomeTreino){
		return treinoDao.buscarTreino(nomeTreino);
	}
	
	public void inserirExerciciosTreino(RelacaoTreinoExercicio relacao){
		treinoDao.inserirExerciciosTreino(relacao);
	}
}
