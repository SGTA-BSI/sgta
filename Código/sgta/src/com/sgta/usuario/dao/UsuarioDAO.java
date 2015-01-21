package com.sgta.usuario.dao;

import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.sgta.bd.BD;
import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.dominio.Usuario;
import com.sgta.usuario.gui.Toast;

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
							+ "numero, complemento, cidade, estado, bairro, telefone, celular, email, observacao,status) VALUES (?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?,?)");
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
			prepared.setString(16, pessoa.getUsuario().getAtivo());

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
							+ "numero, complemento, cidade, estado, bairro, telefone, celular, email,cargo,login,senha,status) VALUES (?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?,?,?,?)");
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
			prepared.setString(18, pessoa.getUsuario().getAtivo());

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
			JOptionPane.showMessageDialog(null,
					"Erro de conex�o com o servidor.", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return user;
	}

	public Pessoa findFuncionarioByLogin(String login) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario user = new Usuario();
		Pessoa pessoa = new Pessoa();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM func WHERE login = ?");
			statement.setString(1, login);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setAtivo(resultSet.getString("status"));
				user.setSenha(resultSet.getString("senha"));
				user.setCargo(resultSet.getString("cargo"));
				user.setUsername(resultSet.getString("login"));

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

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Erro de conex�o com o servidor.", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return pessoa;
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
							+ " estado=?, bairro=?, telefone=?, celular=?, email=?, observacao=?,status = ?"
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
			prepared.setString(16, pessoa.getUsuario().getAtivo());
			prepared.setInt(17, pessoa.getUsuario().getId());

			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pessoa retornaFuncionario(String cpf) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario user = new Usuario();
		Pessoa pessoa = new Pessoa();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM func WHERE cpf = ?");
			statement.setString(1, cpf);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setCargo(resultSet.getString("cargo"));
				user.setAtivo(resultSet.getString("status"));
				user.setSenha(resultSet.getString("senha"));
				user.setUsername(resultSet.getString("login"));

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

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return pessoa;
	}

	public void alterarFuncionario(Pessoa pessoa) {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("UPDATE func SET nome=?, data_nasc=?, sexo=?, cpf=?,"
							+ " identidade=?, endereco=?, numero=?, complemento=?, cidade=?,"
							+ " estado=?, bairro=?, telefone=?, celular=?, email=?,status = ?"
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
			prepared.setString(15, pessoa.getUsuario().getAtivo());
			prepared.setInt(16, pessoa.getUsuario().getId());

			prepared.execute();

			bd.fecharConecaoMySQL();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Pessoa> findAlunosByProfessor(String usernameProfessor)
			throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Usuario user = new Usuario();
		Pessoa pessoa = new Pessoa();
		List<Pessoa> listaAlunos = new ArrayList<Pessoa>();

		try {
			connection = bd.getConnection();
			statement = connection
					.prepareStatement("SELECT * FROM aluno WHERE professor = ?");
			statement.setString(1, usernameProfessor);
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
				listaAlunos.add(pessoa);
				pessoa = new Pessoa();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			resultSet.close();
			bd.fecharConecaoMySQL();
		}

		return listaAlunos;
	}

	public void inserirMedidas(Pessoa pessoa) {
		try {
			Connection con = bd.getConnection();
			PreparedStatement prepared = con
					.prepareStatement("INSERT INTO medidas(id_aluno,altura,peso,bracos,peito,coxas,costas,"
							+ "panturrilhas,trapezio,antebracos,cintura) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
			prepared.setInt(1, pessoa.getUsuario().getId());
			prepared.setDouble(2, pessoa.getMedidas().getAltura());
			prepared.setDouble(3, pessoa.getMedidas().getPeso());
			prepared.setDouble(4, pessoa.getMedidas().getBracos());
			prepared.setDouble(5, pessoa.getMedidas().getPeitoral());
			prepared.setDouble(6, pessoa.getMedidas().getCoxas());
			prepared.setDouble(7, pessoa.getMedidas().getCostas());
			prepared.setDouble(8, pessoa.getMedidas().getPanturrilha());
			prepared.setDouble(9, pessoa.getMedidas().getTrapezio());
			prepared.setDouble(10, pessoa.getMedidas().getAntebracos());
			prepared.setDouble(11, pessoa.getMedidas().getCintura());

			prepared.execute();

			bd.fecharConecaoMySQL();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
