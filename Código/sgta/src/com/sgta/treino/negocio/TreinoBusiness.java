package com.sgta.treino.negocio;

import java.util.List;

import com.sgta.treino.dao.TreinoDAO;
import com.sgta.treino.dominio.RelacaoTreinoExercicio;
import com.sgta.treino.dominio.Treino;

public class TreinoBusiness {
	private TreinoDAO treinoDao = TreinoDAO.getInstancia();
	private static TreinoBusiness instancia = new TreinoBusiness();

	private TreinoBusiness() {

	}

	public static TreinoBusiness getInstancia() {
		return instancia;
	}

	public void inserirTreino(Treino treino) {
		treinoDao.inserirTreino(treino);
	}

	public Treino buscarTreino(String nomeTreino) {
		return treinoDao.buscarTreino(nomeTreino);
	}
	
	public List<Treino> listaTreinos(int idAluno) {
		return treinoDao.listaTreinos(idAluno);
	}

	public void inserirExerciciosTreino(RelacaoTreinoExercicio relacao) {
		treinoDao.inserirExerciciosTreino(relacao);
	}

	public List<RelacaoTreinoExercicio> buscarRelacao(int idAluno) {
		return treinoDao.buscarRelacao(idAluno);
	}
}
