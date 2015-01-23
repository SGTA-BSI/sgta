package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;

import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PerfilFuncionario extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField cpf;
	private MaskFormatter ftmCpf;
	final static PerfilFuncionario frame = new PerfilFuncionario();
	private JLabel lblNome;
	private JLabel lblSexo;
	private JLabel lblData;
	private JLabel lblCpf;
	private JLabel lblIdentidade;
	private JLabel lblEndereco;
	private JLabel lblNumero;
	private JLabel lblComplemento;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblBairro;
	private JLabel lblTel;
	private JLabel lblCel;
	private JLabel lblEmail;
	private JLabel lblStatus;
	private JLabel lblCargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilFuncionario frame = new PerfilFuncionario();
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
	public PerfilFuncionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Perfil de Funcion\u00E1rio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 186, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblInformeOCpf = new JLabel("Informe o CPF do funcion\u00E1rio");
		lblInformeOCpf.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInformeOCpf.setBounds(10, 57, 186, 24);
		contentPane.add(lblInformeOCpf);
		try {
			ftmCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cpf = new JFormattedTextField(ftmCpf);
		cpf.setColumns(10);
		cpf.setBounds(10, 80, 182, 20);
		contentPane.add(cpf);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cpf.getText().equals("   .   .   -  ")){
					Toast.makeText(frame, "Preencha o campo CPF!", 2000, Style.ERROR).display();
					lblBairro.setText("");
					lblEndereco.setText("");
					lblCidade.setText("");
					lblNumero.setText("");
					lblComplemento.setText("");
					lblNome.setText("");
					lblData.setText("");
					lblCpf.setText("");
					lblIdentidade.setText("");
					lblSexo.setText("");
					lblStatus.setText("");
					lblEmail.setText("");
					lblTel.setText("");
					lblCel.setText("");
					lblCargo.setText("");
					lblEstado.setText("");
					
				}else{
					UsuarioBusiness business = UsuarioBusiness.getInstancia();
					try {
						Pessoa funcionario = business.buscarFuncionario(cpf.getText());
						if (funcionario.getNome()==null){
							Toast.makeText(frame, "CPF não cadastrado no Sistema!", 2000, Style.ERROR).display();	
							lblBairro.setText("");
							lblEndereco.setText("");
							lblCidade.setText("");
							lblNumero.setText("");
							lblComplemento.setText("");
							lblNome.setText("");
							lblData.setText("");
							lblCpf.setText("");
							lblIdentidade.setText("");
							lblSexo.setText("");
							lblStatus.setText("");
							lblEmail.setText("");
							lblTel.setText("");
							lblCel.setText("");
							lblCargo.setText("");
							lblEstado.setText("");
						}else{
							lblBairro.setText(funcionario.getBairro());
							lblEndereco.setText(funcionario.getEndereco());
							lblCidade.setText(funcionario.getCidade());
							lblNumero.setText(funcionario.getNumero());
							lblComplemento.setText(funcionario.getComplemento());
							lblNome.setText(funcionario.getNome());
							lblData.setText(funcionario.getDataDeNascimento());
							lblCpf.setText(funcionario.getCpf());
							lblIdentidade.setText(funcionario.getIdentidade());
							lblSexo.setText(funcionario.getSexo());
							lblStatus.setText(funcionario.getUsuario().getAtivo());
							lblEmail.setText(funcionario.getEmail());
							lblTel.setText(funcionario.getTelefone());
							lblCel.setText(funcionario.getCelular());
							lblCargo.setText(funcionario.getUsuario().getCargo());
							lblEstado.setText(funcionario.getEstado());
							
							
							
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnBuscar.setBounds(349, 79, 106, 23);
		contentPane.add(btnBuscar);
		
		JLabel label = new JLabel("Nome");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 130, 46, 14);
		contentPane.add(label);
		
		lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNome.setBounds(52, 130, 287, 14);
		contentPane.add(lblNome);
		
		JLabel label_1 = new JLabel("Status");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(349, 130, 46, 14);
		contentPane.add(label_1);
		
		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblStatus.setBounds(395, 130, 60, 14);
		contentPane.add(lblStatus);
		
		JLabel label_2 = new JLabel("Data de Nascimento");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 180, 118, 14);
		contentPane.add(label_2);
		
		lblData = new JLabel("");
		lblData.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblData.setBounds(132, 180, 118, 14);
		contentPane.add(lblData);
		
		JLabel label_3 = new JLabel("Sexo");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(245, 180, 46, 14);
		contentPane.add(label_3);
		
		lblSexo = new JLabel("");
		lblSexo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSexo.setBounds(286, 180, 80, 14);
		contentPane.add(lblSexo);
		
		JLabel label_4 = new JLabel("Cargo");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 155, 46, 14);
		contentPane.add(label_4);
		
		lblCargo = new JLabel("");
		lblCargo.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCargo.setBounds(52, 155, 100, 14);
		contentPane.add(lblCargo);
		
		JLabel label_5 = new JLabel("CPF");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(10, 205, 46, 14);
		contentPane.add(label_5);
		
		lblCpf = new JLabel("");
		lblCpf.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCpf.setBounds(52, 205, 128, 14);
		contentPane.add(lblCpf);
		
		JLabel label_6 = new JLabel("Identidade");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(245, 205, 69, 14);
		contentPane.add(label_6);
		
		lblIdentidade = new JLabel("");
		lblIdentidade.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblIdentidade.setBounds(320, 205, 128, 14);
		contentPane.add(lblIdentidade);
		
		JLabel label_7 = new JLabel("Endere\u00E7o");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(10, 230, 60, 14);
		contentPane.add(label_7);
		
		lblEndereco = new JLabel("");
		lblEndereco.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEndereco.setBounds(82, 230, 373, 14);
		contentPane.add(lblEndereco);
		
		JLabel label_8 = new JLabel("N\u00FAmero");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(10, 255, 46, 14);
		contentPane.add(label_8);
		
		lblNumero = new JLabel("");
		lblNumero.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNumero.setBounds(82, 255, 70, 14);
		contentPane.add(lblNumero);
		
		JLabel label_9 = new JLabel("Complemento");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_9.setBounds(245, 255, 94, 14);
		contentPane.add(label_9);
		
		lblComplemento = new JLabel("");
		lblComplemento.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblComplemento.setBounds(349, 255, 106, 14);
		contentPane.add(lblComplemento);
		
		JLabel label_10 = new JLabel("Bairro");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_10.setBounds(10, 280, 46, 14);
		contentPane.add(label_10);
		
		lblBairro = new JLabel("");
		lblBairro.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBairro.setBounds(52, 280, 88, 14);
		contentPane.add(lblBairro);
		
		JLabel label_11 = new JLabel("Cidade");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_11.setBounds(150, 280, 46, 14);
		contentPane.add(label_11);
		
		lblCidade = new JLabel("");
		lblCidade.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCidade.setBounds(201, 280, 128, 14);
		contentPane.add(lblCidade);
		
		JLabel label_12 = new JLabel("Estado");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(349, 280, 46, 14);
		contentPane.add(label_12);
		
		lblEstado = new JLabel("");
		lblEstado.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEstado.setBounds(395, 280, 60, 14);
		contentPane.add(lblEstado);
		
		JLabel label_13 = new JLabel("Telefone");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setBounds(10, 305, 60, 14);
		contentPane.add(label_13);
		
		lblTel = new JLabel("");
		lblTel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTel.setBounds(73, 305, 123, 14);
		contentPane.add(lblTel);
		
		JLabel label_14 = new JLabel("Celular");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(245, 305, 46, 14);
		contentPane.add(label_14);
		
		lblCel = new JLabel("");
		lblCel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCel.setBounds(301, 305, 106, 14);
		contentPane.add(lblCel);
		
		JLabel label_15 = new JLabel("Email");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setBounds(10, 330, 46, 14);
		contentPane.add(label_15);
		
		lblEmail = new JLabel("");
		lblEmail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblEmail.setBounds(52, 330, 186, 14);
		contentPane.add(lblEmail);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdm tela = new MenuAdm();
				tela.setVisible(true);
				dispose();
			}
		});
		btnFechar.setBounds(385, 418, 89, 23);
		contentPane.add(btnFechar);
	}
}
