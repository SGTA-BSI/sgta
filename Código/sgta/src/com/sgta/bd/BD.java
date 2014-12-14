package com.sgta.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sgta.usuario.dao.UsuarioDAO;

public class BD {
	private static BD instancia = new BD();

	private BD() {
	}

	private BD bd;

	public static BD getInstancia() {
		return instancia;
	}
	
	private static Connection con;
	
	private static Connection conexao = null;
	private static Statement statement;
	private static ResultSet resultSet = null;
	private static String stringSQL = null;

	public static ResultSet getResultSet() {
		return resultSet;
	}

	public static void setResultSet(ResultSet resultSet) {
		BD.resultSet = resultSet;
	}

	/**
	 * ABRE CONEXÃO COM COM BANCO
	 */
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost/sgtabd", "root", ""); 
		}  catch (ClassNotFoundException e) {    
            throw new SQLException(e.getMessage());  
		}
	}

	/**
	 * FECHA CONEXÃO COM COM BANCO
	 */
	public static void fecharConecaoMySQL() {
		try {
			conexao.close();
		} catch (Exception erro) {
			System.out.println("MYSQL Erro(fechar): " + erro);
		}
	}

	/**
	 * RESULTADO DA CONSULTA NO BANCO
	 */
	public static ResultSet queryMySQL(String qry) {
		try {
			statement = conexao.createStatement();
			stringSQL = qry;
			setResultSet(statement.executeQuery(stringSQL));
			getResultSet().first();
			return getResultSet();
		} catch (Exception erro) {
			System.out.println("MYSQL Erro: " + erro);
			return null;
		}
	}
}
