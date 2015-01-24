package com.sgta.exercicio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sgta.bd.BD;
import com.sgta.exercicio.dominio.Exercicio;
import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.dominio.Usuario;

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
	public List<Exercicio> retornaTodosExercicios() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		List<Exercicio> listaExercicios = new ArrayList<Exercicio>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM exercicios");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Exercicio exercicio = new Exercicio();
				exercicio.setId(resultSet.getInt("id"));
				exercicio.setNome(resultSet.getString("nome"));
				exercicio.setMusculo(resultSet.getString("musculo"));
				listaExercicios.add(exercicio);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			bd.fecharConecaoMySQL();
		}

		return listaExercicios;
	}

}
