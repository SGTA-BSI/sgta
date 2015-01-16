package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MenuMedidas extends JFrame {

	private JPanel contentPane;
	private JTextField textAltura;
	private JTextField textPanturrilhas;
	private JTextField textBracos;
	private JTextField textCoxas;
	private JTextField textAntebracos;
	private JTextField textPeitoral;
	private JTextField textCostas;
	private JTextField textTrapezio;
	private JTextField textCintura;
	private JTextField textPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMedidas frame = new MenuMedidas();
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
	public MenuMedidas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(22, 12, 60, 15);
		contentPane.add(lblAluno);
		
		JLabel lblCampoNome = new JLabel("");
		lblCampoNome.setBounds(81, 12, 221, 15);
		contentPane.add(lblCampoNome);
		
		JLabel lblMedidas = new JLabel("Medidas:");
		lblMedidas.setBounds(22, 42, 70, 15);
		contentPane.add(lblMedidas);
		
		JLabel lblAltura = new JLabel("Altura (m):");
		lblAltura.setBounds(22, 75, 134, 15);
		contentPane.add(lblAltura);
		
		textAltura = new JTextField();
		textAltura.setBounds(22, 93, 134, 19);
		contentPane.add(textAltura);
		textAltura.setColumns(10);
		
		textPanturrilhas = new JTextField();
		textPanturrilhas.setBounds(22, 215, 134, 19);
		contentPane.add(textPanturrilhas);
		textPanturrilhas.setColumns(10);
		
		textBracos = new JTextField();
		textBracos.setBounds(22, 135, 134, 19);
		contentPane.add(textBracos);
		textBracos.setColumns(10);
		
		JLabel labelPanturrilhas = new JLabel("Panturrilhas (cm):");
		labelPanturrilhas.setBounds(22, 195, 134, 15);
		contentPane.add(labelPanturrilhas);
		
		JLabel labelPeso = new JLabel("Peso (kg):");
		labelPeso.setBounds(168, 75, 134, 15);
		contentPane.add(labelPeso);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(46, 287, 107, 25);
		contentPane.add(btnCancelar);
		
		JLabel labelBraços = new JLabel("Braços (cm):");
		labelBraços.setBounds(22, 115, 134, 15);
		contentPane.add(labelBraços);
		
		JLabel labelCoxas = new JLabel("Coxas (cm):");
		labelCoxas.setBounds(22, 157, 134, 15);
		contentPane.add(labelCoxas);
		
		textCoxas = new JTextField();
		textCoxas.setColumns(10);
		textCoxas.setBounds(22, 174, 134, 19);
		contentPane.add(textCoxas);
		
		JLabel lblAntebraços = new JLabel("Antebraços (cm):");
		lblAntebraços.setBounds(22, 237, 134, 15);
		contentPane.add(lblAntebraços);
		
		textAntebracos = new JTextField();
		textAntebracos.setColumns(10);
		textAntebracos.setBounds(22, 256, 134, 19);
		contentPane.add(textAntebracos);
		
		JLabel labelPeitoral = new JLabel("Peitoral (cm):");
		labelPeitoral.setBounds(168, 115, 134, 15);
		contentPane.add(labelPeitoral);
		
		textPeitoral = new JTextField();
		textPeitoral.setColumns(10);
		textPeitoral.setBounds(168, 135, 134, 19);
		contentPane.add(textPeitoral);
		
		JLabel labelCostas = new JLabel("Costas (cm):");
		labelCostas.setBounds(168, 157, 134, 15);
		contentPane.add(labelCostas);
		
		textCostas = new JTextField();
		textCostas.setColumns(10);
		textCostas.setBounds(168, 174, 134, 19);
		contentPane.add(textCostas);
		
		JLabel labelTrapezio = new JLabel("Trapézio (cm):");
		labelTrapezio.setBounds(168, 195, 134, 15);
		contentPane.add(labelTrapezio);
		
		textTrapezio = new JTextField();
		textTrapezio.setColumns(10);
		textTrapezio.setBounds(168, 215, 134, 19);
		contentPane.add(textTrapezio);
		
		textCintura = new JTextField();
		textCintura.setColumns(10);
		textCintura.setBounds(168, 256, 134, 19);
		contentPane.add(textCintura);
		
		JLabel labelCintura = new JLabel("Cintura (cm):");
		labelCintura.setBounds(168, 237, 134, 15);
		contentPane.add(labelCintura);
		
		textPeso = new JTextField();
		textPeso.setColumns(10);
		textPeso.setBounds(168, 93, 134, 19);
		contentPane.add(textPeso);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(168, 287, 107, 25);
		contentPane.add(btnSalvar);
	}
}
