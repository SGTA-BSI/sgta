package com.sgta.treino.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.sgta.exercicio.dominio.Exercicio;
import com.sgta.exercicio.negocio.ExercicioBusiness;
import com.sgta.treino.dominio.RelacaoTreinoExercicio;
import com.sgta.treino.dominio.Treino;
import com.sgta.treino.negocio.TreinoBusiness;
import com.sgta.usuario.gui.PerfilUsuario;
import com.sgta.usuario.gui.Toast;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.SessaoUsuario;

public class CriarTreino extends JFrame {

	private JPanel contentPane;
	private JTextField treino;
	private JFormattedTextField DataDeFim;
	private JFormattedTextField DatadeInicio;
	private MaskFormatter ftmData;
	private ExercicioBusiness exercicioBusiness = ExercicioBusiness
			.getInstancia();
	private JTextField series;
	private JTextField repeticoes;
	private JTextField carga;
	private String exercicio;
	private static CriarTreino frame = new CriarTreino();
	private String nomeTreino;

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
	public CriarTreino() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 384, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCriaoDeTreino = new JLabel("Cria\u00E7\u00E3o de Treino");
		lblCriaoDeTreino.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCriaoDeTreino.setBounds(10, 11, 151, 14);
		contentPane.add(lblCriaoDeTreino);

		JLabel lblNomeDoTreino = new JLabel("Nome do treino");
		lblNomeDoTreino.setBounds(10, 31, 164, 14);
		contentPane.add(lblNomeDoTreino);

		treino = new JTextField();
		treino.setBounds(10, 44, 217, 20);
		contentPane.add(treino);
		treino.setColumns(10);

		JLabel lblExerccios = new JLabel("Exerc\u00EDcios");
		lblExerccios.setBounds(10, 202, 94, 14);
		contentPane.add(lblExerccios);

		List exercicios = new ArrayList<String>();
		List<Exercicio> exerciciosList = exercicioBusiness
				.retornaTodosExercicios();
		exercicios.add("");
		if (!exerciciosList.isEmpty()) {
			for (Exercicio e : exerciciosList) {
				exercicios.add(e.getNome());
			}
		}
		String[] items = (String[]) exercicios.toArray(new String[exercicios
				.size()]);
		JComboBox comboBoxExercicio = new JComboBox(items);
		comboBoxExercicio.setBounds(10, 219, 343, 20);
		contentPane.add(comboBoxExercicio);
		comboBoxExercicio.setEnabled(false);

		try {
			ftmData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		JLabel lblDataDeInicio = new JLabel("Data de In\u00EDcio");
		lblDataDeInicio.setBounds(10, 75, 99, 14);
		contentPane.add(lblDataDeInicio);

		DatadeInicio = new JFormattedTextField(ftmData);
		DatadeInicio.setBounds(10, 88, 217, 20);
		contentPane.add(DatadeInicio);

		JLabel lblDataDeFim = new JLabel("Data de Fim");
		lblDataDeFim.setBounds(10, 121, 89, 14);
		contentPane.add(lblDataDeFim);

		DataDeFim = new JFormattedTextField(ftmData);
		DataDeFim.setBounds(10, 133, 217, 20);
		contentPane.add(DataDeFim);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(264, 391, 89, 23);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					PerfilUsuario tela = new PerfilUsuario();
					tela.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(btnVoltar);

		JLabel lblSeries = new JLabel("S\u00E9ries");
		lblSeries.setBounds(10, 250, 46, 14);
		contentPane.add(lblSeries);

		series = new JTextField();
		series.setBounds(10, 264, 89, 20);
		contentPane.add(series);
		series.setColumns(10);
		series.setEnabled(false);

		JLabel lblRepeticoes = new JLabel("Repeti\u00E7\u00F5es");
		lblRepeticoes.setBounds(119, 250, 89, 14);
		contentPane.add(lblRepeticoes);

		repeticoes = new JTextField();
		repeticoes.setBounds(119, 264, 89, 20);
		contentPane.add(repeticoes);
		repeticoes.setColumns(10);
		repeticoes.setEnabled(false);

		JLabel lblCarga = new JLabel("Carga");
		lblCarga.setBounds(232, 250, 46, 14);
		contentPane.add(lblCarga);

		carga = new JTextField();
		carga.setBounds(232, 264, 89, 20);
		contentPane.add(carga);
		carga.setColumns(10);
		carga.setEnabled(false);

		JLabel lblkg = new JLabel("(Kg)");
		lblkg.setBounds(331, 267, 37, 14);
		contentPane.add(lblkg);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 164, 343, 2);
		contentPane.add(separator);

		JLabel lblAdicionarExerccios = new JLabel("Adicionar Exerc\u00EDcios");
		lblAdicionarExerccios.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAdicionarExerccios.setBounds(10, 177, 233, 14);
		contentPane.add(lblAdicionarExerccios);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(10, 296, 89, 23);
		btnAdicionar.setEnabled(false);
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TreinoBusiness business = TreinoBusiness.getInstancia();
				ExercicioBusiness exercicioBusiness = ExercicioBusiness
						.getInstancia();
				if (comboBoxExercicio.getSelectedItem().toString().equals("")) {
					Toast.makeText(frame, "Selecione um  exercício.", 2000,
							Style.ERROR).display();
				} else if (series.getText().equals("")) {
					Toast.makeText(frame, "Informe a quantidade de séries.",
							2000, Style.ERROR).display();
				} else if (carga.getText().equals("")) {
					Toast.makeText(frame, "Informe o valor da carga.", 2000,
							Style.ERROR).display();
				} else if (repeticoes.getText().equals("")) {
					Toast.makeText(frame,
							"Informe a quantidade de repetições.", 2000,
							Style.ERROR).display();
				} else {
					Treino treino = business.buscarTreino(nomeTreino);
					Exercicio exercicio = exercicioBusiness
							.retornaExercicio(comboBoxExercicio
									.getSelectedItem().toString());
					RelacaoTreinoExercicio relacao = new RelacaoTreinoExercicio();
					relacao.setCarga(Integer
							.valueOf(carga.getText().toString()));
					relacao.setRepeticao(Integer.valueOf(repeticoes.getText()
							.toString()));
					relacao.setSerie(Integer.valueOf(series.getText()
							.toString()));
					relacao.setIdAluno(SessaoUsuario.getInstancia()
							.getAlunoSelecionado().getUsuario().getId());
					relacao.setIdExercicio(exercicio.getId());
					relacao.setIdTreino(treino.getId());

					business.inserirExerciciosTreino(relacao);

					Toast.makeText(frame, "Exercício inserido com sucesso!",
							2000, Style.SUCCESS).display();

					carga.setText("");
					series.setText("");
					repeticoes.setText("");
					comboBoxExercicio.setSelectedIndex(0);

				}
			}
		});
		contentPane.add(btnAdicionar);

		JButton btnCriarTreino = new JButton("Criar Treino");
		btnCriarTreino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DatadeInicio.getText().equals("  /  /    ")) {
					Toast.makeText(frame, "Informe o início do treino", 2000,
							Style.ERROR).display();
				} else if (DataDeFim.getText().equals("  /  /    ")) {
					Toast.makeText(frame, "Informe o fim do treino", 2000,
							Style.ERROR).display();
				} else if (treino.getText().equals("")) {
					Toast.makeText(frame, "Informe o nome do treino", 2000,
							Style.ERROR).display();
				} else {

					SimpleDateFormat formatter = new SimpleDateFormat(
							"dd/MM/yyyy");
					Date dataInicio = new Date();
					Date dataFim = new Date();
					try {
						dataInicio = formatter.parse(DatadeInicio.getText()
								.toString());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					try {
						dataFim = formatter.parse(DataDeFim.getText()
								.toString());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}

					Treino treinoInserido = new Treino();
					treinoInserido.setNome(treino.getText().toString());
					treinoInserido.setDataInicio(dataInicio);
					treinoInserido.setDataFim(dataFim);
					treinoInserido.setUsuario(SessaoUsuario.getInstancia()
							.getAlunoSelecionado().getUsuario());

					TreinoBusiness business = TreinoBusiness.getInstancia();
					business.inserirTreino(treinoInserido);

					lblAdicionarExerccios.setText("Adicionar Exercícios - "
							+ treinoInserido.getNome());

					treino.setEnabled(false);
					DatadeInicio.setEnabled(false);
					DataDeFim.setEnabled(false);
					btnCriarTreino.setEnabled(false);
					repeticoes.setEnabled(true);
					carga.setEnabled(true);
					series.setEnabled(true);
					comboBoxExercicio.setEnabled(true);
					btnAdicionar.setEnabled(true);

					nomeTreino = treinoInserido.getNome();
				}
			}
		});
		btnCriarTreino.setBounds(247, 57, 121, 51);
		contentPane.add(btnCriarTreino);

	}
}
