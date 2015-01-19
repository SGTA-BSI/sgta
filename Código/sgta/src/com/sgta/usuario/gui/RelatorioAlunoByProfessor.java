package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class RelatorioAlunoByProfessor extends JFrame {

	private JPanel contentPane;
	final static RelatorioAlunoByProfessor frame = new RelatorioAlunoByProfessor();
	private JTextField usernameProfessor;
	private JTextArea textArea;
	private JLabel lblNomeProf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RelatorioAlunoByProfessor frame = new RelatorioAlunoByProfessor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public RelatorioAlunoByProfessor() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRelatrioDeAlunos = new JLabel(
				"Relat\u00F3rio de Alunos por Professor");
		lblRelatrioDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRelatrioDeAlunos.setBounds(10, 11, 290, 14);
		contentPane.add(lblRelatrioDeAlunos);

		JLabel lblUsernameProf = new JLabel("Username Professor");
		lblUsernameProf.setBounds(8, 39, 153, 14);
		contentPane.add(lblUsernameProf);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				if (usernameProfessor.getText().length() == 0) {
					Toast.makeText(frame, "Preencha o username do professor",
							2000, Style.ERROR).display();
				} else {
					try {
						Pessoa professor = business.buscarFuncionarioByLogin(usernameProfessor
								.getText());
						if (professor.getNome() == null) {
							Toast.makeText(frame,
									"Professor não cadastrado no sistema",
									2000, Style.ERROR).display();
						} else {
							List<Pessoa> alunos = business
									.alunosByProfessor(usernameProfessor
											.getText());
							if (alunos.isEmpty()) {
								textArea.setText("O professor não possui alunos!");
								lblNomeProf.setText(professor.getNome());
							} else {
								int cont = 0;
								String nomeAlunos = new String();
								for (Pessoa pessoa : alunos) {
									cont = cont + 1;
									nomeAlunos = nomeAlunos + cont + " - "
											+ pessoa.getNome() + " \n";
								}
								textArea.setText(nomeAlunos);
								lblNomeProf.setText(professor.getNome());
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnBuscar.setBounds(379, 35, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblProfessor = new JLabel("Professor:");
		lblProfessor.setBounds(10, 84, 76, 14);
		contentPane.add(lblProfessor);

		lblNomeProf = new JLabel("");
		lblNomeProf.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNomeProf.setBounds(82, 84, 343, 14);
		contentPane.add(lblNomeProf);

		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(10, 123, 46, 14);
		contentPane.add(lblAlunos);

		usernameProfessor = new JTextField();
		usernameProfessor.setBounds(147, 36, 222, 20);
		contentPane.add(usernameProfessor);
		usernameProfessor.setColumns(10);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdm tela = new MenuAdm();
				tela.setVisible(true);
				dispose();
			}
		});
		btnFechar.setBounds(339, 331, 118, 23);
		contentPane.add(btnFechar);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(68, 118, 320, 174);
		contentPane.add(textArea);
	}
}
