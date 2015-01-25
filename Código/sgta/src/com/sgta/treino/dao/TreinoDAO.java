package com.sgta.treino.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.sgta.bd.BD;
import com.sgta.treino.dominio.RelacaoTreinoExercicio;
import com.sgta.treino.dominio.Treino;
import com.sgta.usuario.negocio.SessaoUsuario;

public class TreinoDAO {
	private static TreinoDAO instancia = new TreinoDAO();

	private TreinoDAO() {
	}

	private BD bd = BD.getInstancia();

	public static TreinoDAO getInstancia() {
		return instancia;
	}

	public void inserirTreino(Treino treino) {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("INSERT INTO treino(nome,id_usuario,data_inicio,data_fim) VALUES(?,?,?,?)");
			SimpleDateFormat formatter = new SimpleDateFormat(
					"dd/MM/yyyy HH:mm");
			prepared.setString(1, treino.getNome());
			prepared.setInt(2, treino.getUsuario().getId());
			prepared.setString(3, formatter.format(treino.getDataInicio())
					.toString());
			prepared.setString(4, formatter.format(treino.getDataFim())
					.toString());

			prepared.execute();
			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Treino buscarTreino(String nomeTreino) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Treino treino = new Treino();
		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM treino WHERE nome = ?");
			statement.setString(1, nomeTreino);
			resultSet = statement.executeQuery();
			SimpleDateFormat formatter = new SimpleDateFormat();
			while (resultSet.next()) {
				treino.setId(resultSet.getInt("id"));
				treino.setNome(resultSet.getString("nome"));
				Date dataInicio = formatter.parse(resultSet
						.getString("data_inicio"));
				treino.setDataInicio(dataInicio);
				Date dataFim = formatter.parse(resultSet.getString("data_fim"));
				treino.setDataFim(dataFim);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro de conex�o com o servidor.", "Erro",
					JOptionPane.ERROR_MESSAGE);
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

		return treino;
	}

	public void inserirExerciciosTreino(RelacaoTreinoExercicio relacao) {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("INSERT INTO relac_exerc_treino_aluno (id_aluno, id_treino, id_exercicio, "
							+ "repeticao, serie, carga) VALUES (?,?,?,?,?,?)");
			prepared.setInt(1, relacao.getIdAluno());
			prepared.setInt(2, relacao.getIdTreino());
			prepared.setInt(3, relacao.getIdExercicio());
			prepared.setInt(4, relacao.getRepeticao());
			prepared.setInt(5, relacao.getSerie());
			prepared.setInt(6, relacao.getCarga());

			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
