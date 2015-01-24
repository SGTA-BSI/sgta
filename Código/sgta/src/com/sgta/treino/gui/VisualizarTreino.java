package com.sgta.treino.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class VisualizarTreino extends JFrame {

	private JPanel contentPane;
	private JTextField treino;
	private JFormattedTextField cpf;
	private MaskFormatter ftmCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarTreino frame = new VisualizarTreino();
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
	public VisualizarTreino() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 468, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVisualizaoDeTreinos = new JLabel("Visualiza\u00E7\u00E3o de Treinos");
		lblVisualizaoDeTreinos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVisualizaoDeTreinos.setBounds(10, 11, 178, 14);
		contentPane.add(lblVisualizaoDeTreinos);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 41, 46, 14);
		contentPane.add(lblCpf);
		
		try {
			ftmCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(39, 36, 144, 20);
		contentPane.add(cpf);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(219, 35, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblTreinos = new JLabel("Treinos");
		lblTreinos.setBounds(10, 78, 46, 14);
		contentPane.add(lblTreinos);
		
		JComboBox comboBoxTreinos = new JComboBox();
		comboBoxTreinos.setBounds(59, 75, 123, 20);
		contentPane.add(comboBoxTreinos);
		
		JLabel lblTreino = new JLabel("Treino");
		lblTreino.setBounds(10, 115, 46, 14);
		contentPane.add(lblTreino);
		
		treino = new JTextField();
		treino.setBounds(59, 112, 124, 20);
		contentPane.add(treino);
		treino.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 155, 419, 175);
		contentPane.add(textArea);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(340, 341, 89, 23);
		contentPane.add(btnFechar);
	}

}
