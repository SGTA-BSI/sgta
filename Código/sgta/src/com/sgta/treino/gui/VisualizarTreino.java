package com.sgta.treino.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.html.HTML;

import com.sgta.exercicio.dominio.Exercicio;
import com.sgta.exercicio.negocio.ExercicioBusiness;
import com.sgta.treino.dominio.RelacaoTreinoExercicio;
import com.sgta.treino.dominio.Treino;
import com.sgta.treino.negocio.TreinoBusiness;
import com.sgta.usuario.gui.PerfilUsuario;
import com.sgta.usuario.negocio.SessaoUsuario;

public class VisualizarTreino extends JFrame {

	private JPanel contentPane;
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
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblVisualizaoDeTreinos = new JLabel(
				"Visualiza\u00E7\u00E3o de Treinos");
		lblVisualizaoDeTreinos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVisualizaoDeTreinos.setBounds(10, 11, 178, 14);
		contentPane.add(lblVisualizaoDeTreinos);

		try {
			ftmCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel lblTreinos = new JLabel("Treinos");
		lblTreinos.setBounds(10, 35, 46, 14);
		contentPane.add(lblTreinos);

		TreinoBusiness treinoBusiness = TreinoBusiness.getInstancia();

		List<RelacaoTreinoExercicio> relacaoTreinos = treinoBusiness
				.buscarRelacao(SessaoUsuario.getInstancia()
						.getAlunoSelecionado().getUsuario().getId());

		List<Treino> treinos = treinoBusiness.listaTreinos(SessaoUsuario
				.getInstancia().getAlunoSelecionado().getUsuario().getId());

		List<String> nomeTreinos = new ArrayList<String>();

		if (!treinos.isEmpty()) {
			for (Treino t : treinos) {
				nomeTreinos.add(t.getNome());
			}
		}

		String[] items = (String[]) nomeTreinos.toArray(new String[nomeTreinos
				.size()]);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 83, 442, 258);
		textArea.setEditable(false);
		contentPane.add(textArea);

		JComboBox comboBoxTreinos = new JComboBox(items);
		comboBoxTreinos.setBounds(10, 52, 442, 20);
		comboBoxTreinos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String exerc = "";
				for (Treino t : treinos) {
					if (comboBoxTreinos.getSelectedItem().toString()
							.equals(t.getNome())) {
						for (RelacaoTreinoExercicio r : relacaoTreinos) {
							if (r.getIdTreino() == t.getId()) {
								ExercicioBusiness exercicioBusiness = ExercicioBusiness
										.getInstancia();
								Exercicio exercicio = exercicioBusiness
										.retornaExercicioByID(r
												.getIdExercicio());
								String text = exercicio.getNome() + "\n"
										+ "Carga: " + r.getCarga() + "\n"
										+ "Séries: " + r.getSerie() + "\n"
										+ "Repeticões: " + r.getRepeticao()
										+ "\n\n";
								exerc = exerc + text;
							}
						}
					}
				}
				textArea.setText(exerc);
			}
		});
		contentPane.add(comboBoxTreinos);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFechar.setBounds(363, 352, 89, 23);
		btnFechar.addActionListener(new ActionListener() {

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
		contentPane.add(btnFechar);
	}
}
