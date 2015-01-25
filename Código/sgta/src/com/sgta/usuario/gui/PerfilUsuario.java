package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import com.sgta.treino.gui.CriarTreino;
import com.sgta.treino.gui.VisualizarTreino;
import com.sgta.usuario.negocio.SessaoUsuario;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import com.sgta.usuario.dominio.Pessoa;

public class PerfilUsuario extends JFrame {

	private JPanel contentPane;
	private MaskFormatter ftmCpf;
	private JFormattedTextField cpf;
	private Pessoa aluno;
	private JLabel lblNome;
	private JLabel lblSexo;
	private JLabel lblData;
	private JLabel lblCpf;
	private JLabel lblIdt;
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblBairro;
	private JLabel lblTelefone;
	private JLabel lblCelular;
	private JLabel lblEmail;
	private JLabel lblObs;
	private JLabel labelStatus;

	private static JLabel lblInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilUsuario frame = new PerfilUsuario();
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
	public PerfilUsuario() throws ParseException {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 489);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				if (SessaoUsuario.getInstancia().getUsuarioLogado()
						.getUsuario().getCargo().equals("Atendente")) {
					MenuAtendente tela;
					tela = new MenuAtendente();
					tela.setVisible(true);
				} else if (SessaoUsuario.getInstancia().getUsuarioLogado()
						.getUsuario().getCargo().equals("Professor")) {
					MenuProfessor tela;
					tela = new MenuProfessor();
					tela.setVisible(true);
				}
				dispose();
			}
		});

		JLabel lblPerfilDeUsurio = new JLabel("Perfil de Usu\u00E1rio");
		lblPerfilDeUsurio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPerfilDeUsurio.setBounds(10, 27, 148, 14);
		contentPane.add(lblPerfilDeUsurio);

		JLabel label = new JLabel("Nome");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setAlignmentX(0.5f);
		label.setBounds(10, 111, 46, 14);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Data de Nascimento");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setToolTipText("");
		label_1.setBounds(10, 136, 148, 14);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("Sexo");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(292, 136, 39, 14);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("CPF");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 169, 46, 14);
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("Identidade");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(198, 169, 71, 14);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("Endere\u00E7o");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(10, 203, 61, 14);
		contentPane.add(label_5);

		JLabel label_6 = new JLabel("Informe o CPF do aluno");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(9, 65, 149, 14);
		contentPane.add(label_6);

		ftmCpf = new MaskFormatter("###.###.###-##");
		cpf = new JFormattedTextField(ftmCpf);
		cpf.setColumns(10);
		cpf.setBounds(10, 80, 182, 20);
		contentPane.add(cpf);

		JButton btnVisualizarTreinos = new JButton("Visualizar Treinos");
		btnVisualizarTreinos.setBounds(139, 403, 150, 23);
		btnVisualizarTreinos.setEnabled(false);
		btnVisualizarTreinos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VisualizarTreino tela = new VisualizarTreino();
				tela.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVisualizarTreinos);

		JButton btnInserirMedidas = new JButton("Inserir Medidas");
		btnInserirMedidas.setBounds(302, 403, 137, 23);
		btnInserirMedidas.setEnabled(false);
		contentPane.add(btnInserirMedidas);
		btnInserirMedidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SessaoUsuario.getInstancia().getAlunoSelecionado() == null) {
					JOptionPane.showMessageDialog(null,
							"FAÇA UMA BUSCA DE PERFIL", "ATENÇÃO!!",
							JOptionPane.WARNING_MESSAGE);
				} else {
					if (SessaoUsuario.getInstancia().getUsuarioLogado()
							.getUsuario().getCargo().equals("Atendente")) {
						JOptionPane
								.showMessageDialog(
										null,
										"VOCÊ NÃO TEM AUTORIZAÇÃO PRA EXECUTAR ESSA FUNÇÃO",
										"ATENÇÃO!!",
										JOptionPane.WARNING_MESSAGE);
					} else {
						MenuMedidas tela = new MenuMedidas();
						tela.setVisible(true);
						setVisible(false);

					}
				}
			}
		});

		JButton btnCriarTreino = new JButton("Criar Treino");
		btnCriarTreino.setBounds(10, 403, 101, 23);
		btnCriarTreino.setEnabled(false);
		btnCriarTreino.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CriarTreino tela = new CriarTreino();
				tela.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCriarTreino);

		JButton buttonBuscar = new JButton("Buscar");
		buttonBuscar.setBounds(359, 79, 107, 23);
		contentPane.add(buttonBuscar);
		buttonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				if (cpf.getText().length() == 0 || cpf.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO CPF",
							"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);

				} else {
					try {
						aluno = business.buscarAluno(cpf.getText().toString());
						if (aluno.getNome() == null) {
							JOptionPane.showMessageDialog(null,
									"CPF não cadastrado.");
							aluno = null;

						} else {
							SessaoUsuario.getInstancia().setAlunoSelecionado(
									aluno);
							lblNome.setText(aluno.getNome());
							lblData.setText(aluno.getDataDeNascimento());
							lblSexo.setText(aluno.getSexo());
							lblCpf.setText(aluno.getCpf());
							lblIdt.setText(aluno.getIdentidade());
							lblEndereco.setText(aluno.getEndereco());
							lblNumero.setText(aluno.getNumero());
							lblComplemento.setText(aluno.getComplemento());
							lblCidade.setText(aluno.getCidade());
							lblEstado.setText(aluno.getEstado());
							lblBairro.setText(aluno.getBairro());
							lblTelefone.setText(aluno.getTelefone());
							lblCelular.setText(aluno.getCelular());
							lblEmail.setText(aluno.getEmail());
							lblObs.setText(aluno.getObservacoes());
							labelStatus.setText(aluno.getUsuario().getAtivo());

							btnCriarTreino.setEnabled(true);
							btnInserirMedidas.setEnabled(true);
							btnVisualizarTreinos.setEnabled(true);

						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel label_7 = new JLabel("N\u00FAmero");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 228, 46, 14);
		contentPane.add(label_7);

		JLabel label_8 = new JLabel("Complemento");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(198, 228, 91, 14);
		contentPane.add(label_8);

		JLabel label_9 = new JLabel("Cidade");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(10, 253, 46, 14);
		contentPane.add(label_9);

		JLabel label_10 = new JLabel("Estado");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(198, 253, 48, 14);
		contentPane.add(label_10);

		JLabel label_11 = new JLabel("Bairro");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setBounds(359, 253, 46, 14);
		contentPane.add(label_11);

		JLabel label_12 = new JLabel("Telefone");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(10, 278, 61, 14);
		contentPane.add(label_12);

		JLabel label_13 = new JLabel("Celular");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setBounds(198, 278, 52, 14);
		contentPane.add(label_13);

		JLabel label_14 = new JLabel("Email");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(10, 303, 33, 14);
		contentPane.add(label_14);

		JLabel label_15 = new JLabel("Observa\u00E7\u00F5es");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setBounds(10, 328, 86, 14);
		contentPane.add(label_15);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.setBounds(473, 403, 89, 23);
		contentPane.add(btnFechar);
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SessaoUsuario.getInstancia().getUsuarioLogado()
						.getUsuario().getCargo().equals("Atendente")) {
					MenuAtendente tela;
					tela = new MenuAtendente();
					tela.setVisible(true);
				} else if (SessaoUsuario.getInstancia().getUsuarioLogado()
						.getUsuario().getCargo().equals("Professor")) {
					MenuProfessor tela;
					tela = new MenuProfessor();
					tela.setVisible(true);
				}
				SessaoUsuario.getInstancia().setAlunoSelecionado(null);
				dispose();
			}
		});

		lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNome.setBounds(50, 111, 338, 14);
		contentPane.add(lblNome);

		lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblData.setBounds(139, 136, 143, 14);
		contentPane.add(lblData);

		lblSexo = new JLabel("");
		lblSexo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSexo.setBounds(335, 136, 131, 14);
		contentPane.add(lblSexo);

		lblCpf = new JLabel("");
		lblCpf.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCpf.setBounds(38, 169, 150, 14);
		contentPane.add(lblCpf);

		lblIdt = new JLabel("");
		lblIdt.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblIdt.setBounds(270, 169, 184, 14);
		contentPane.add(lblIdt);

		lblEndereco = new JLabel("");
		lblEndereco.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEndereco.setBounds(79, 203, 461, 14);
		contentPane.add(lblEndereco);

		lblNumero = new JLabel("");
		lblNumero.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNumero.setBounds(65, 228, 127, 14);
		contentPane.add(lblNumero);

		lblComplemento = new JLabel("");
		lblComplemento.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblComplemento.setBounds(285, 228, 221, 14);
		contentPane.add(lblComplemento);

		lblCidade = new JLabel("");
		lblCidade.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCidade.setBounds(66, 253, 126, 14);
		contentPane.add(lblCidade);

		lblEstado = new JLabel("");
		lblEstado.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEstado.setBounds(243, 253, 107, 14);
		contentPane.add(lblEstado);

		lblBairro = new JLabel("");
		lblBairro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBairro.setBounds(408, 253, 143, 14);
		contentPane.add(lblBairro);

		lblTelefone = new JLabel("");
		lblTelefone.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTelefone.setBounds(65, 278, 127, 14);
		contentPane.add(lblTelefone);

		lblCelular = new JLabel("");
		lblCelular.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCelular.setBounds(243, 278, 162, 14);
		contentPane.add(lblCelular);

		lblEmail = new JLabel("");
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEmail.setBounds(65, 303, 241, 14);
		contentPane.add(lblEmail);

		lblObs = new JLabel("");
		lblObs.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblObs.setBounds(106, 328, 417, 14);
		contentPane.add(lblObs);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStatus.setBounds(405, 111, 86, 14);
		contentPane.add(lblStatus);

		lblInfo = new JLabel("");
		lblInfo.setBounds(10, 446, 530, 14);
		contentPane.add(lblInfo);

		labelStatus = new JLabel("");
		labelStatus.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelStatus.setBounds(460, 111, 46, 14);
		contentPane.add(labelStatus);
	}

	public static void getLabelInfo(String mensagem) {
		lblInfo.setText(mensagem);
	}
}
