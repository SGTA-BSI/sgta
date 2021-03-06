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
import com.sgta.usuario.negocio.SessaoUsuario;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class AlterarCadastroFuncionarioForm extends JFrame {

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

	private JFormattedTextField data;
	private JFormattedTextField celular;
	private JFormattedTextField cpf;
	private JFormattedTextField telefone;
	private JFormattedTextField cpf2;

	private MaskFormatter ftmData;
	private MaskFormatter ftmCpf;
	private MaskFormatter ftmTelefone;
	private MaskFormatter ftmCelular;

	private String sexo;
	private String cargo;
	private String status;
	private Pessoa funcionario;
	private JTextField textFieldLogin;
	private JPasswordField passwordFieldSenha;
	private JPasswordField passwordFieldConfirmSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarCadastroFuncionarioForm frame = new AlterarCadastroFuncionarioForm();
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
	public AlterarCadastroFuncionarioForm() throws ParseException {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				MenuAdm tela;
				tela = new MenuAdm();
				tela.setVisible(true);
				dispose();
			}
		});

		JLabel lblCadastroDeAlunos = new JLabel(
				"Alterar Cadastro de Funcionarios");
		lblCadastroDeAlunos.setBounds(10, 11, 221, 14);
		lblCadastroDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblCadastroDeAlunos);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(11, 105, 126, 14);
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNome);

		nome = new JTextField();
		nome.setBounds(10, 119, 464, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		// FormataÃ§Ã£o da data
		ftmData = new MaskFormatter("##/##/####");

		data = new JFormattedTextField(ftmData);
		data.setBounds(10, 175, 202, 20);
		contentPane.add(data);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 160, 148, 14);
		lblDataDeNascimento.setToolTipText("");
		contentPane.add(lblDataDeNascimento);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(233, 160, 39, 14);
		contentPane.add(lblSexo);

		// Atribuir valores ao comboBox
		String[] items = { "Selecione o Sexo", "Masculino", "Feminino" };
		JComboBox comboBoxSexo = new JComboBox(items);
		comboBoxSexo.setBounds(233, 175, 241, 20);
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
		lblCpf.setBounds(10, 206, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblIdentidade = new JLabel("Identidade");
		lblIdentidade.setBounds(233, 206, 71, 14);
		contentPane.add(lblIdentidade);

		identidade = new JTextField();
		identidade.setBounds(233, 220, 241, 20);
		contentPane.add(identidade);
		identidade.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(10, 251, 61, 14);
		contentPane.add(lblEndereco);

		endereco = new JTextField();
		endereco.setBounds(10, 265, 464, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(11, 296, 46, 14);
		contentPane.add(lblNumero);

		numero = new JTextField();
		numero.setBounds(10, 309, 91, 20);
		contentPane.add(numero);
		numero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(121, 296, 91, 14);
		contentPane.add(lblComplemento);

		complemento = new JTextField();
		complemento.setBounds(120, 309, 354, 20);
		contentPane.add(complemento);
		complemento.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 340, 46, 14);
		contentPane.add(lblCidade);

		cidade = new JTextField();
		cidade.setBounds(10, 353, 138, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(167, 340, 48, 14);
		contentPane.add(lblEstado);

		estado = new JTextField();
		estado.setBounds(167, 353, 137, 20);
		contentPane.add(estado);
		estado.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(326, 340, 46, 14);
		contentPane.add(lblBairro);

		bairro = new JTextField();
		bairro.setBounds(325, 353, 149, 20);
		contentPane.add(bairro);
		bairro.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 379, 61, 14);
		contentPane.add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(235, 379, 52, 14);
		contentPane.add(lblCelular);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 424, 33, 14);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setBounds(10, 438, 464, 20);
		contentPane.add(email);
		email.setColumns(10);

		// FormataÃ§Ã£o do cpf
		ftmCpf = new MaskFormatter("###.###.###-##");

		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(10, 220, 202, 20);
		contentPane.add(cpf);

		// FormataÃ§Ã£o do telefone
		ftmTelefone = new MaskFormatter("(##)####-####");
		telefone = new JFormattedTextField(ftmTelefone);
		telefone.setBounds(10, 393, 202, 20);
		contentPane.add(telefone);

		// FormataÃ§Ã£o do celular
		ftmCelular = new MaskFormatter("(##)####-####");
		celular = new JFormattedTextField(ftmCelular);
		celular.setBounds(234, 393, 241, 20);
		contentPane.add(celular);

		JButton btnCadastrar = new JButton("Alterar");
		btnCadastrar.setBounds(218, 588, 126, 23);
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
						funcionario = null;
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

					} catch (HeadlessException e1) {
						JOptionPane.showMessageDialog(null, "Erro");
					}

				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(354, 588, 121, 23);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdm tela;
				tela = new MenuAdm();
				tela.setVisible(true);
				setVisible(false);
			}
		});

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 469, 46, 14);
		contentPane.add(lblCargo);

		// ---- Atribuindo valores ao ComboBox cargo
		String[] itemsCargo = { "Selecione o Cargo", "Professor", "Atendente" };
		JComboBox comboBoxCargo = new JComboBox(itemsCargo);
		comboBoxCargo.setBounds(10, 483, 182, 20);
		contentPane.add(comboBoxCargo);
		comboBoxCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxCargo.getSelectedItem() == "Selecione o Cargo") {
					cargo = "";
				} else if (comboBoxCargo.getSelectedItem() == "Professor") {
					cargo = "Professor";
				} else if (comboBoxCargo.getSelectedItem() == "Atendente") {
					cargo = "Atendente";
				}
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(11, 92, 464, 2);
		contentPane.add(separator);

		JLabel lblInformeOCpf = new JLabel("Informe o CPF do Funcion\u00E1rio");
		lblInformeOCpf.setBounds(10, 36, 222, 25);
		contentPane.add(lblInformeOCpf);

		String[] ativoItems = { "Selecione uma opção", "Ativar", "Desativar" };
		JComboBox comboBox = new JComboBox(ativoItems);
		comboBox.setBounds(341, 56, 133, 23);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem() == "Selecione uma opção") {
					status = "";
				} else if (comboBox.getSelectedItem() == "Ativar") {
					status = "Ativo";
				} else if (comboBox.getSelectedItem() == "Desativar") {
					status = "Desativo";
				}
			}
		});

		JButton btnBuscar = new JButton("Buscar");
		contentPane.add(btnBuscar);
		btnBuscar.setBounds(197, 56, 89, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				try {
					funcionario = business.buscarFuncionario(cpf2.getText()
							.toString());
					if (funcionario.getNome() == null) {
						JOptionPane.showMessageDialog(null,
								"CPF não cadastrado.");
						funcionario = null;
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
						textFieldLogin.setText("");
						passwordFieldSenha.setText("");
						passwordFieldConfirmSenha.setText("");
					} else {
						nome.setText(funcionario.getNome());
						data.setText(funcionario.getDataDeNascimento());
						cpf.setText(funcionario.getCpf());
						identidade.setText(funcionario.getIdentidade());
						endereco.setText(funcionario.getEndereco());
						numero.setText(funcionario.getNumero());
						complemento.setText(funcionario.getComplemento());
						cidade.setText(funcionario.getCidade());
						estado.setText(funcionario.getEstado());
						bairro.setText(funcionario.getBairro());
						telefone.setText(funcionario.getTelefone());
						celular.setText(funcionario.getCelular());
						email.setText(funcionario.getEmail());
						textFieldLogin.setText(funcionario.getUsuario()
								.getUsername());
						comboBoxSexo.setSelectedItem(funcionario.getSexo());
						if (funcionario.getUsuario().getAtivo().equals("Ativo")) {
							comboBox.setSelectedItem("Ativar");
						} else {
							comboBox.setSelectedItem("Desativar");
						}
						comboBoxCargo.setSelectedItem(funcionario.getUsuario()
								.getCargo());

					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel lblFuncionrioAtivo = new JLabel("Funcion\u00E1rio Ativo?");
		lblFuncionrioAtivo.setBounds(341, 36, 118, 19);
		contentPane.add(lblFuncionrioAtivo);

		cpf2 = new JFormattedTextField(ftmCpf);
		cpf2.setBounds(10, 57, 177, 20);
		contentPane.add(cpf2);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(10, 542, 158, 20);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 514, 91, 24);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(181, 519, 46, 14);
		contentPane.add(lblSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(326, 519, 120, 14);
		contentPane.add(lblConfirmarSenha);

		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(178, 542, 138, 20);
		contentPane.add(passwordFieldSenha);

		passwordFieldConfirmSenha = new JPasswordField();
		passwordFieldConfirmSenha.setBounds(326, 542, 148, 20);
		contentPane.add(passwordFieldConfirmSenha);

	}

	public boolean validacaoPreenchimento() {
		String password = new String(passwordFieldSenha.getPassword());
		String confirmPassword = new String(
				passwordFieldConfirmSenha.getPassword());
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
		} else if (cpf.getText().length() == 0
				|| cpf.getText().equals("   .   .   -  ")) {
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
			JOptionPane.showMessageDialog(null,
					"PREENCHA O CAMPO DE ENDEREÃ§O", "ATENÇÃO!!",
					JOptionPane.WARNING_MESSAGE);
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

		} else if (cargo == null || cargo.equals("")) {
			JOptionPane.showMessageDialog(null, "SELECIONE UM CARGO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;

		} else if (status == null || status.equals("")) {
			JOptionPane.showMessageDialog(null,
					"INFORME SE O FUNCIONÁRIO ESTÁ ATIVO", "ATENÇÃO!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (password == null || password.equals("")
				|| password.length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO SENHA",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (!(password.equals(confirmPassword))) {
			JOptionPane.showMessageDialog(null, "PREENCHA DUAS SENHAS IGUAIS!",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {

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

	private void alterarCadastro() {
		Pessoa pessoa = new Pessoa();
		String password = new String(passwordFieldSenha.getPassword());

		pessoa.setUsuario(funcionario.getUsuario());
		pessoa.getUsuario().setId(funcionario.getUsuario().getId());
		pessoa.getUsuario().setAtivo(status);
		pessoa.getUsuario().setUsername(textFieldLogin.getText());
		pessoa.getUsuario().setSenha(password);

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
		pessoa.setSexo(sexo);
		pessoa.setTelefone(telefone.getText());

		UsuarioBusiness business = UsuarioBusiness.getInstancia();
		business.alterarFuncionario(pessoa);

	}
}
