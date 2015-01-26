package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.SessaoUsuario;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscaCpfRelatorio extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField cpf;
	private MaskFormatter ftmCpf;
	final static BuscaCpfRelatorio frame = new BuscaCpfRelatorio();
	private UsuarioBusiness business = UsuarioBusiness.getInstancia();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscaCpfRelatorio frame = new BuscaCpfRelatorio();
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
	public BuscaCpfRelatorio() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBuscaDeRelatrio = new JLabel("Busca de Relat\u00F3rio");
		lblBuscaDeRelatrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBuscaDeRelatrio.setBounds(10, 29, 174, 14);
		contentPane.add(lblBuscaDeRelatrio);
		
		JLabel lblInformeOCpf = new JLabel("Informe o cpf do Aluno para busca do relat\u00F3rio");
		lblInformeOCpf.setBounds(10, 66, 339, 14);
		contentPane.add(lblInformeOCpf);
		
		JLabel lblCpfDoAluno = new JLabel("CPF do Aluno:");
		lblCpfDoAluno.setBounds(10, 131, 126, 14);
		contentPane.add(lblCpfDoAluno);
		try {
			ftmCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(99, 128, 154, 20);
		contentPane.add(cpf);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pessoa aluno = business.buscarAluno(cpf.getText());
					if (aluno.getNome() == null){
						Toast.makeText(frame,
								"Cpf não de Aluno não cadastrado no Sistema!!!",
								2000, Style.ERROR).display();
					}else{
						SessaoUsuario.getInstancia().setAlunoSelecionado(aluno);
						MenuRelatorio tela = new MenuRelatorio();
						tela.setVisible(true);
						dispose();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnBuscar.setBounds(99, 200, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (SessaoUsuario.getInstancia().getUsuarioLogado().getUsuario().getCargo().equals("Professor")){
					MenuProfessor tela = new MenuProfessor();
					tela.setVisible(true);
					dispose();
				}
				if (SessaoUsuario.getInstancia().getUsuarioLogado().getUsuario().getCargo().equals("Atendente")){
					MenuAtendente tela = new MenuAtendente();
					tela.setVisible(true);
					dispose();
				}
			}
		});
		btnCancelar.setBounds(223, 200, 89, 23);
		contentPane.add(btnCancelar);
	}
}
