package com.sgta.usuario.negocio;

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

}
