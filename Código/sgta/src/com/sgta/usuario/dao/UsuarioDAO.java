package com.sgta.usuario.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sgta.bd.BD;
import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.dominio.Usuario;

import java.sql.PreparedStatement;

public class UsuarioDAO {
	private static UsuarioDAO instancia = new UsuarioDAO();

	private UsuarioDAO() {
	}

	private BD bd = BD.getInstancia();

	public static UsuarioDAO getInstancia() {
		return instancia;
	}

	public void inserirAluno(Pessoa pessoa) {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("INSERT INTO aluno (nome,data_nasc,sexo,cpf,identidade,endereco,"
							+ "numero, complemento, cidade, estado, bairro, telefone, celular, email, observacao) VALUES (?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?)");
			prepared.setString(1, pessoa.getNome());
			prepared.setString(2, pessoa.getDataDeNascimento());
			prepared.setString(3, pessoa.getSexo());
			prepared.setString(4, pessoa.getCpf());
			prepared.setString(5, pessoa.getIdentidade());
			prepared.setString(6, pessoa.getEndereco());
			prepared.setString(7, pessoa.getNumero());
			prepared.setString(8, pessoa.getComplemento());
			prepared.setString(9, pessoa.getCidade());
			prepared.setString(10, pessoa.getEstado());
			prepared.setString(11, pessoa.getBairro());
			prepared.setString(12, pessoa.getTelefone());
			prepared.setString(13, pessoa.getCelular());
			prepared.setString(14, pessoa.getEmail());
			prepared.setString(15, pessoa.getObservacoes());

			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserirFuncionario(Pessoa pessoa) {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("INSERT INTO func (nome,data_nasc,sexo,cpf,identidade,endereco,"
							+ "numero, complemento, cidade, estado, bairro, telefone, celular, email,cargo,login,senha) VALUES (?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?,?,?)");
			prepared.setString(1, pessoa.getNome());
			prepared.setString(2, pessoa.getDataDeNascimento());
			prepared.setString(3, pessoa.getSexo());
			prepared.setString(4, pessoa.getCpf());
			prepared.setString(5, pessoa.getIdentidade());
			prepared.setString(6, pessoa.getEndereco());
			prepared.setString(7, pessoa.getNumero());
			prepared.setString(8, pessoa.getComplemento());
			prepared.setString(9, pessoa.getCidade());
			prepared.setString(10, pessoa.getEstado());
			prepared.setString(11, pessoa.getBairro());
			prepared.setString(12, pessoa.getTelefone());
			prepared.setString(13, pessoa.getCelular());
			prepared.setString(14, pessoa.getEmail());
			prepared.setString(15, pessoa.getCargo());
			prepared.setString(16, pessoa.getUsuario().getUsername());
			prepared.setString(17, pessoa.getUsuario().getSenha());

			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean consultaCpfAluno(String cpf) throws SQLException {

		Connection con = bd.getConnection();

		PreparedStatement prepared = con
				.prepareStatement("SELECT cpf FROM aluno WHERE cpf = ?");
		prepared.setString(1, cpf);

		ResultSet resultSet = prepared.executeQuery();

		if (resultSet.next()) {
			bd.fecharConecaoMySQL();
			return false;
		} else {
			return true;
		}

	}

	public boolean consultaCpfFuncionario(String cpf) throws SQLException {

		Connection con = bd.getConnection();

		PreparedStatement prepared = con
				.prepareStatement("SELECT cpf FROM func WHERE cpf = ?");
		prepared.setString(1, cpf);

		ResultSet resultSet = prepared.executeQuery();

		if (resultSet.next()) {
			bd.fecharConecaoMySQL();
			return false;
		} else {
			return true;
		}

	}

	public boolean consultaLoginFuncionario(String login) throws SQLException {

		Connection con = bd.getConnection();

		PreparedStatement prepared = con
				.prepareStatement("SELECT login FROM func WHERE login = ?");
		prepared.setString(1, login);

		ResultSet resultSet = prepared.executeQuery();

		if (resultSet.next()) {
			bd.fecharConecaoMySQL();
			return false;
		} else {
			return true;
		}

	}

	public Usuario findAdminByLogin(String login) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario user = new Usuario();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM admin WHERE login = ?");
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setSenha(resultSet.getString("senha"));
				user.setUsername(resultSet.getString("login"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return user;
	}
	
	public Usuario findFuncionarioByLogin(String login) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario user = new Usuario();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM func WHERE login = ?");
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setSenha(resultSet.getString("senha"));
				user.setUsername(resultSet.getString("login"));
				user.setCargo(resultSet.getString("cargo"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return user;
	}
	
	public Pessoa retornaAluno(String cpf) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario user = new Usuario();
		Pessoa pessoa = new Pessoa();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM aluno WHERE cpf = ?");
			statement.setString(1, cpf);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				
				pessoa.setUsuario(user);
				pessoa.setNome(resultSet.getString("nome"));
				pessoa.setDataDeNascimento(resultSet.getString("data_nasc"));
				pessoa.setSexo(resultSet.getString("sexo"));
				pessoa.setCpf(resultSet.getString("cpf"));
				pessoa.setIdentidade(resultSet.getString("identidade"));
				pessoa.setEndereco(resultSet.getString("endereco"));
				pessoa.setNumero(resultSet.getString("numero"));
				pessoa.setComplemento(resultSet.getString("complemento"));
				pessoa.setCidade(resultSet.getString("cidade"));
				pessoa.setEstado(resultSet.getString("estado"));
				pessoa.setBairro(resultSet.getString("bairro"));
				pessoa.setTelefone(resultSet.getString("telefone"));
				pessoa.setCelular(resultSet.getString("celular"));
				pessoa.setEmail(resultSet.getString("email"));
				pessoa.setObservacoes(resultSet.getString("observacao"));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return pessoa;
	}
	
	public void alterarAluno(Pessoa pessoa) {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("UPDATE aluno SET nome=?, data_nasc=?, sexo=?, cpf=?,"
							+ " identidade=?, endereco=?, numero=?, complemento=?, cidade=?,"
							+ " estado=?, bairro=?, telefone=?, celular=?, email=?, observacao=?"
							+ " WHERE id=?");
			prepared.setString(1, pessoa.getNome());
			prepared.setString(2, pessoa.getDataDeNascimento());
			prepared.setString(3, pessoa.getSexo());
			prepared.setString(4, pessoa.getCpf());
			prepared.setString(5, pessoa.getIdentidade());
			prepared.setString(6, pessoa.getEndereco());
			prepared.setString(7, pessoa.getNumero());
			prepared.setString(8, pessoa.getComplemento());
			prepared.setString(9, pessoa.getCidade());
			prepared.setString(10, pessoa.getEstado());
			prepared.setString(11, pessoa.getBairro());
			prepared.setString(12, pessoa.getTelefone());
			prepared.setString(13, pessoa.getCelular());
			prepared.setString(14, pessoa.getEmail());
			prepared.setString(15, pessoa.getObservacoes());
			prepared.setInt(16, pessoa.getUsuario().getId());

			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
