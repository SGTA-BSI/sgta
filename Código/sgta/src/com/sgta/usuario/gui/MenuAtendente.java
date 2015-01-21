package com.sgta.usuario.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.sgta.Login;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.SessaoUsuario;

public class MenuAtendente extends JFrame {

	private JPanel contentPane;
	private static JLabel lblInfo;
	final static MenuAtendente frame = new MenuAtendente();

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
	 */
	public MenuAtendente() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame teste = frame;
		setBounds(100, 100, 593, 319);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String nome = SessaoUsuario.getInstancia().getUsuarioLogado().getNome();
		if (nome.indexOf(" ") != -1) {
			nome = nome.substring(0, nome.indexOf(" "));
		}
		Date data = new Date();
		JLabel lblMenuAtendente = new JLabel("Menu Atendente");
		if (data.getHours() >= 0 && data.getHours() < 12) {
			lblMenuAtendente = new JLabel("Bom dia, " + nome + ".");

		} else if (data.getHours() >= 12 && data.getHours() < 18) {
			lblMenuAtendente = new JLabel("Boa tarde, " + nome + ".");
		} else {
			lblMenuAtendente = new JLabel("Boa noite, " + nome + ".");
		}
		lblMenuAtendente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuAtendente.setBounds(10, 11, 454, 23);
		contentPane.add(lblMenuAtendente);

		JButton btnCadastrarAluno = new JButton("Cadastrar Novo Aluno");
		btnCadastrarAluno.setBounds(10, 75, 279, 84);
		Image img3 = new ImageIcon(this.getClass().getResource("/add.png"))
				.getImage();
		btnCadastrarAluno.setIcon(new ImageIcon(img3));
		contentPane.add(btnCadastrarAluno);
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAlunosForm tela;
				tela = new CadastroAlunosForm();
				tela.setVisible(true);
				setVisible(false);
			}
		});

		JButton btnPerfilDeAlunos = new JButton("Perfil de Alunos");
		btnPerfilDeAlunos.setBounds(10, 172, 279, 84);
		contentPane.add(btnPerfilDeAlunos);
		Image img2 = new ImageIcon(this.getClass().getResource("/func.png"))
				.getImage();
		btnPerfilDeAlunos.setIcon(new ImageIcon(img2));
		btnPerfilDeAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PerfilUsuario tela = new PerfilUsuario();
					tela.setVisible(true);
					setVisible(false);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnRelatoriosDeAluno = new JButton("Relat\u00F3rios de Alunos");
		btnRelatoriosDeAluno.setBounds(299, 172, 279, 84);
		Image img1 = new ImageIcon(this.getClass().getResource(
				"/alunobyprofessor.png")).getImage();
		btnRelatoriosDeAluno.setIcon(new ImageIcon(img1));
		contentPane.add(btnRelatoriosDeAluno);

		JButton btnLogout = new JButton("");
		btnLogout.setBounds(538, 8, 40, 40);
		contentPane.add(btnLogout);
		Image img = new ImageIcon(this.getClass().getResource("/logout.png"))
				.getImage();
		btnLogout.setIcon(new ImageIcon(img));
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
		lblInfo.setBounds(10, 386, 581, 14);
		contentPane.add(lblInfo);

		JButton button = new JButton("Alterar Cadastro Aluno");
		Image img4 = new ImageIcon(this.getClass()
				.getResource("/func_edit.png")).getImage();
		button.setIcon(new ImageIcon(img4));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarCadastroAlunosForm tela;
				tela = new AlterarCadastroAlunosForm();
				tela.setVisible(true);
				dispose();

			}
		});
		button.setBounds(297, 75, 279, 84);
		contentPane.add(button);

		JLabel lblVocEstLogado = new JLabel(
				"Voc\u00EA est\u00E1 logado como atendente");
		lblVocEstLogado.setBounds(10, 32, 207, 14);
		contentPane.add(lblVocEstLogado);
	}

	public static void getLblInfo(String mensagem) {
		lblInfo.setText(mensagem);
	}
}
