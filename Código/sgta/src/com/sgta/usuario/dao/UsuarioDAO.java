package com.sgta.usuario.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.sgta.bd.BD;
import com.sgta.usuario.dominio.Pessoa;
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
			PreparedStatement prepared =  con
					.prepareStatement("INSERT INTO aluno (nome,data_nasc,sexo,cpf,identidade,endereco,"
							+ "numero, complemento, cidade, estado, bairro, telefone, celular, email, observacao) VALUES (?,?,?,?,?,?,?,?,"
							+ "?,?,?,?,?,?,?)");
			prepared.setString(1, pessoa.getNome());
			prepared.setString(2, pessoa.getDataDeNascimento());
			prepared.setString(3, "Sexo");
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
}
