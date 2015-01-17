package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.sgta.usuario.dominio.Medidas;
import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.negocio.SessaoUsuario;
import com.sgta.usuario.negocio.UsuarioBusiness;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

public class MenuMedidas extends JFrame {

	private JPanel contentPane;
	private JTextField textAltura;
	private JTextField textPanturrilhas;
	private JTextField textBracos;
	private JTextField textCoxas;
	private JTextField textAntebracos;
	private JTextField textPeitoral;
	private JTextField textCostas;
	private JTextField textTrapezio;
	private JTextField textCintura;
	private JTextField textPeso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuMedidas frame = new MenuMedidas();
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
	public MenuMedidas() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 330, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(22, 12, 60, 15);
		contentPane.add(lblAluno);

		JLabel lblCampoNome = new JLabel("");
		lblCampoNome.setBounds(81, 12, 221, 15);
		contentPane.add(lblCampoNome);
		lblCampoNome.setText(SessaoUsuario.getInstancia().getAlunoSelecionado()
				.getNome());

		JLabel lblMedidas = new JLabel("Medidas:");
		lblMedidas.setBounds(22, 42, 70, 15);
		contentPane.add(lblMedidas);

		JLabel lblAltura = new JLabel("Altura (m):");
		lblAltura.setBounds(22, 75, 134, 15);
		contentPane.add(lblAltura);

		textAltura = new JTextField();
		textAltura.setBounds(22, 93, 134, 19);
		contentPane.add(textAltura);
		textAltura.setColumns(10);

		textPanturrilhas = new JTextField();
		textPanturrilhas.setBounds(22, 215, 134, 19);
		contentPane.add(textPanturrilhas);
		textPanturrilhas.setColumns(10);

		textBracos = new JTextField();
		textBracos.setBounds(22, 135, 134, 19);
		contentPane.add(textBracos);
		textBracos.setColumns(10);

		JLabel labelPanturrilhas = new JLabel("Panturrilhas (cm):");
		labelPanturrilhas.setBounds(22, 195, 134, 15);
		contentPane.add(labelPanturrilhas);

		JLabel labelPeso = new JLabel("Peso (kg):");
		labelPeso.setBounds(168, 75, 134, 15);
		contentPane.add(labelPeso);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PerfilUsuario tela = new PerfilUsuario();
					tela.setVisible(true);
					SessaoUsuario.getInstancia().setAlunoSelecionado(null);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnCancelar.setBounds(46, 287, 107, 25);
		contentPane.add(btnCancelar);

		JLabel labelBracos = new JLabel("Bra\u00E7os (cm):");
		labelBracos.setBounds(22, 115, 134, 15);
		contentPane.add(labelBracos);

		JLabel labelCoxas = new JLabel("Coxas (cm):");
		labelCoxas.setBounds(22, 157, 134, 15);
		contentPane.add(labelCoxas);

		textCoxas = new JTextField();
		textCoxas.setColumns(10);
		textCoxas.setBounds(22, 174, 134, 19);
		contentPane.add(textCoxas);

		JLabel lblAntebracos = new JLabel("Antebra\u00E7os (cm):");
		lblAntebracos.setBounds(22, 237, 134, 15);
		contentPane.add(lblAntebracos);

		textAntebracos = new JTextField();
		textAntebracos.setColumns(10);
		textAntebracos.setBounds(22, 256, 134, 19);
		contentPane.add(textAntebracos);

		JLabel labelPeitoral = new JLabel("Peitoral (cm):");
		labelPeitoral.setBounds(168, 115, 134, 15);
		contentPane.add(labelPeitoral);

		textPeitoral = new JTextField();
		textPeitoral.setColumns(10);
		textPeitoral.setBounds(168, 135, 134, 19);
		contentPane.add(textPeitoral);

		JLabel labelCostas = new JLabel("Costas (cm):");
		labelCostas.setBounds(168, 157, 134, 15);
		contentPane.add(labelCostas);

		textCostas = new JTextField();
		textCostas.setColumns(10);
		textCostas.setBounds(168, 174, 134, 19);
		contentPane.add(textCostas);

		JLabel labelTrapezio = new JLabel("Trap\u00E9zio (cm):");
		labelTrapezio.setBounds(168, 195, 134, 15);
		contentPane.add(labelTrapezio);

		textTrapezio = new JTextField();
		textTrapezio.setColumns(10);
		textTrapezio.setBounds(168, 215, 134, 19);
		contentPane.add(textTrapezio);

		textCintura = new JTextField();
		textCintura.setColumns(10);
		textCintura.setBounds(168, 256, 134, 19);
		contentPane.add(textCintura);

		JLabel labelCintura = new JLabel("Cintura (cm):");
		labelCintura.setBounds(168, 237, 134, 15);
		contentPane.add(labelCintura);

		textPeso = new JTextField();
		textPeso.setColumns(10);
		textPeso.setBounds(168, 93, 134, 19);
		contentPane.add(textPeso);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(168, 287, 107, 25);
		contentPane.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificacaoPreenchimento()){
					inserirMedidas();
					try {
						PerfilUsuario tela = new PerfilUsuario();
						tela.setVisible(true);
						PerfilUsuario.getLabelInfo("Medidas inseridas com sucesso!");
						SessaoUsuario.getInstancia().setAlunoSelecionado(null);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				dispose();

			}
		});
	}

	public boolean verificacaoPreenchimento() {
		if (textAltura.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO ALTURA",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textBracos.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO BRAÇOS",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textCoxas.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO COXAS",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textPanturrilhas.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO PANTURRILHAS",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (textAntebracos.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO ANTEBRAÇOS",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}else if (textPeso.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO PESO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}else if (textPeitoral.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO PEITORAL",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}else if (textCostas.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO COSTAS",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}else if (textTrapezio.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO TRAPEZIO",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}else if (textCintura.getText().length() == 0) {
			JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO CINTURA",
					"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}else{
			return true;
		}
	}
	public void inserirMedidas(){
		Medidas medidas = new Medidas();
		Double altura = Double.valueOf(textAltura.getText()).doubleValue();
		Double bracos = Double.valueOf(textBracos.getText()).doubleValue();
		Double coxas = Double.valueOf(textCoxas.getText()).doubleValue();
		Double panturrilhas = Double.valueOf(textPanturrilhas.getText()).doubleValue();
		Double antebracos = Double.valueOf(textAntebracos.getText()).doubleValue();
		Double peso = Double.valueOf(textPeso.getText()).doubleValue();
		Double peitoral = Double.valueOf(textPeitoral.getText()).doubleValue();
		Double costas = Double.valueOf(textCostas.getText()).doubleValue();
		Double trapezio = Double.valueOf(textTrapezio.getText()).doubleValue();
		Double cintura = Double.valueOf(textCintura.getText()).doubleValue();
		
		medidas.setAltura(altura);
		medidas.setAntebracos(antebracos);
		medidas.setBracos(bracos);
		medidas.setCintura(cintura);
		medidas.setCostas(costas);
		medidas.setCoxas(coxas);
		medidas.setPanturrilha(panturrilhas);
		medidas.setPeitoral(peitoral);
		medidas.setPeso(peso);
		medidas.setTrapezio(trapezio);
		
		Pessoa pessoa = SessaoUsuario.getInstancia().getAlunoSelecionado();
		pessoa.setMedidas(medidas);
		
		UsuarioBusiness business = UsuarioBusiness.getInstancia();
		business.inserirMedidas(pessoa);
	
	}
}
