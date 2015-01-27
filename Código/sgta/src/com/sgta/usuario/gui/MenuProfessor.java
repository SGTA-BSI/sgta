package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
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
import java.util.Date;

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
		setBounds(100, 100, 593, 408);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String nome = SessaoUsuario.getInstancia().getUsuarioLogado().getNome();
		if (nome.indexOf(" ") != -1) {
			nome = nome.substring(0, nome.indexOf(" "));
		}
		Date data = new Date();
		JLabel lblMenuProfessor = new JLabel("Menu Professor");
		if (data.getHours() >= 0 && data.getHours() < 12) {
			lblMenuProfessor = new JLabel("Bom dia, " + nome + ".");

		} else if (data.getHours() >= 12 && data.getHours() < 18) {
			lblMenuProfessor = new JLabel("Boa tarde, " + nome + ".");
		} else {
			lblMenuProfessor = new JLabel("Boa noite, " + nome + ".");
		}
		lblMenuProfessor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuProfessor.setBounds(10, 11, 454, 28);
		contentPane.add(lblMenuProfessor);

		JButton btnCadastrarAluno = new JButton("Cadastrar Novo Aluno");
		btnCadastrarAluno.setBounds(10, 75, 279, 84);
		Image img1 = new ImageIcon(this.getClass().getResource("/add.png"))
				.getImage();
		btnCadastrarAluno.setIcon(new ImageIcon(img1));
		contentPane.add(btnCadastrarAluno);
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAlunosForm tela;
				tela = new CadastroAlunosForm();
				tela.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnPerfilDeAlunos = new JButton("Perfil de Alunos");
		btnPerfilDeAlunos.setBounds(10, 267, 279, 84);
		Image img2 = new ImageIcon(this.getClass().getResource("/func.png"))
				.getImage();
		btnPerfilDeAlunos.setIcon(new ImageIcon(img2));
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
		btnRelatoriosDeAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscaCpfRelatorio tela = new BuscaCpfRelatorio();
				tela.setVisible(true);
				dispose();
			}
		});
		btnRelatoriosDeAluno.setBounds(297, 75, 279, 84);
		Image img4 = new ImageIcon(this.getClass().getResource(
				"/alunobyprofessor.png")).getImage();
		btnRelatoriosDeAluno.setIcon(new ImageIcon(img4));
		contentPane.add(btnRelatoriosDeAluno);

		JButton btnLogout = new JButton("");
		btnLogout.setBounds(536, 8, 40, 40);
		Image img6 = new ImageIcon(this.getClass().getResource("/logout.png"))
				.getImage();
		btnLogout.setIcon(new ImageIcon(img6));
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
		Image img = new ImageIcon(this.getClass().getResource("/treino.png"))
				.getImage();

		JButton btnAlterarAluno = new JButton("Alterar Cadastro Aluno");
		btnAlterarAluno.setBounds(10, 172, 279, 84);
		Image img3 = new ImageIcon(this.getClass()
				.getResource("/func_edit.png")).getImage();
		btnAlterarAluno.setIcon(new ImageIcon(img3));
		contentPane.add(btnAlterarAluno);

		JButton btnCadastrarExercicio = new JButton("Cadastrar Exerc\u00EDcio");
		btnCadastrarExercicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroExercicio tela = new CadastroExercicio();
				tela.setVisible(true);
				dispose();

			}
		});
		btnCadastrarExercicio.setBounds(297, 170, 279, 84);
		Image img5 = new ImageIcon(this.getClass().getResource("/gym.png"))
				.getImage();
		btnCadastrarExercicio.setIcon(new ImageIcon(img5));
		contentPane.add(btnCadastrarExercicio);

		JLabel lblVocEstLogado = new JLabel(
				"Voc\u00EA est\u00E1 logado como professor.");
		lblVocEstLogado.setBounds(10, 34, 213, 14);
		contentPane.add(lblVocEstLogado);
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
