package com.sgta.usuario.negocio;

import java.sql.SQLException;

import com.sgta.usuario.dao.UsuarioDAO;
import com.sgta.usuario.dominio.Pessoa;

public class UsuarioBusiness {
	private UsuarioDAO dao = UsuarioDAO.getInstancia();

	private static UsuarioBusiness instancia = new UsuarioBusiness();

	private UsuarioBusiness() {
	}

	public static UsuarioBusiness getInstancia() {
		return instancia;
	}
	
	public void inserirAluno(Pessoa pessoa){
		dao.inserirAluno(pessoa);
		
	}
	public boolean consultaCpfAluno(String cpf) throws SQLException{
		return dao.consultaCpfAluno(cpf);
	}
	
	public boolean consultaCpfFuncionario(String cpf) throws SQLException{
		return dao.consultaCpfFuncionario(cpf);
	}
	
	public void  inserirFuncionario(Pessoa pessoa){
		dao.inserirFuncionario(pessoa);
	}

}
