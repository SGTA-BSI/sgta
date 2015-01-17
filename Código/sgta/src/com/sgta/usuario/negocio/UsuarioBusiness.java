package com.sgta.usuario.negocio;

import java.sql.SQLException;
import java.util.List;

import com.sgta.usuario.dao.UsuarioDAO;
import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.dominio.Usuario;

public class UsuarioBusiness {
	private UsuarioDAO dao = UsuarioDAO.getInstancia();

	public UsuarioDAO getDao() {
		return dao;
	}

	private static UsuarioBusiness instancia = new UsuarioBusiness();

	private UsuarioBusiness() {
	}

	public static UsuarioBusiness getInstancia() {
		return instancia;
	}

	public void inserirAluno(Pessoa pessoa) {
		dao.inserirAluno(pessoa);

	}

	public boolean consultaCpfAluno(String cpf) throws SQLException {
		return dao.consultaCpfAluno(cpf);
	}

	public boolean consultaCpfFuncionario(String cpf) throws SQLException {
		return dao.consultaCpfFuncionario(cpf);
	}

	public void inserirFuncionario(Pessoa pessoa) {
		dao.inserirFuncionario(pessoa);
	}

	public boolean consultaLoginFuncionario(String login) throws SQLException {
		return dao.consultaLoginFuncionario(login);
	}

	public boolean validaAdminLogin(String usuario, String senha)
			throws SQLException {

		Usuario user = dao.findAdminByLogin(usuario);

		if (user == null) {
			return false;
		}

		String informado = usuario + senha;
		String esperado = user.getUsername() + user.getSenha();
		if (informado.equals(esperado)) {
			return true;
		} else {
			return false;
		}

	}

	public boolean validaFuncionarioLogin(String usuario, String senha,
			String cargo) throws SQLException {

		Pessoa pessoa = dao.findFuncionarioByLogin(usuario);

		if (pessoa == null) {
			return false;
		}
		String informado = usuario + senha + cargo;
		String esperado = pessoa.getUsuario().getUsername()
				+ pessoa.getUsuario().getSenha()
				+ pessoa.getUsuario().getCargo();
		if (informado.equals(esperado)) {
			return true;
		} else {
			return false;
		}

	}

	public Pessoa buscarAluno(String cpf) throws SQLException {
		return dao.retornaAluno(cpf);
	}

	public List<Pessoa> alunosByProfessor(String usernameProfessor)
			throws SQLException {
		return dao.findAlunosByProfessor(usernameProfessor);
	}

	public void alterarAluno(Pessoa aluno) {
		dao.alterarAluno(aluno);
	}

	public Pessoa buscarFuncionario(String cpf) throws SQLException {
		return dao.retornaFuncionario(cpf);
	}

	public void alterarFuncionario(Pessoa pessoa) {
		dao.alterarFuncionario(pessoa);
	}
	public void inserirMedidas(Pessoa pessoa){
		dao.inserirMedidas(pessoa);
	}

}
