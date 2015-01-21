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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class RelatorioAlunoByProfessor extends JFrame {

	private JPanel contentPane;
	final static RelatorioAlunoByProfessor frame = new RelatorioAlunoByProfessor();
	private JTextArea textArea;
	UsuarioBusiness business = UsuarioBusiness.getInstancia();

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
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRelatrioDeAlunos = new JLabel(
				"Relat\u00F3rio de Alunos por Professor");
		lblRelatrioDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRelatrioDeAlunos.setBounds(10, 11, 290, 14);
		contentPane.add(lblRelatrioDeAlunos);

		JLabel lblProfessor = new JLabel("Selecione o professor:");
		lblProfessor.setBounds(10, 46, 166, 14);
		contentPane.add(lblProfessor);

		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(10, 94, 46, 14);
		contentPane.add(lblAlunos);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdm tela = new MenuAdm();
				tela.setVisible(true);
				dispose();
			}
		});
		btnFechar.setBounds(373, 342, 118, 23);
		contentPane.add(btnFechar);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 111, 481, 220);
		contentPane.add(textArea);

		List nomes = new ArrayList<String>();
		List<Pessoa> professores = business.getDao().retornaTodosProfessores();
		nomes.add("");
		if (!professores.isEmpty()) {
			for (Pessoa p : professores) {
				nomes.add(p.getNome());
			}
		}
		String[] items = (String[]) nomes.toArray(new String[nomes.size()]);
		JComboBox comboBox = new JComboBox(items);
		comboBox.setBounds(10, 63, 481, 20);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Pessoa> alunos = new ArrayList<Pessoa>();

				if (comboBox.getSelectedItem() != "") {
					try {
						alunos = business.alunosByProfessor(comboBox
								.getSelectedItem().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					if (alunos.isEmpty()) {
						textArea.setText("O professor não possui alunos!");
					} else {
						int cont = 0;
						String nomeAlunos = new String();
						for (Pessoa pessoa : alunos) {
							cont = cont + 1;
							nomeAlunos = nomeAlunos + cont + " - "
									+ pessoa.getNome() + " \n";
						}
						textArea.setText(nomeAlunos);
					}
				}
			}
		});
	}
}
