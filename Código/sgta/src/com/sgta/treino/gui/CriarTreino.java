package com.sgta.treino.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

import com.sgta.exercicio.dominio.Exercicio;
import com.sgta.exercicio.negocio.ExercicioBusiness;
import com.sgta.usuario.dominio.Pessoa;

public class CriarTreino extends JFrame {

	private JPanel contentPane;
	private JTextField treino;
	private JFormattedTextField DataDeFim;
	private JFormattedTextField DatadeInicio;
	private MaskFormatter ftmData;
	private ExercicioBusiness exercicioBusiness = ExercicioBusiness.getInstancia();
	private JTextField textFieldExercicio;
	private JTextField series;
	private JTextField repeticoes;
	private JTextField carga;
	private String exercicio;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarTreino frame = new CriarTreino();
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
	public CriarTreino() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCriaoDeTreino = new JLabel("Cria\u00E7\u00E3o de Treino");
		lblCriaoDeTreino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCriaoDeTreino.setBounds(10, 11, 151, 14);
		contentPane.add(lblCriaoDeTreino);
		
		JLabel lblNomeDoTreino = new JLabel("Nome do treino");
		lblNomeDoTreino.setBounds(10, 47, 164, 14);
		contentPane.add(lblNomeDoTreino);
		
		treino = new JTextField();
		treino.setBounds(100, 44, 127, 20);
		contentPane.add(treino);
		treino.setColumns(10);
		
		JLabel lblExerccios = new JLabel("Exerc\u00EDcios");
		lblExerccios.setBounds(10, 112, 94, 14);
		contentPane.add(lblExerccios);
		
		List exercicios = new ArrayList<String>();
		List<Exercicio> exerciciosList = exercicioBusiness.retornaTodosExercicios();
		exercicios.add("");
		if (!exerciciosList.isEmpty()) {
			for (Exercicio e : exerciciosList) {
				exercicios.add(e.getNome());
			}
		}
		String[] items = (String[]) exercicios.toArray(new String[exercicios.size()]);
		JComboBox comboBoxExercicio = new JComboBox(items);
		comboBoxExercicio.setBounds(100, 109, 127, 20);
		contentPane.add(comboBoxExercicio);
		comboBoxExercicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				exercicio = (String) comboBoxExercicio.getSelectedItem();
				textFieldExercicio.setText(exercicio);
				
			}
		});
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(212, 167, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBounds(343, 167, 89, 23);
		contentPane.add(btnRemover);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 216, 439, 198);
		contentPane.add(textArea);
		try {
			ftmData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JLabel lblDataDeInicio = new JLabel("Data de In\u00EDcio");
		lblDataDeInicio.setBounds(247, 47, 99, 14);
		contentPane.add(lblDataDeInicio);
		
		DatadeInicio = new JFormattedTextField(ftmData);
		DatadeInicio.setBounds(328, 44, 94, 20);
		contentPane.add(DatadeInicio);
		
		JLabel lblDataDeFim = new JLabel("Data de Fim");
		lblDataDeFim.setBounds(245, 72, 89, 14);
		contentPane.add(lblDataDeFim);
		
		DataDeFim = new JFormattedTextField(ftmData);
		DataDeFim.setBounds(328, 72, 94, 20);
		contentPane.add(DataDeFim);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setBounds(212, 425, 89, 23);
		contentPane.add(btnCriar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(343, 425, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblExercicio = new JLabel("Exercicio");
		lblExercicio.setBounds(10, 143, 80, 14);
		contentPane.add(lblExercicio);
		
		textFieldExercicio = new JTextField();
		textFieldExercicio.setEditable(false);
		textFieldExercicio.setBounds(100, 137, 127, 20);
		contentPane.add(textFieldExercicio);
		textFieldExercicio.setColumns(10);
		
		JLabel lblSeries = new JLabel("S\u00E9ries");
		lblSeries.setBounds(237, 142, 46, 14);
		contentPane.add(lblSeries);
		
		series = new JTextField();
		series.setBounds(276, 136, 25, 20);
		contentPane.add(series);
		series.setColumns(10);
		
		JLabel lblRepeticoes = new JLabel("Repeti\u00E7\u00F5es");
		lblRepeticoes.setBounds(304, 140, 89, 14);
		contentPane.add(lblRepeticoes);
		
		repeticoes = new JTextField();
		repeticoes.setBounds(376, 137, 25, 20);
		contentPane.add(repeticoes);
		repeticoes.setColumns(10);
		
		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setBounds(403, 140, 46, 14);
		contentPane.add(lblCarga);
		
		carga = new JTextField();
		carga.setBounds(449, 137, 25, 20);
		contentPane.add(carga);
		carga.setColumns(10);
		
		JLabel lblkg = new JLabel("(Kg)");
		lblkg.setBounds(484, 143, 46, 14);
		contentPane.add(lblkg);
	}
}
