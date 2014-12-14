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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class CadastroFuncionarioForm extends JFrame {

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
	private JTextField login;
	private JPasswordField campoConfSenha;
	private JPasswordField campoSenha;

	private JFormattedTextField data;
	private JFormattedTextField celular;
	private JFormattedTextField cpf;
	private JFormattedTextField telefone;

	private MaskFormatter ftmData;
	private MaskFormatter ftmCpf;
	private MaskFormatter ftmTelefone;
	private MaskFormatter ftmCelular;

	private JLabel lblInfo;

	private String sexo;
	private String cargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarioForm frame = new CadastroFuncionarioForm();
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
	public CadastroFuncionarioForm() throws ParseException {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 492);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeAlunos = new JLabel("Cadastro de Funcionarios");
		lblCadastroDeAlunos.setBounds(15, 16, 182, 14);
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

		// Formata��o da data
		ftmData = new MaskFormatter("##/##/####");

		data = new JFormattedTextField(ftmData);
		data.setBounds(131, 64, 86, 20);
		contentPane.add(data);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(15, 67, 148, 14);
		lblDataDeNascimento.setToolTipText("");
		contentPane.add(lblDataDeNascimento);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(272, 67, 39, 14);
		contentPane.add(lblSexo);

		// Atribuir valores ao comboBox
		String[] items = { "Selecione o Sexo", "Masculino", "Feminino" };
		JComboBox comboBoxSexo = new JComboBox(items);
		comboBoxSexo.setBounds(321, 67, 142, 20);
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
		lblCpf.setBounds(15, 102, 46, 14);
		contentPane.add(lblCpf);

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

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(218, 222, 52, 14);
		contentPane.add(lblCelular);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(15, 259, 33, 14);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setBounds(53, 256, 242, 20);
		contentPane.add(email);
		email.setColumns(10);

		// Formata��o do cpf
		ftmCpf = new MaskFormatter("###.###.###-##");

		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(53, 99, 126, 20);
		contentPane.add(cpf);

		// Formata��o do telefone
		ftmTelefone = new MaskFormatter("(##)####-####");
		telefone = new JFormattedTextField(ftmTelefone);
		telefone.setBounds(70, 222, 138, 20);
		contentPane.add(telefone);

		// Formata��o do celular
		ftmCelular = new MaskFormatter("(##)####-####");
		celular = new JFormattedTextField(ftmCelular);
		celular.setBounds(272, 222, 148, 20);
		contentPane.add(celular);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(158, 400, 126, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				String password = new String(campoSenha.getPassword());
				String confirmPassword = new String(campoConfSenha.getPassword());
				if (validacaoPreenchimento()) {
					try {
						if (business.consultaCpfFuncionario(cpf.getText())) {
							if(business.consultaLoginFuncionario(login.getText())){
								if (password.equals(confirmPassword)) {
							
								cadastrar();
								lblInfo.setText("Funcion�rio Cadastrado com sucesso");
								
								}else{
									JOptionPane.showMessageDialog(null,"SENHAS DIFERENTES! INFORME SENHAS IGUAIS","ATEN��O",JOptionPane.WARNING_MESSAGE);
								}

							} else {
								JOptionPane.showMessageDialog(null,"LOGIN J� EXISTENTE! ESCOLHA OUTRO!","ATEN��O",JOptionPane.WARNING_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(null,"CPF J� CADASTRADO", "ATEN��O",JOptionPane.WARNING_MESSAGE);
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(310, 400, 121, 23);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		lblInfo = new JLabel("");
		lblInfo.setBounds(15, 429, 547, 14);
		contentPane.add(lblInfo);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(15, 284, 46, 14);
		contentPane.add(lblLogin);

		login = new JTextField();
		login.setBounds(53, 287, 110, 20);
		contentPane.add(login);
		login.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(171, 287, 46, 14);
		contentPane.add(lblCargo);

		// ---- Atribuindo valores ao ComboBox cargo
		String[] itemsCargo = { "Selecione o Cargo", "Professor", "Atendente" };
		JComboBox comboBoxCargo = new JComboBox(itemsCargo);
		comboBoxCargo.setBounds(211, 287, 182, 20);
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

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(15, 315, 46, 14);
		contentPane.add(lblSenha);

		campoConfSenha = new JPasswordField();
		campoConfSenha.setBounds(283, 318, 110, 20);
		contentPane.add(campoConfSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(171, 315, 99, 14);
		contentPane.add(lblConfirmarSenha);

		campoSenha = new JPasswordField();
		campoSenha.setBounds(53, 318, 110, 20);
		contentPane.add(campoSenha);

	}

	private void cadastrar() {
		Usuario usuario = new Usuario();
		Pessoa pessoa = new Pessoa();

		String password = new String(campoSenha.getPassword());

		usuario.setSenha(password);
		usuario.setUsername(login.getText());
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
		pessoa.setUsuario(usuario);
		pessoa.setCargo(cargo);
		UsuarioBusiness business = UsuarioBusiness.getInstancia();
		business.inserirFuncionario(pessoa);

	}

	public boolean validacaoPreenchimento() {
		String password = new String(campoSenha.getPassword());
		
		
		if (nome.getText().length() == 0 || nome.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE NOME","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			nome.requestFocus();
			return false;
		}
		else if (data.getText().length() == 0 || data.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO DE DATA DE NASCIMENTO", "ATEN��O!!",JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (sexo == null || sexo.equals("")) {
			JOptionPane.showMessageDialog(null, "SELECIONE O SEXO","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (cpf.getText().length() == 0 || cpf.getText().equals(" � . � . � - �")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CPF","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (identidade.getText().length() == 0 || identidade.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO DE IDENTIDADE", "ATEN��O!!",JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (endereco.getText().length() == 0 || endereco.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE ENDERE�O","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (numero.getText().length() == 0	|| numero.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE NUMERO","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (cidade.getText().length() == 0	|| cidade.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CIDADE","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (estado.getText().length() == 0 || estado.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE ESTADO","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (bairro.getText().length() == 0 || bairro.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE BAIRRO","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (telefone.getText().length() == 0	|| telefone.getText().equals("( �) � �- � �")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE TELEFONE","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (celular.getText().length() == 0 || celular.getText().equals("( �) � �- � �")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CELULAR","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (email.getText().length() == 0 || email.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE EMAIL","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (validarEmail(email.getText()) == false) {
			JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO DE EMAIL NO FORMATO email@email.com",
					"ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;

		} else if (cargo == null || cargo.equals("")) {
			JOptionPane.showMessageDialog(null, "SELECIONE UM CARGO","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (login.getText().length() == 0 || login.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE LOGIN","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (password == null || password.equals("") || password.length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO SENHA","ATEN��O!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
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
