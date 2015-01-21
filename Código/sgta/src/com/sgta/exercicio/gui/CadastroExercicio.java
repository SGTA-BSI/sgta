package com.sgta.exercicio.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import com.sgta.exercicio.dominio.Exercicio;
import com.sgta.exercicio.negocio.ExercicioBusiness;
import com.sgta.usuario.gui.MenuProfessor;
import com.sgta.usuario.gui.Toast;
import com.sgta.usuario.gui.Toast.Style;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroExercicio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldExercicio;
	private JTextField textFieldMusculo;
	final static CadastroExercicio frame = new CadastroExercicio();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroExercicio frame = new CadastroExercicio();
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
	public CadastroExercicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 450);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeExerccios = new JLabel(
				"Cadastro de Exerc\u00EDcios:");
		lblCadastroDeExerccios.setBounds(10, 0, 205, 41);
		lblCadastroDeExerccios.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblCadastroDeExerccios);

		JLabel lblNomeDoExerccio = new JLabel("Nome do exerc\u00EDcio:");
		lblNomeDoExerccio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNomeDoExerccio.setBounds(20, 52, 145, 29);
		contentPane.add(lblNomeDoExerccio);

		textFieldExercicio = new JTextField();
		textFieldExercicio.setBounds(30, 92, 325, 31);
		contentPane.add(textFieldExercicio);
		textFieldExercicio.setColumns(10);

		JLabel lblMsculo = new JLabel("M\u00FAsculo:");
		lblMsculo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMsculo.setBounds(20, 154, 74, 29);
		contentPane.add(lblMsculo);

		textFieldMusculo = new JTextField();
		textFieldMusculo.setBounds(30, 194, 325, 29);
		contentPane.add(textFieldMusculo);
		textFieldMusculo.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validacaoPreenchimento()) {
					Exercicio exercicio = new Exercicio();
					exercicio.setNome(textFieldExercicio.getText());
					exercicio.setMusculo(textFieldMusculo.getText());
					ExercicioBusiness business = ExercicioBusiness
							.getInstancia();
					business.inserirExercicio(exercicio);
					MenuProfessor tela = new MenuProfessor();
					tela.setVisible(true);
					Toast.makeText(frame, "Cadastro Inserido com Sucesso!",
							2000, Style.SUCCESS).display();
					dispose();

				}
			}
		});
		btnCadastrar.setBounds(145, 378, 111, 23);
		contentPane.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfessor tela = new MenuProfessor();
				tela.setVisible(true);
				dispose();

			}
		});
		btnCancelar.setBounds(266, 378, 89, 23);
		contentPane.add(btnCancelar);
	}

	public boolean validacaoPreenchimento() {
		if (textFieldExercicio.getText().length() == 0) {
			JOptionPane.showMessageDialog(null,
					"PREENCHA O CAMPO NOME DE EXERCÍCIO", "ATENÇÃO!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textFieldMusculo.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO MÚSCULO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			return true;
		}
	}
}
