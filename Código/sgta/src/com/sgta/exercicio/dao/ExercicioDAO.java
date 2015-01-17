package com.sgta.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sgta.bd.BD;
import com.sgta.exercicio.dominio.Exercicio;

public class ExercicioDAO {
	private static ExercicioDAO instancia = new ExercicioDAO();
	private BD bd = BD.getInstancia();
	private ExercicioDAO() {
	}


	public static ExercicioDAO getInstancia() {
		return instancia;
	}
	public void inserirExercicio(Exercicio exercicio){
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con.prepareStatement("INSERT INTO exercicios (nome,musculo) VALUES (?,?)");
			prepared.setString(1, exercicio.getNome());
			prepared.setString(2, exercicio.getMusculo());
			
			prepared.execute();
			
			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
