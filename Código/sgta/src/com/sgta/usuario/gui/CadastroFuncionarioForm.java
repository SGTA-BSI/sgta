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
		setBounds(100, 100, 500, 595);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCadastroDeAlunos = new JLabel("Cadastro de Funcionarios");
		lblCadastroDeAlunos.setBounds(10, 11, 221, 14);
		lblCadastroDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblCadastroDeAlunos);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 38, 126, 14);
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNome);

		nome = new JTextField();
		nome.setBounds(10, 56, 464, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		// Formatação da data
		ftmData = new MaskFormatter("##/##/####");

		data = new JFormattedTextField(ftmData);
		data.setBounds(10, 105, 202, 20);
		contentPane.add(data);

		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(10, 87, 148, 14);
		lblDataDeNascimento.setToolTipText("");
		contentPane.add(lblDataDeNascimento);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(233, 87, 39, 14);
		contentPane.add(lblSexo);

		// Atribuir valores ao comboBox
		String[] items = { "Selecione o Sexo", "Masculino", "Feminino" };
		JComboBox comboBoxSexo = new JComboBox(items);
		comboBoxSexo.setBounds(233, 105, 241, 20);
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
		lblCpf.setBounds(10, 136, 46, 14);
		contentPane.add(lblCpf);

		JLabel lblIdentidade = new JLabel("Identidade");
		lblIdentidade.setBounds(233, 136, 71, 14);
		contentPane.add(lblIdentidade);

		identidade = new JTextField();
		identidade.setBounds(233, 152, 241, 20);
		contentPane.add(identidade);
		identidade.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(10, 181, 61, 14);
		contentPane.add(lblEndereco);

		endereco = new JTextField();
		endereco.setBounds(10, 197, 464, 20);
		contentPane.add(endereco);
		endereco.setColumns(10);

		JLabel lblNumero = new JLabel("N\u00FAmero");
		lblNumero.setBounds(10, 228, 46, 14);
		contentPane.add(lblNumero);

		numero = new JTextField();
		numero.setBounds(10, 243, 86, 20);
		contentPane.add(numero);
		numero.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(121, 228, 91, 14);
		contentPane.add(lblComplemento);

		complemento = new JTextField();
		complemento.setBounds(120, 243, 354, 20);
		contentPane.add(complemento);
		complemento.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 274, 46, 14);
		contentPane.add(lblCidade);

		cidade = new JTextField();
		cidade.setBounds(10, 288, 138, 20);
		contentPane.add(cidade);
		cidade.setColumns(10);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(167, 274, 48, 14);
		contentPane.add(lblEstado);

		estado = new JTextField();
		estado.setBounds(167, 288, 137, 20);
		contentPane.add(estado);
		estado.setColumns(10);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(325, 274, 46, 14);
		contentPane.add(lblBairro);

		bairro = new JTextField();
		bairro.setBounds(325, 288, 149, 20);
		contentPane.add(bairro);
		bairro.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(10, 319, 61, 14);
		contentPane.add(lblTelefone);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setBounds(233, 319, 52, 14);
		contentPane.add(lblCelular);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 366, 33, 14);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setBounds(10, 380, 464, 20);
		contentPane.add(email);
		email.setColumns(10);

		// Formatação do cpf
		ftmCpf = new MaskFormatter("###.###.###-##");

		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(10, 152, 202, 20);
		contentPane.add(cpf);

		// Formatação do telefone
		ftmTelefone = new MaskFormatter("(##)####-####");
		telefone = new JFormattedTextField(ftmTelefone);
		telefone.setBounds(10, 334, 202, 20);
		contentPane.add(telefone);

		// Formatação do celular
		ftmCelular = new MaskFormatter("(##)####-####");
		celular = new JFormattedTextField(ftmCelular);
		celular.setBounds(233, 335, 241, 20);
		contentPane.add(celular);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(217, 524, 126, 23);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				String password = new String(campoSenha.getPassword());
				String confirmPassword = new String(campoConfSenha.getPassword());
				MenuAdm tela;
				if (validacaoPreenchimento()) {
					try {
						if (business.consultaCpfFuncionario(cpf.getText())) {
							if(business.consultaLoginFuncionario(login.getText())){
								if (password.equals(confirmPassword)) {
							
								cadastrar();
								tela = new MenuAdm();
								tela.setVisible(true);
								setVisible(false);
								MenuAdm.getLblInfo("Funcionário Cadastrado com Sucesso!!");
								//lblInfo.setText("Funcionário Cadastrado com sucesso");
								
								}else{
									JOptionPane.showMessageDialog(null,"SENHAS DIFERENTES! INFORME SENHAS IGUAIS","ATENçÃO",JOptionPane.WARNING_MESSAGE);
								}

							} else {
								JOptionPane.showMessageDialog(null,"LOGIN JÁ EXISTENTE! ESCOLHA OUTRO!","ATENçÃO",JOptionPane.WARNING_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(null,"CPF JÁ CADASTRADO", "ATENçÃO",JOptionPane.WARNING_MESSAGE);
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(353, 524, 121, 23);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdm tela;
				tela = new MenuAdm();
				tela.setVisible(true);
				setVisible(false);
			}
		});
		lblInfo = new JLabel("");
		lblInfo.setBounds(15, 375, 547, 14);
		contentPane.add(lblInfo);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 411, 46, 14);
		contentPane.add(lblLogin);

		login = new JTextField();
		login.setBounds(10, 425, 138, 20);
		contentPane.add(login);
		login.setColumns(10);

		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(10, 456, 46, 14);
		contentPane.add(lblCargo);

		// ---- Atribuindo valores ao ComboBox cargo
		String[] itemsCargo = { "Selecione o Cargo", "Professor", "Atendente" };
		JComboBox comboBoxCargo = new JComboBox(itemsCargo);
		comboBoxCargo.setBounds(10, 470, 182, 20);
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
		lblSenha.setBounds(166, 411, 46, 14);
		contentPane.add(lblSenha);

		campoConfSenha = new JPasswordField();
		campoConfSenha.setBounds(325, 425, 149, 20);
		contentPane.add(campoConfSenha);

		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setBounds(325, 411, 99, 14);
		contentPane.add(lblConfirmarSenha);

		campoSenha = new JPasswordField();
		campoSenha.setBounds(167, 425, 142, 20);
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
		pessoa.getUsuario().setAtivo("Ativo");
		UsuarioBusiness business = UsuarioBusiness.getInstancia();
		business.inserirFuncionario(pessoa);

	}

	public boolean validacaoPreenchimento() {
		String password = new String(campoSenha.getPassword());
		
		
		if (nome.getText().length() == 0 || nome.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE NOME","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			nome.requestFocus();
			return false;
		}
		else if (data.getText().length() == 0 || data.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO DE DATA DE NASCIMENTO", "ATENÇÃO!!",JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (sexo == null || sexo.equals("")) {
			JOptionPane.showMessageDialog(null, "SELECIONE O SEXO","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (cpf.getText().length() == 0 || cpf.getText().equals("   .   .   -  ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CPF","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (identidade.getText().length() == 0 || identidade.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO DE IDENTIDADE", "ATENÇÃO!!",JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (endereco.getText().length() == 0 || endereco.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE ENDEREçO","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else if (numero.getText().length() == 0	|| numero.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE NUMERO","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (cidade.getText().length() == 0	|| cidade.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CIDADE","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (estado.getText().length() == 0 || estado.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE ESTADO","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		else if (bairro.getText().length() == 0 || bairro.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE BAIRRO","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (telefone.getText().length() == 0	|| telefone.getText().equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE TELEFONE","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (celular.getText().length() == 0 || celular.getText().equals("(  )    -    ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE CELULAR","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (email.getText().length() == 0 || email.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE EMAIL","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (validarEmail(email.getText()) == false) {
			JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO DE EMAIL NO FORMATO email@email.com",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;

		} else if (cargo == null || cargo.equals("")) {
			JOptionPane.showMessageDialog(null, "SELECIONE UM CARGO","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (login.getText().length() == 0 || login.getText().equals(" ")) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO DE LOGIN","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (password == null || password.equals("") || password.length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO SENHA","ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
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
