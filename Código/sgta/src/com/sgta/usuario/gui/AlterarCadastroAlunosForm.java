package com.sgta.usuario.gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.SessaoUsuario;
import com.sgta.usuario.negocio.UsuarioBusiness;

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
	final static AlterarCadastroAlunosForm frame = new AlterarCadastroAlunosForm();

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
	 * 
	 * @throws ParseException
	 */
	public AlterarCadastroAlunosForm() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 650);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
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

		JLabel lblCadastroDeAlunos = new JLabel("Alterar Cadastro");
		lblCadastroDeAlunos.setBounds(10, 11, 126, 14);
		lblCadastroDeAlunos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblCadastroDeAlunos);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 92, 126, 14);
		lblNome.setAlignmentX(Component.CENTER_ALIGNMENT);
		contentPane.add(lblNome);

		nome = new JTextField();
		nome.setBounds(10, 110, 474, 20);
		contentPane.add(nome);
		nome.setColumns(10);

		// Formatação da data
		try {
			ftmData = new MaskFormatter("##/##/####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

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
		comboBoxSexo.setBounds(233, 159, 251, 20);
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
		identidade.setBounds(233, 206, 251, 20);
		contentPane.add(identidade);
		identidade.setColumns(10);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setBounds(10, 235, 61, 14);
		contentPane.add(lblEndereco);

		endereco = new JTextField();
		endereco.setBounds(10, 251, 474, 20);
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
		complemento.setBounds(120, 297, 364, 20);
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
		bairro.setBounds(325, 342, 159, 20);
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
		email.setBounds(10, 434, 474, 20);
		contentPane.add(email);
		email.setColumns(10);

		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es");
		lblObservacoes.setBounds(10, 465, 86, 14);
		contentPane.add(lblObservacoes);

		observacoes = new JTextField();
		observacoes.setBounds(10, 479, 474, 54);
		contentPane.add(observacoes);
		observacoes.setColumns(10);

		// Formatação do cpf
		try {
			ftmCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(10, 206, 202, 20);
		contentPane.add(cpf);

		// Formatação do telefone
		try {
			ftmTelefone = new MaskFormatter("(##)####-####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		telefone = new JFormattedTextField(ftmTelefone);
		telefone.setBounds(10, 388, 202, 20);
		contentPane.add(telefone);

		// Formatação do celular
		try {
			ftmCelular = new MaskFormatter("(##)####-####");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		celular = new JFormattedTextField(ftmCelular);
		celular.setBounds(233, 389, 251, 20);
		contentPane.add(celular);

		JButton btnCadastrar = new JButton("Alterar Cadastro");
		btnCadastrar.setBounds(215, 588, 138, 23);
		contentPane.add(btnCadastrar);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioBusiness business = UsuarioBusiness.getInstancia();
				MenuAtendente tela;
				if (validacaoPreenchimento()) {
					try {
						alterarCadastro();
						Toast.makeText(frame, "Cadastro alterado com sucesso.", 2000, Style.SUCCESS).display();
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
		btnCancelar.setBounds(363, 588, 121, 23);
		contentPane.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
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
				dispose();
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

		String[] ativoItems = { "Selecione uma opção", "Ativar", "Desativar" };
		JComboBox comboBoxAtivar = new JComboBox(ativoItems);
		comboBoxAtivar.setBounds(325, 53, 159, 20);
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
		pessoa.setSexo(sexo);
		pessoa.setTelefone(telefone.getText());

		UsuarioBusiness business = UsuarioBusiness.getInstancia();
		business.alterarAluno(pessoa);

	}

	public boolean validacaoPreenchimento() {
		if (nome.getText().length() == 0 || nome.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo nome.", 2000, Style.ERROR).display();
			nome.requestFocus();
			return false;
		} else if (data.getText().length() == 0 || data.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo data de nascimento.", 2000, Style.ERROR).display();
			return false;
		} else if (sexo == null || sexo.equals("")) {
			Toast.makeText(frame, "Selecione o sexo.", 2000, Style.ERROR).display();
			return false;
		} else if (cpf.getText().length() == 0 || cpf.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo cpf.", 2000, Style.ERROR).display();
			return false;
		} else if (identidade.getText().length() == 0
				|| identidade.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo identidade.", 2000, Style.ERROR).display();
			return false;
		} else if (endereco.getText().length() == 0
				|| endereco.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo endereço.", 2000, Style.ERROR).display();
			return false;
		} else if (numero.getText().length() == 0
				|| numero.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo número.", 2000, Style.ERROR).display();
			return false;
		} else if (cidade.getText().length() == 0
				|| cidade.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo cidade.", 2000, Style.ERROR).display();
			return false;
		} else if (estado.getText().length() == 0
				|| estado.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo estado.", 2000, Style.ERROR).display();
			return false;
		} else if (bairro.getText().length() == 0
				|| bairro.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo bairro.", 2000, Style.ERROR).display();
			return false;
		} else if (telefone.getText().length() == 0
				|| telefone.getText().equals("(  )    -    ")) {
			Toast.makeText(frame, "Preencha o campo telefone.", 2000, Style.ERROR).display();
			return false;
		} else if (celular.getText().length() == 0
				|| celular.getText().equals("(  )    -    ")) {
			Toast.makeText(frame, "Preencha o campo celular.", 2000, Style.ERROR).display();
			return false;
		} else if (email.getText().length() == 0 || email.getText().equals(" ")) {
			Toast.makeText(frame, "Preencha o campo email.", 2000, Style.ERROR).display();
			return false;
		} else if (validarEmail(email.getText()) == false) {
			Toast.makeText(frame, "Preencha o campo email no formato email@email.com.", 2000, Style.ERROR).display();
			return false;
		} else if (ativo == null || ativo.equals("")) {
			Toast.makeText(frame, "Informe ativar/desativar usuário.", 2000, Style.ERROR).display();
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

}
