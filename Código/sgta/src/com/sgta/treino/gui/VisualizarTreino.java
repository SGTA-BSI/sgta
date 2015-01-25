package com.sgta.treino.gui;

import java.awt.EventQueue;
import java.awt.Font;
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

import com.sgta.treino.dominio.RelacaoTreinoExercicio;
import com.sgta.treino.dominio.Treino;
import com.sgta.treino.negocio.TreinoBusiness;
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
		
		
		JComboBox comboBoxTreinos = new JComboBox(items);
		comboBoxTreinos.setBounds(10, 52, 442, 20);
		contentPane.add(comboBoxTreinos);
		

		JComboBox comboBoxExercicios = new JComboBox();
		comboBoxExercicios.setBounds(10, 98, 442, 20);
		contentPane.add(comboBoxExercicios);

		JLabel lblExercicios = new JLabel("Exerc\u00EDcios");
		lblExercicios.setBounds(10, 83, 116, 14);
		contentPane.add(lblExercicios);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 144, 442, 175);
		contentPane.add(textArea);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(340, 341, 89, 23);
		contentPane.add(btnFechar);

	}
}
