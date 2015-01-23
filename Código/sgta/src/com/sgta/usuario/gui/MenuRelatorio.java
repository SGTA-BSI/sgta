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

public class MenuRelatorio extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField cpf;
	private MaskFormatter ftmCpf;
	private JComboBox comboBoxData;
	//final static MenuRelatorio frame = new MenuRelatorio();
	private UsuarioBusiness business = UsuarioBusiness.getInstancia();
	private JLabel lblNomeAluno;
	private List<Medidas> listMedidas;
	
	
	

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
		lblNomeAluno.setBounds(66, 39, 238, 14);
		contentPane.add(lblNomeAluno);
		
		JLabel lblRelatorio = new JLabel("Relat\u00F3rio:");
		lblRelatorio.setBounds(10, 116, 58, 14);
		contentPane.add(lblRelatorio);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cpf.getText().equals("   .   .   -  ")){
					JOptionPane.showMessageDialog(null, "PREENCHA O CAMPO CPF",
							"ATENÇÃO!!", JOptionPane.WARNING_MESSAGE);
				}else{
					Pessoa aluno;
					try {
						aluno = business.buscarAluno(cpf.getText());
						if (aluno.getNome() == null){
							JOptionPane.showMessageDialog(null, "Aluno não cadastrado!","Atenção", JOptionPane.WARNING_MESSAGE);
						}else{
						//listMedidas = business.retornaMedidasByUsuario(aluno.getUsuario().getId());
						lblNomeAluno.setText(aluno.getNome());
						List datas = new ArrayList<String>();
						final List<Medidas> listMedidas = business.retornaMedidasByUsuario(aluno.getUsuario().getId());
						datas.add("");
						if (!(listMedidas.isEmpty())) {
							for (Medidas p : listMedidas) {
								datas.add(p.getData().toString());
								System.out.println(p.getData().toString());
								System.out.println(p.getBracos());
							}
						}
						final String[] items = (String[]) datas.toArray(new String[datas.size()]);
						comboBoxData = new JComboBox(items);
						comboBoxData.setBounds(66, 64, 252, 20);
						contentPane.add(comboBoxData);
						
						
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
		lblHistoricoDeMedidas.setBounds(10, 225, 116, 14);
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
		
		JLabel lblPanturilhas = new JLabel("Panturilhas (cm):");
		lblPanturilhas.setBounds(10, 336, 81, 14);
		contentPane.add(lblPanturilhas);
		
		JLabel lblAntebraos = new JLabel("Antebra\u00E7os (cm):");
		lblAntebraos.setBounds(10, 361, 89, 14);
		contentPane.add(lblAntebraos);
		
		JLabel labelCampoAntebraco = new JLabel("");
		labelCampoAntebraco.setBounds(109, 361, 89, 14);
		contentPane.add(labelCampoAntebraco);
		
		JLabel lblCampoPanturilhas = new JLabel("");
		lblCampoPanturilhas.setBounds(109, 336, 89, 14);
		contentPane.add(lblCampoPanturilhas);
		
		JLabel lblCampoCoxas = new JLabel("");
		lblCampoCoxas.setBounds(109, 311, 89, 14);
		contentPane.add(lblCampoCoxas);
		
		JLabel lblCampoBraco = new JLabel("");
		lblCampoBraco.setBounds(109, 286, 89, 14);
		contentPane.add(lblCampoBraco);
		
		JLabel lblCampoAltura = new JLabel("");
		lblCampoAltura.setBounds(109, 261, 89, 14);
		contentPane.add(lblCampoAltura);
		
		JLabel lblTrapzio = new JLabel("Trap\u00E9zio (cm):");
		lblTrapzio.setBounds(230, 336, 74, 14);
		contentPane.add(lblTrapzio);
		
		JLabel lblCintura = new JLabel("Cintura (cm):");
		lblCintura.setBounds(230, 361, 74, 14);
		contentPane.add(lblCintura);
		
		JLabel lblCostas = new JLabel("Costas (cm):");
		lblCostas.setBounds(230, 311, 74, 14);
		contentPane.add(lblCostas);
		
		JLabel lblPeitoral = new JLabel("Peitoral (cm):");
		lblPeitoral.setBounds(230, 286, 74, 14);
		contentPane.add(lblPeitoral);
		
		JLabel lblPeso = new JLabel("Peso (kg):");
		lblPeso.setBounds(230, 261, 74, 14);
		contentPane.add(lblPeso);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(335, 433, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblCampoCintura = new JLabel("");
		lblCampoCintura.setBounds(314, 361, 68, 14);
		contentPane.add(lblCampoCintura);
		
		JLabel lblCampoTrapezio = new JLabel("");
		lblCampoTrapezio.setBounds(314, 336, 68, 14);
		contentPane.add(lblCampoTrapezio);
		
		JLabel lblCampoCostas = new JLabel("");
		lblCampoCostas.setBounds(314, 311, 68, 14);
		contentPane.add(lblCampoCostas);
		
		JLabel lblCampoPeitoral = new JLabel("");
		lblCampoPeitoral.setBounds(314, 286, 68, 14);
		contentPane.add(lblCampoPeitoral);
		
		JLabel lblCampoPeso = new JLabel("");
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
		
		JLabel labelIMC = new JLabel("");
		labelIMC.setBounds(46, 388, 89, 14);
		contentPane.add(labelIMC);
		
		JLabel labelInfoIMC = new JLabel("");
		labelInfoIMC.setBounds(173, 388, 231, 14);
		contentPane.add(labelInfoIMC);
		
		JTextArea textAreaRelatorio = new JTextArea();
		textAreaRelatorio.setEditable(false);
		textAreaRelatorio.setBounds(76, 111, 348, 103);
		contentPane.add(textAreaRelatorio);
	}
	
}
