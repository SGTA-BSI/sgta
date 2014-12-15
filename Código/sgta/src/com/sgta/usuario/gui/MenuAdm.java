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

public class MenuAdm extends JFrame {

	private JPanel contentPane;
	private static JLabel lblInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdm frame = new MenuAdm();
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
	public MenuAdm() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenuAdministrador = new JLabel("Menu Administrador");
		lblMenuAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMenuAdministrador.setBounds(22, 11, 165, 28);
		contentPane.add(lblMenuAdministrador);
		
		JButton btnCadastrarfuncionario = new JButton("Cadastrar Novo Funcion\u00E1rio");
		btnCadastrarfuncionario.setBounds(10, 75, 213, 84);
		contentPane.add(btnCadastrarfuncionario);
		btnCadastrarfuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFuncionarioForm tela;
				try {
					tela = new CadastroFuncionarioForm();
					tela.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
			}
		});
		
		JButton btnPerfilDeFuncionrios = new JButton("Perfil de Funcion\u00E1rios");
		btnPerfilDeFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerfilDeFuncionrios.setBounds(10, 172, 170, 84);
		contentPane.add(btnPerfilDeFuncionrios);
		
		JButton btnRelatriosDaAcademia = new JButton("Relat\u00F3rios da Academia");
		btnRelatriosDaAcademia.setBounds(10, 277, 225, 84);
		contentPane.add(btnRelatriosDaAcademia);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(419, 17, 89, 23);
		contentPane.add(btnLogout);
		
		lblInfo = new JLabel("");
		lblInfo.setBounds(22, 385, 539, 14);
		contentPane.add(lblInfo);
	}
	public static void getLblInfo(String mensagem){
		lblInfo.setText(mensagem);
	}
}
