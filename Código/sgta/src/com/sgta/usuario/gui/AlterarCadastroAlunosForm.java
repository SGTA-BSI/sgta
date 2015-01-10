package com.sgta.usuario.gui;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.dominio.Usuario;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;

public class AlterarCadastroAlunosForm extends JFrame {

	Pessoa aluno;

	private JPanel contentPane;
	private JTextField nome;
	private JTextField identidade;
	private JTextField endereco;
	private JTextField numero;
	private JTextField complemento;
	private JTextField cidade;
	private JTextField estado;
	private JTextField bairro;
	private JTextField email;
	private JTextField observacoes;

	private JFormattedTextField data;
	private JFormattedTextField celular;
	private JFormattedTextField cpf;
	private JFormattedTextField telefone;

	private MaskFormatter ftmData;
	private MaskFormatter ftmCpf;
	private MaskFormatter ftmTelefone;
	private MaskFormatter ftmCelular;

	private String sexo;
	private String ativo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarCadastroAlunosForm frame = new AlterarCadastroAlunosForm();
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
	public AlterarCadastroAlunosForm() throws ParseException {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeAlunos = new JLabel("Alterar Cadastro");
		lblCadastroDeAlunos.setBounds(10, 11, 126, 14);
		lblCadastroDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblCadastroDeAlunos);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 92, 126, 14);
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNome);

		nome = new JTextField();
		nome.setBounds(10, 110, 464, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		// Formatação da data
		ftmData = new MaskFormatter("##/##/####");

		data = new JFormattedTextField(ftmData);
		data.setBounds(10, 159, 202, 20);
		contentPane.add(data);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 141, 148, 14);
		lblDataDeNascimento.setToolTipText("");
		contentPane.add(lblDataDeNascimento);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(233, 141, 39, 14);
		contentPane.add(lblSexo);

		// Atribuir valores ao comboBox
		String[] items = { "Selecione o Sexo", "Masculino", "Feminino" };
		JComboBox comboBoxSexo = new JComboBox(items);
		comboBoxSexo.setBounds(233, 159, 241, 20);
		contentPane.add(comboBoxSexo);
		// --------------
		comboBoxSexo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxSexo.getSelectedItem() == "Selecione o Sexo") {
					sexo = "";
				} else if (comboBoxSexo.getSelectedItem() == "Masculino") {
					sexo = "Masculino";
				} else if (comboBoxSexo.getSelectedItem() == "Feminino") {
					sexo = "Feminino";
				}
			}
		});

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 190, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblIdentidade = new JLabel("Identidade");
		lblIdentidade.setBounds(233, 190, 71, 14);
		contentPane.add(lblIdentidade);

		identidade = new JTextField();
		identidade.setBounds(233, 206, 241, 20);
		contentPane.add(identidade);
		identidade.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(10, 235, 61, 14);
		contentPane.add(lblEndereco);

		endereco = new JTextField();
		endereco.setBounds(10, 251, 464, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(10, 282, 46, 14);
		contentPane.add(lblNumero);

		numero = new JTextField();
		numero.setBounds(10, 297, 86, 20);
		contentPane.add(numero);
		numero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(120, 282, 91, 14);
		contentPane.add(lblComplemento);

		complemento = new JTextField();
		complemento.setBounds(120, 297, 354, 20);
		contentPane.add(complemento);
		complemento.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 328, 46, 14);
		contentPane.add(lblCidade);

		cidade = new JTextField();
		cidade.setBounds(10, 342, 138, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(167, 328, 48, 14);
		contentPane.add(lblEstado);

		estado = new JTextField();
		estado.setBounds(167, 342, 137, 20);
		contentPane.add(estado);
		estado.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(325, 328, 46, 14);
		contentPane.add(lblBairro);

		bairro = new JTextField();
		bairro.setBounds(325, 342, 149, 20);
		contentPane.add(bairro);
		bairro.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 373, 61, 14);
		contentPane.add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(233, 373, 52, 14);
		contentPane.add(lblCelular);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 420, 33, 14);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setBounds(10, 434, 464, 20);
		contentPane.add(email);
		email.setColumns(10);

		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(10, 465, 86, 14);
		contentPane.add(lblObservacoes);

		observacoes = new JTextField();
		observacoes.setBounds(10, 479, 464, 77);
		contentPane.add(observacoes);
		observacoes.setColumns(10);

		// Formatação do cpf
		ftmCpf = new MaskFormatter("###.###.###-##");

		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(10, 206, 202, 20);
		contentPane.add(cpf);

		// Formatação do telefone
		ftmTelefone = new MaskFormatter("(##)####-####");
		telefone = new JFormattedTextField(ftmTelefone);
		telefone.setBounds(10, 388, 202, 20);
		contentPane.add(telefone);

		// Formatação do celular
		ftmCelular = new MaskFormatter("(##)####-####");
		celular = new JFormattedTextField(ftmCelular);
		celular.setBounds(233, 389, 241, 20);
		contentPane.add(celular);

		JButton btnCadastrar = new JButton("Alterar Cadastro");
		btnCadastrar.setBounds(205, 578, 138, 23);
		contentPane.add(btnCadastrar);
		
		
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				MenuAtendente tela;
				if (validacaoPreenchimento()) {
					try {
						alterarCadastro();
						JOptionPane.showMessageDialog(null,
								"Cadastro alterado.");
						aluno = null;
						nome.setText("");
						data.setText("");
						cpf.setText("");
						identidade.setText("");
						endereco.setText("");
						numero.setText("");
						complemento.setText("");
						cidade.setText("");
						estado.setText("");
						bairro.setText("");
						telefone.setText("");
						celular.setText("");
						email.setText("");
						observacoes.setText("");

					} catch (HeadlessException e1) {
						JOptionPane.showMessageDialog(null, "Erro");
					}

				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(353, 578, 121, 23);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfessor tela;
				tela = new MenuProfessor();
				tela.setVisible(true);
				setVisible(false);
			}
		});

		textField = new JFormattedTextField(ftmCpf);
		textField.setBounds(13, 53, 182, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblInformeOCpf = new JLabel("Informe o CPF do aluno");
		lblInformeOCpf.setBounds(12, 38, 149, 14);
		contentPane.add(lblInformeOCpf);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(205, 52, 88, 23);
		contentPane.add(btnBuscar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 85, 464, 9);
		contentPane.add(separator);
		
		JLabel label = new JLabel("Ativar/Desativar Usu\u00E1rio");
		label.setBounds(325, 38, 138, 14);
		contentPane.add(label);
		
		String[] ativoItems = {"Selecione uma opção", "Ativar", "Desativar"};
		JComboBox comboBoxAtivar = new JComboBox();
		comboBoxAtivar.setBounds(325, 53, 149, 20);
		contentPane.add(comboBoxAtivar);
		comboBoxAtivar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxSexo.getSelectedItem() == "Selecione uma opção") {
					ativo = "";
				} else if (comboBoxSexo.getSelectedItem() == "Ativar") {
					ativo = "Ativo";
				} else if (comboBoxSexo.getSelectedItem() == "Desativar") {
					ativo = "Desativo";
				}
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				try {
					aluno = business
							.buscarAluno(textField.getText().toString());
					if (aluno.getNome() == null) {
						JOptionPane.showMessageDialog(null,
								"CPF não cadastrado.");
						aluno = null;
						nome.setText("");
						data.setText("");
						cpf.setText("");
						identidade.setText("");
						endereco.setText("");
						numero.setText("");
						complemento.setText("");
						cidade.setText("");
						estado.setText("");
						bairro.setText("");
						telefone.setText("");
						celular.setText("");
						email.setText("");
						observacoes.setText("");
					} else {
						nome.setText(aluno.getNome());
						data.setText(aluno.getDataDeNascimento());
						cpf.setText(aluno.getCpf());
						identidade.setText(aluno.getIdentidade());
						endereco.setText(aluno.getEndereco());
						numero.setText(aluno.getNumero());
						complemento.setText(aluno.getComplemento());
						cidade.setText(aluno.getCidade());
						estado.setText(aluno.getEstado());
						bairro.setText(aluno.getBairro());
						telefone.setText(aluno.getTelefone());
						celular.setText(aluno.getCelular());
						email.setText(aluno.getEmail());
						observacoes.setText(aluno.getObservacoes());

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	private void alterarCadastro() {
		Pessoa pessoa = new Pessoa();

		pessoa.setUsuario(aluno.getUsuario());
		pessoa.getUsuario().setId(aluno.getUsuario().getId());
		pessoa.getUsuario().setAtivo(ativo);

		pessoa.setBairro(bairro.getText());
		pessoa.setCelular(celular.getText());
		pessoa.setCidade(cidade.getText());
		pessoa.setComplemento(complemento.getText());
		pessoa.setCpf(cpf.getText());
		pessoa.setDataDeNascimento(data.getText());
		pessoa.setEmail(email.getText());
		pessoa.setEndereco(endereco.getText());
		pessoa.setEstado(estado.getText());
		pessoa.setIdentidade(identidade.getText());
		pessoa.setNome(nome.getText());
		pessoa.setNumero(numero.getText());
		pessoa.setObservacoes(observacoes.getText());
		pessoa.setSexo(sexo); // Falta recuperar o valor de Sexo!!!
		pessoa.setTelefone(telefone.getText());

		UsuarioBusiness business = UsuarioBusiness.getInstancia();
		business.alterarAluno(pessoa);

	}

	public boolean validacaoPreenchimento() {
		if (nome.getText().length() == 0 || nome.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE NOME",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			nome.requestFocus();
			return false;
		} else if (data.getText().length() == 0 || data.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null,
					"PREENCHA O CAMPO DE DATA DE NASCIMENTO", "ATENÇÃO!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (sexo == null || sexo.equals("")) {
			JOptionPane.showMessageDialog(null, "SELECIONE O SEXO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (cpf.getText().length() == 0 || cpf.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CPF",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (identidade.getText().length() == 0
				|| identidade.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null,
					"PREENCHA O CAMPO DE IDENTIDADE", "ATENÇÃO!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (endereco.getText().length() == 0
				|| endereco.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE ENDEREçO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (numero.getText().length() == 0
				|| numero.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE NUMERO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (cidade.getText().length() == 0
				|| cidade.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CIDADE",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (estado.getText().length() == 0
				|| estado.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE ESTADO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (bairro.getText().length() == 0
				|| bairro.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE BAIRRO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (telefone.getText().length() == 0
				|| telefone.getText().equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE TELEFONE",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (celular.getText().length() == 0
				|| celular.getText().equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CELULAR",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (email.getText().length() == 0 || email.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE EMAIL",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (validarEmail(email.getText()) == false) {
			JOptionPane.showMessageDialog(null,
					"PREENCHA O CAMPO DE EMAIL NO FORMATO email@email.com",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if(ativo == null || ativo.equals("")){
			JOptionPane.showMessageDialog(null,
					"INFORME SE DESEJA ATIVAR O USUÁRIO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}else {
			return true;
		}
	}

	public static boolean validarEmail(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression,
					Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}
}