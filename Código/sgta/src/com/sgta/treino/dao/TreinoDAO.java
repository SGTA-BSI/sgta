package com.sgta.treino.dao;

import com.sgta.bd.BD;

public class TreinoDAO {
	private static TreinoDAO instancia = new TreinoDAO();

	private TreinoDAO() {
	}

	private BD bd = BD.getInstancia();

	public static TreinoDAO getInstancia() {
		return instancia;
	}

}
