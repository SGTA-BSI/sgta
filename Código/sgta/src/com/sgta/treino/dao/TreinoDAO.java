package com.sgta.treino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.sgta.bd.BD;
import com.sgta.treino.dominio.Treino;

public class TreinoDAO {
	private static TreinoDAO instancia = new TreinoDAO();

	private TreinoDAO() {
	}

	private BD bd = BD.getInstancia();

	public static TreinoDAO getInstancia() {
		return instancia;
	}
	
	public void inserirTreino(Treino treino){
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con.prepareStatement("INSERT INTO treino(nome,id_usuario,data_inicio,data_fim) VALUES(?,?,?,?)");
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			prepared.setString(1, treino.getNome());
			prepared.setInt(2, treino.getUsuario().getId());
			prepared.setString(3,formatter.format(treino.getDataInicio()));
			prepared.setString(4,formatter.format(treino.getDataFim()));
			
			prepared.execute();
			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
