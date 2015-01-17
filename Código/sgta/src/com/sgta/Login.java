package com.sgta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javafx.scene.image.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.sgta.usuario.gui.MenuAdm;
import com.sgta.usuario.gui.MenuAtendente;
import com.sgta.usuario.gui.MenuProfessor;
import com.sgta.usuario.gui.Toast;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.SessaoUsuario;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.Label;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String cargoUsuario;
	final static Login frame = new Login();

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
	public Login() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 460);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSejaBemVindo = new JLabel("Seja Bem Vindo");
		lblSejaBemVindo.setFont(new Font("Vijaya", Font.BOLD, 36));
		lblSejaBemVindo.setBounds(29, 11, 336, 78);
		contentPane.add(lblSejaBemVindo);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Constantia", Font.BOLD, 18));
		lblLogin.setBounds(29, 106, 105, 23);
		contentPane.add(lblLogin);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(29, 140, 209, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		String[] items = { "Informe o tipo de usuário:", "Administrador",
				"Atendente", "Professor" };

		JComboBox comboBoxUsuario = new JComboBox(items);
		comboBoxUsuario.setBounds(268, 140, 184, 32);
		contentPane.add(comboBoxUsuario);
		comboBoxUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxUsuario.getSelectedItem() == "Administrador") {
					cargoUsuario = "Administrador";
				} else if (comboBoxUsuario.getSelectedItem() == "Atendente") {
					cargoUsuario = "Atendente";

				} else if (comboBoxUsuario.getSelectedItem() == "Professor") {
					cargoUsuario = "Professor";
				} else {
					cargoUsuario = "";
				}

			}
		});

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Constantia", Font.BOLD, 18));
		lblSenha.setBounds(29, 185, 87, 23);
		contentPane.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(29, 212, 214, 32);
		contentPane.add(passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEntrar.setBounds(27, 305, 107, 32);
		contentPane.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				String password = new String(passwordField.getPassword());

				try {
					if (cargoUsuario == "Administrador") {
						if (business.validaAdminLogin(textField.getText()
								.toString(), password)) {
							MenuAdm tela = new MenuAdm();
							tela.setVisible(true);
							dispose();
						} else {
							Toast.makeText(
									frame,
									"Verifique o login ou senha do administrador.",
									2000, Style.ERROR).display();
						}
					} else if (cargoUsuario == "Atendente") {
						if (business.validaFuncionarioLogin(textField.getText()
								.toString(), password, cargoUsuario)) {
							if (business
									.getDao()
									.findFuncionarioByLogin(
											textField.getText().toString())
									.getUsuario().getAtivo().equals("Ativo")) {
								SessaoUsuario.getInstancia().setUsuarioLogado(
										business.getDao()
												.findFuncionarioByLogin(
														textField.getText()
																.toString()));
								MenuAtendente tela = new MenuAtendente();
								tela.setVisible(true);
								dispose();

							} else {
								Toast.makeText(
										frame,
										"O usuário informado está inativo. Contate o administrador do sistema.",
										2000, Style.ERROR).display();
							}

						} else {
							Toast.makeText(frame,
									"Verifique o login ou senha do atendente.",
									2000, Style.ERROR).display();
						}
					} else if (cargoUsuario == "Professor") {
						if (business.validaFuncionarioLogin(textField.getText()
								.toString(), password, cargoUsuario)) {
							if (business
									.getDao()
									.findFuncionarioByLogin(
											textField.getText().toString())
									.getUsuario().getAtivo().equals("Ativo")) {
								SessaoUsuario.getInstancia().setUsuarioLogado(
										business.getDao()
												.findFuncionarioByLogin(
														textField.getText()
																.toString()));
								MenuProfessor tela = new MenuProfessor();
								tela.setVisible(true);
								dispose();

							} else {
								Toast.makeText(
										frame,
										"O usuário informado está inativo. Contate o administrador do sistema.",
										2000, Style.ERROR).display();
							}
						} else {
							Toast.makeText(frame,
									"Verifique o login ou senha do professor.",
									2000, Style.ERROR).display();
						}
					} else {
						Toast.makeText(frame, "Informe o tipo de usuário.",
								2000, Style.ERROR).display();
					}
				} catch (SQLException e1) {
					Toast.makeText(frame,
							"Erro conectando com o banco de dados.", 2000,
							Style.ERROR).display();
				}

			}

		});

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBounds(144, 305, 105, 32);
		contentPane.add(btnSair);

		JLabel label = new JLabel("");
		java.awt.Image img = new ImageIcon(this.getClass().getResource(
				"/man.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(268, 11, 400, 410);
		contentPane.add(label);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
