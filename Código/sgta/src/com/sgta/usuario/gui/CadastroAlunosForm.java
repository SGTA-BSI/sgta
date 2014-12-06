package com.sgta.usuario.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Component;

public class CadastroAlunosForm extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField data;
	private JTextField cpf;
	private JTextField identidade;
	private JTextField endereco;
	private JTextField numero;
	private JTextField complemento;
	private JTextField cidade;
	private JTextField estado;
	private JTextField bairro;
	private JTextField telefone;
	private JTextField celular;
	private JTextField email;
	private JTextField observacoes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAlunosForm frame = new CadastroAlunosForm();
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
	public CadastroAlunosForm() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 492);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCadastroDeAlunos = new JLabel("Cadastro de Alunos");
		lblCadastroDeAlunos.setBounds(15, 16, 126, 14);
		lblCadastroDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblCadastroDeAlunos);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(15, 39, 126, 14);
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNome);
		
		nome = new JTextField();
		nome.setBounds(53, 36, 453, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(15, 67, 148, 14);
		lblDataDeNascimento.setToolTipText("");
		contentPane.add(lblDataDeNascimento);
		
		data = new JTextField();
		data.setBounds(136, 64, 91, 20);
		contentPane.add(data);
		data.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(272, 67, 39, 14);
		contentPane.add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setBounds(321, 67, 142, 20);
		contentPane.add(comboBoxSexo);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(15, 102, 46, 14);
		contentPane.add(lblCpf);
		
		cpf = new JTextField();
		cpf.setBounds(42, 98, 121, 20);
		contentPane.add(cpf);
		cpf.setColumns(10);
		
		JLabel lblIdentidade = new JLabel("Identidade");
		lblIdentidade.setBounds(189, 102, 71, 14);
		contentPane.add(lblIdentidade);
		
		identidade = new JTextField();
		identidade.setBounds(251, 100, 86, 20);
		contentPane.add(identidade);
		identidade.setColumns(10);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(15, 134, 61, 14);
		contentPane.add(lblEndereco);
		
		endereco = new JTextField();
		endereco.setBounds(71, 131, 424, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(15, 168, 46, 14);
		contentPane.add(lblNumero);
		
		numero = new JTextField();
		numero.setBounds(77, 165, 86, 20);
		contentPane.add(numero);
		numero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(169, 168, 91, 14);
		contentPane.add(lblComplemento);
		
		complemento = new JTextField();
		complemento.setBounds(251, 165, 244, 20);
		contentPane.add(complemento);
		complemento.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(15, 194, 46, 14);
		contentPane.add(lblCidade);
		
		cidade = new JTextField();
		cidade.setBounds(59, 191, 86, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(169, 194, 48, 14);
		contentPane.add(lblEstado);
		
		estado = new JTextField();
		estado.setBounds(251, 191, 86, 20);
		contentPane.add(estado);
		estado.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(347, 194, 46, 14);
		contentPane.add(lblBairro);
		
		bairro = new JTextField();
		bairro.setBounds(393, 191, 102, 20);
		contentPane.add(bairro);
		bairro.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(15, 225, 61, 14);
		contentPane.add(lblTelefone);
		
		telefone = new JTextField();
		telefone.setBounds(69, 219, 137, 20);
		contentPane.add(telefone);
		telefone.setColumns(10);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(218, 222, 52, 14);
		contentPane.add(lblCelular);
		
		celular = new JTextField();
		celular.setBounds(261, 222, 157, 20);
		contentPane.add(celular);
		celular.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 259, 33, 14);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setBounds(53, 256, 242, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(15, 290, 86, 14);
		contentPane.add(lblObservacoes);
		
		observacoes = new JTextField();
		observacoes.setBounds(109, 287, 408, 77);
		contentPane.add(observacoes);
		observacoes.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(158, 400, 126, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(310, 400, 121, 23);
		contentPane.add(btnCancelar);
	}
}
