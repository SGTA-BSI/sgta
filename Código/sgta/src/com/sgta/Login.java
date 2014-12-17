package com.sgta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.sgta.usuario.gui.MenuAdm;
import com.sgta.usuario.gui.MenuAtendente;
import com.sgta.usuario.gui.MenuProfessor;
import com.sgta.usuario.negocio.UsuarioBusiness;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private String cargoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
		setBounds(100, 100, 716, 460);
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
		textField.setBounds(29, 140, 184, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		String[] items = { "Informe o tipo de usuário:", "Administrador",
				"Atendente", "Professor" };
		
		JComboBox comboBoxUsuario = new JComboBox(items);
		comboBoxUsuario.setBounds(248, 140, 184, 32);
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
		lblSenha.setFont(new Font("Constantia", Font.BOLD, 14));
		lblSenha.setBounds(29, 206, 87, 23);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(29, 238, 184, 32);
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
								.toString(),password)) {
							MenuAdm tela = new MenuAdm();
							tela.setVisible(true);
							setVisible(false);
							
						}else {
							JOptionPane.showMessageDialog(null,
									"Verifique o login ou senha do administrador.");
						}
					} else if (cargoUsuario == "Atendente") {
						if (business.validaFuncionarioLogin(textField.getText()
								.toString(), password,
								cargoUsuario)) {
							MenuAtendente tela = new MenuAtendente();
							tela.setVisible(true);
							setVisible(false);
							
						} else {
							JOptionPane.showMessageDialog(null,
									"Verifique o login ou senha do atendente.");
						}
					} else if (cargoUsuario == "Professor") {
						if (business.validaFuncionarioLogin(textField.getText()
								.toString(), password,
								cargoUsuario)) {
							MenuProfessor tela = new MenuProfessor();
							tela.setVisible(true);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null,
									"Verifique professor.");
						}
					}else{
						JOptionPane.showMessageDialog(null,
								"Informe o tipo de usuário.");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,
							"Erro conectando com o banco de dados.");
				}

			}
			
		});
		

		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBounds(208, 305, 105, 32);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
