package com.sgta.usuario.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sgta.Login;
import com.sgta.usuario.negocio.SessaoUsuario;

public class MenuAdm extends JFrame {

	private JPanel contentPane;
	private static JLabel lblInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdm frame = new MenuAdm();
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
	public MenuAdm() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 408);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String nome = SessaoUsuario.getInstancia().getUsuarioLogado().getNome();
		if(nome.indexOf(" ") != -1){
			nome = nome.substring(0, nome.indexOf(" "));
		}
		Date data = new Date();
		JLabel lblMenuAdministrador = new JLabel("Menu Administrador");
		if (data.getHours() >= 0 && data.getHours() < 12) {
			lblMenuAdministrador = new JLabel("Bom dia, " + nome + ".");
					
		} else if (data.getHours() >= 12 && data.getHours() < 18) {
			lblMenuAdministrador = new JLabel("Boa tarde, " + nome + ".");
		} else {
			lblMenuAdministrador = new JLabel("Boa noite, " + nome + ".");
		}
		lblMenuAdministrador.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuAdministrador.setBounds(10, 11, 454, 23);
		contentPane.add(lblMenuAdministrador);

		JButton btnCadastrarfuncionario = new JButton(
				"Cadastrar Novo Funcion\u00E1rio");
		btnCadastrarfuncionario.setBounds(10, 75, 279, 84);
		contentPane.add(btnCadastrarfuncionario);
		Image img = new ImageIcon(this.getClass().getResource("/add.png"))
				.getImage();
		btnCadastrarfuncionario.setIcon(new ImageIcon(img));
		btnCadastrarfuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFuncionarioForm tela;
				try {
					tela = new CadastroFuncionarioForm();
					tela.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		JButton btnPerfilDeFuncionrios = new JButton(
				"Perfil de Funcion\u00E1rios");
		Image img1 = new ImageIcon(this.getClass().getResource("/func.png"))
				.getImage();
		btnPerfilDeFuncionrios.setIcon(new ImageIcon(img1));
		btnPerfilDeFuncionrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPerfilDeFuncionrios.setBounds(10, 172, 279, 84);
		contentPane.add(btnPerfilDeFuncionrios);

		JButton btnRelatriosDaAcademia = new JButton(
				"Relat\u00F3rios da Academia");
		Image img4 = new ImageIcon(this.getClass().getResource(
				"/relatorio.png")).getImage();
		btnRelatriosDaAcademia.setIcon(new ImageIcon(img4));
		btnRelatriosDaAcademia.setBounds(10, 267, 279, 84);
		contentPane.add(btnRelatriosDaAcademia);

		JButton btnLogout = new JButton("");
		btnLogout.setBounds(536, 8, 40, 40);
		Image img5 = new ImageIcon(this.getClass().getResource(
				"/logout.png")).getImage();
		btnLogout.setIcon(new ImageIcon(img5));
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SessaoUsuario.getInstancia().setUsuarioLogado(null);
				Login tela = new Login();
				tela.setVisible(true);
				dispose();
			}
		});

		lblInfo = new JLabel("");
		lblInfo.setBounds(22, 385, 539, 14);
		contentPane.add(lblInfo);

		JButton btnAlterarCadastroFuncionrio = new JButton(
				"Alterar Cadastro Funcion\u00E1rio");
		Image img2 = new ImageIcon(this.getClass()
				.getResource("/func_edit.png")).getImage();
		btnAlterarCadastroFuncionrio.setIcon(new ImageIcon(img2));
		btnAlterarCadastroFuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlterarCadastroFuncionarioForm tela = new AlterarCadastroFuncionarioForm();
					tela.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnAlterarCadastroFuncionrio.setBounds(297, 75, 279, 84);
		contentPane.add(btnAlterarCadastroFuncionrio);

		JButton btnRelatrios = new JButton("Relat\u00F3rio Aluno por Professor");
		Image img3 = new ImageIcon(this.getClass().getResource(
				"/alunobyprofessor.png")).getImage();
		btnRelatrios.setIcon(new ImageIcon(img3));
		btnRelatrios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RelatorioAlunoByProfessor tela = new RelatorioAlunoByProfessor();
				tela.setVisible(true);
				dispose();
			}
		});
		btnRelatrios.setBounds(297, 172, 279, 84);
		contentPane.add(btnRelatrios);

		JLabel lblVocEstLogado = new JLabel(
				"Voc\u00EA est\u00E1 logado como administrador");
		lblVocEstLogado.setBounds(10, 34, 255, 14);
		contentPane.add(lblVocEstLogado);

		JButton btnTeste = new JButton("Teste");
		btnTeste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

	}

	public static void getLblInfo(String mensagem) {
		lblInfo.setText(mensagem);
	}
}
