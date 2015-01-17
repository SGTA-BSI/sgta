package com.sgta.usuario.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.sgta.Login;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.SessaoUsuario;

public class MenuAtendente extends JFrame {

	private JPanel contentPane;
	private static JLabel lblInfo;
	final static MenuAtendente frame = new MenuAtendente();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public MenuAtendente() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame teste = frame;
		setBounds(100, 100, 663, 449);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuAtendente = new JLabel("Menu Atendente");
		lblMenuAtendente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMenuAtendente.setBounds(22, 11, 165, 28);
		contentPane.add(lblMenuAtendente);

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
		btnPerfilDeAlunos.setBounds(10, 172, 170, 84);
		contentPane.add(btnPerfilDeAlunos);
		btnPerfilDeAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PerfilUsuario tela = new PerfilUsuario();
					tela.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnRelatoriosDeAluno = new JButton("Relat\u00F3rios de Alunos");
		btnRelatoriosDeAluno.setBounds(10, 277, 225, 84);
		contentPane.add(btnRelatoriosDeAluno);
		btnRelatoriosDeAluno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Toast.makeText(frame, "Olá", Style.SUCCESS).display();

			}
		});

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

		JButton button = new JButton("Alterar Cadastro Aluno");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarCadastroAlunosForm tela;
				tela = new AlterarCadastroAlunosForm();
				tela.setVisible(true);
				dispose();

			}
		});
		button.setBounds(267, 75, 177, 84);
		contentPane.add(button);
	}

	public static void getLblInfo(String mensagem) {
		lblInfo.setText(mensagem);
	}

}
