package com.sgta.usuario.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javafx.scene.control.ComboBox;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;

import com.sgta.Login;
import com.sgta.usuario.dominio.Pessoa;
import com.sgta.usuario.gui.Toast.Style;
import com.sgta.usuario.negocio.UsuarioBusiness;
import com.sgta.usuario.dominio.Medidas;
import java.awt.Font;

public class MenuRelatorio extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField cpf;
	private MaskFormatter ftmCpf;
	private JComboBox comboBoxData;
	// final static MenuRelatorio frame = new MenuRelatorio();
	private UsuarioBusiness business = UsuarioBusiness.getInstancia();
	private JLabel lblNomeAluno;
	private List<Medidas> listMedidas;
	private JTextArea textAreaRelatorio;
	private JLabel lblCampoAltura;
	private JLabel labelCampoAntebraco;
	private JLabel lblCampoPanturrilhas;
	private JLabel lblCampoCoxas;
	private JLabel lblCampoBraco;
	private JLabel lblCampoCintura;
	private JLabel lblCampoTrapezio;
	private JLabel lblCampoCostas;
	private JLabel lblCampoPeitoral;
	private JLabel lblCampoPeso;
	private JLabel labelIMC;
	private JLabel labelInfoIMC;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuRelatorio frame = new MenuRelatorio();
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
	public MenuRelatorio() {
		setTitle("SGTA - <Nome da Academia>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setBounds(10, 11, 46, 14);
		contentPane.add(lblCPF);

		JLabel lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(10, 39, 46, 14);
		contentPane.add(lblAluno);

		lblNomeAluno = new JLabel("");
		lblNomeAluno.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNomeAluno.setBounds(66, 39, 238, 14);
		contentPane.add(lblNomeAluno);

		JLabel lblRelatorio = new JLabel("Relat\u00F3rio:");
		lblRelatorio.setBounds(10, 116, 58, 14);
		contentPane.add(lblRelatorio);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cpf.getText().equals("   .   .   -  ")) {
					JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO CPF",
							"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
				} else {
					Pessoa aluno;
					try {
						aluno = business.buscarAluno(cpf.getText());
						if (aluno.getNome() == null) {
							JOptionPane.showMessageDialog(null,
									"Aluno não cadastrado!", "Atenção",
									JOptionPane.WARNING_MESSAGE);
						} else {
							// listMedidas =
							// business.retornaMedidasByUsuario(aluno.getUsuario().getId());
							lblNomeAluno.setText(aluno.getNome());
							List datas = new ArrayList<String>();
							final List<Medidas> listMedidas = business
									.retornaMedidasByUsuario(aluno.getUsuario()
											.getId());
							datas.add("");
							SimpleDateFormat formatter = new SimpleDateFormat(
									"dd/MM/yyyy HH:mm");
							if (!(listMedidas.isEmpty())) {
								for (Medidas p : listMedidas) {
									datas.add(formatter.format(p.getData()));
								}
							}
							final String[] items = (String[]) datas
									.toArray(new String[datas.size()]);
							comboBoxData = new JComboBox(items);
							comboBoxData.setBounds(66, 64, 252, 20);
							contentPane.add(comboBoxData);
							comboBoxData
									.addActionListener(new ActionListener() {

										@Override
										public void actionPerformed(
												ActionEvent e) {
											//Medidas medidas = new Medidas();

											if (comboBoxData.getSelectedItem() != "") {
												try {
													Medidas medidas = business
															.retornaMedidasDatas(comboBoxData
																	.getSelectedItem().toString());
													System.out
															.println(comboBoxData
																	.getSelectedItem().toString());
													textAreaRelatorio.setText(medidas.getRelatorio());
													lblCampoAltura.setText(""+medidas.getAltura().toString());
													lblCampoPeso.setText(""+medidas.getPeso().toString());
													lblCampoBraco.setText(""+medidas.getBracos().toString());
													labelCampoAntebraco.setText(""+medidas.getAntebracos().toString());
													lblCampoCintura.setText(""+medidas.getCintura().toString());
													lblCampoCoxas.setText(""+medidas.getCoxas().toString());
													lblCampoCostas.setText(""+medidas.getCostas().toString());
													lblCampoTrapezio.setText(""+medidas.getTrapezio().toString());
													lblCampoPeitoral.setText(""+medidas.getPeitoral().toString());
													lblCampoPanturrilhas.setText(""+medidas.getPanturrilha().toString());
													
												} catch (SQLException e1) {
													// TODO Auto-generated catch
													// block
													e1.printStackTrace();
												}
											}
										}
									});

						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		btnBuscar.setBounds(335, 7, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblHistoricoDeMedidas = new JLabel("Historico de Medidas:");
		lblHistoricoDeMedidas.setBounds(10, 225, 155, 14);
		contentPane.add(lblHistoricoDeMedidas);

		JLabel lblData_2 = new JLabel("Data:");
		lblData_2.setBounds(10, 64, 46, 14);
		contentPane.add(lblData_2);

		JLabel lblAltura = new JLabel("Altura (m):");
		lblAltura.setBounds(10, 261, 81, 14);
		contentPane.add(lblAltura);

		JLabel lblBraos = new JLabel("Bra\u00E7os (cm):");
		lblBraos.setBounds(10, 286, 81, 14);
		contentPane.add(lblBraos);

		JLabel lblCoxas = new JLabel("Coxas (cm):");
		lblCoxas.setBounds(10, 311, 81, 14);
		contentPane.add(lblCoxas);

		JLabel lblPanturilhas = new JLabel("Panturrilhas (cm):");
		lblPanturilhas.setBounds(10, 336, 104, 14);
		contentPane.add(lblPanturilhas);

		JLabel lblAntebraos = new JLabel("Antebra\u00E7os (cm):");
		lblAntebraos.setBounds(10, 361, 104, 14);
		contentPane.add(lblAntebraos);

		labelCampoAntebraco = new JLabel("");
		labelCampoAntebraco.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelCampoAntebraco.setBounds(119, 361, 79, 14);
		contentPane.add(labelCampoAntebraco);

		lblCampoPanturrilhas = new JLabel("");
		lblCampoPanturrilhas.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoPanturrilhas.setBounds(119, 336, 79, 14);
		contentPane.add(lblCampoPanturrilhas);

		lblCampoCoxas = new JLabel("");
		lblCampoCoxas.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoCoxas.setBounds(109, 311, 89, 14);
		contentPane.add(lblCampoCoxas);

		lblCampoBraco = new JLabel("");
		lblCampoBraco.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoBraco.setBounds(109, 286, 89, 14);
		contentPane.add(lblCampoBraco);

		lblCampoAltura = new JLabel("");
		lblCampoAltura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoAltura.setBounds(109, 261, 89, 14);
		contentPane.add(lblCampoAltura);

		JLabel lblTrapzio = new JLabel("Trap\u00E9zio (cm):");
		lblTrapzio.setBounds(230, 336, 116, 14);
		contentPane.add(lblTrapzio);

		JLabel lblCintura = new JLabel("Cintura (cm):");
		lblCintura.setBounds(230, 361, 74, 14);
		contentPane.add(lblCintura);

		JLabel lblCostas = new JLabel("Costas (cm):");
		lblCostas.setBounds(230, 311, 74, 14);
		contentPane.add(lblCostas);

		JLabel lblPeitoral = new JLabel("Peitoral (cm):");
		lblPeitoral.setBounds(230, 286, 104, 14);
		contentPane.add(lblPeitoral);

		JLabel lblPeso = new JLabel("Peso (kg):");
		lblPeso.setBounds(230, 261, 74, 14);
		contentPane.add(lblPeso);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuProfessor tela = new MenuProfessor();
				tela.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(335, 433, 89, 23);
		contentPane.add(btnVoltar);

		lblCampoCintura = new JLabel("");
		lblCampoCintura.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoCintura.setBounds(314, 361, 68, 14);
		contentPane.add(lblCampoCintura);

		lblCampoTrapezio = new JLabel("");
		lblCampoTrapezio.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoTrapezio.setBounds(314, 336, 68, 14);
		contentPane.add(lblCampoTrapezio);

		lblCampoCostas = new JLabel("");
		lblCampoCostas.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoCostas.setBounds(314, 311, 68, 14);
		contentPane.add(lblCampoCostas);

		lblCampoPeitoral = new JLabel("");
		lblCampoPeitoral.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoPeitoral.setBounds(314, 286, 68, 14);
		contentPane.add(lblCampoPeitoral);

		lblCampoPeso = new JLabel("");
		lblCampoPeso.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblCampoPeso.setBounds(314, 261, 68, 14);
		contentPane.add(lblCampoPeso);
		// --- formatar cpf e data
		try {
			ftmCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cpf = new JFormattedTextField(ftmCpf);
		cpf.setBounds(62, 8, 136, 20);
		contentPane.add(cpf);

		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(10, 388, 46, 14);
		contentPane.add(lblImc);

		labelIMC = new JLabel("");
		labelIMC.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelIMC.setBounds(46, 388, 89, 14);
		contentPane.add(labelIMC);

		labelInfoIMC = new JLabel("");
		labelInfoIMC.setFont(new Font("Tahoma", Font.ITALIC, 11));
		labelInfoIMC.setBounds(173, 388, 231, 14);
		contentPane.add(labelInfoIMC);

		textAreaRelatorio = new JTextArea();
		textAreaRelatorio.setEditable(false);
		textAreaRelatorio.setBounds(76, 111, 348, 103);
		contentPane.add(textAreaRelatorio);
	}

}
