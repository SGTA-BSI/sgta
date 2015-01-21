package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.text.ParseException;

import javax.swing.SwingConstants;

import com.sgta.Login;
import com.sgta.exercicio.gui.CadastroExercicio;
import com.sgta.usuario.negocio.SessaoUsuario;

public class MenuProfessor extends JFrame {

	private JPanel contentPane;
	private static JLabel lblInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuProfessor frame = new MenuProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuProfessor() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 449);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuProfessor = new JLabel("Menu Professor");
		lblMenuProfessor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMenuProfessor.setBounds(22, 11, 165, 28);
		contentPane.add(lblMenuProfessor);

		JButton btnCadastrarAluno = new JButton("Cadastrar Novo Aluno");
		btnCadastrarAluno.setBounds(10, 75, 213, 84);
		contentPane.add(btnCadastrarAluno);
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAlunosForm tela;
				try {
					tela = new CadastroAlunosForm();
					tela.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton btnPerfilDeAlunos = new JButton("Perfil de Alunos");
		btnPerfilDeAlunos.setBounds(10, 172, 213, 84);
		contentPane.add(btnPerfilDeAlunos);
		btnPerfilDeAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PerfilUsuario tela;
				try {
					tela = new PerfilUsuario();
					tela.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnRelatoriosDeAluno = new JButton("Relat\u00F3rios de Alunos");
		btnRelatoriosDeAluno.setBounds(10, 277, 213, 84);
		contentPane.add(btnRelatoriosDeAluno);

		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(419, 17, 89, 23);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SessaoUsuario.getInstancia().setUsuarioLogado(null);
				Login tela = new Login();
				tela.setVisible(true);
				dispose();
			}
		});

		lblInfo = new JLabel("");
		lblInfo.setBounds(10, 386, 581, 14);
		contentPane.add(lblInfo);

		JButton btnCriarTreino = new JButton("Criar Treino");
		btnCriarTreino.setBounds(261, 75, 177, 84);
		contentPane.add(btnCriarTreino);

		JButton btnAlterarAluno = new JButton("Alterar Cadastro Aluno");
		btnAlterarAluno.setBounds(261, 172, 177, 84);
		contentPane.add(btnAlterarAluno);

		JButton btnCadastrarExercicio = new JButton("Cadastrar Exerc\u00EDcio");
		btnCadastrarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroExercicio tela = new CadastroExercicio();
				tela.setVisible(true);
				dispose();

			}
		});
		btnCadastrarExercicio.setBounds(261, 277, 177, 84);
		contentPane.add(btnCadastrarExercicio);
		btnAlterarAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AlterarCadastroAlunosForm tela = new AlterarCadastroAlunosForm();
				tela.setVisible(true);
				setVisible(false);

			}
		});
	}

	public static void getLblInfo(String mensagem) {
		lblInfo.setText(mensagem);
	}
}
