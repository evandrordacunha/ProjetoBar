package uinterface;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.Bar;
import Controls.Controle;
import business.Cliente;
import persistence.Arquivo;
import persistence.CadastroClientes;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_8;
	private Bar bar = new Bar();
	private JTextField textField_5;
	private JTextField textField_7;
	private Cliente clienteEncontrado;
	private JList lista;
	CadastroClientes cad = new CadastroClientes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
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
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 460);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBounds(15, 5, 197, 392);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(214, 5, 208, 392);
		panel_1.setBackground(SystemColor.controlDkShadow);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(428, 5, 260, 392);
		panel_2.setBackground(new Color(192, 192, 192));

		JLabel lblNewLabel_7 = new JLabel("Informe o CPF do cliente:");
		JLabel lblNewLabel_6 = new JLabel("Consultar Clientes:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBackground(new Color(0, 0, 0));

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		DefaultListModel modelo2 = new DefaultListModel();
		JList listaPesquisa = new JList(modelo2);
		listaPesquisa.setVisibleRowCount(1); // Qtd de Itens visíveis

		JButton btnNewButton_2 = new JButton("Buscar");

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controle c = new Controle();
				String cpfPesquisa = textField_3.getText();
				// valida cpf verificando se os numeros informados correspondem
				// a 11 dígitos de um CPF
				boolean checkCpf = c.validaCpf(cpfPesquisa);
				if (checkCpf == true) {
					clienteEncontrado = bar.pesquisaCliente(cpfPesquisa);
					modelo2.addElement("Cliente: " + clienteEncontrado.getNome());
				} else {
					JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
				}

			}
		});
		JLabel lblNewLabel_8 = new JLabel("Estat\u00EDsticas:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel lblNewLabel_9 = new JLabel("Total Clientes:");
		JLabel lblNewLabel_10 = new JLabel("S\u00F3cios");

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_6 = new JTextField();
		textField_6.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("N\u00E3o S\u00F3cios");
		JLabel lblNewLabel_12 = new JLabel("Distribui\u00E7\u00E3o:");
		JTextArea textArea_2 = new JTextArea();
		JLabel lblNewLabel_5 = new JLabel("Clientes no Bar:");
		lblNewLabel_5.setBounds(43, 11, 109, 17);
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel lblNewLabel_13 = new JLabel("Fechamento do dia:");
		lblNewLabel_13.setBounds(47, 305, 136, 17);
		lblNewLabel_13.setForeground(new Color(0, 255, 0));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		JButton btnNewButton_4 = new JButton("Encerrar atividades");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controle c = new Controle();
				c.gerarAquivo();
			}
		});
		btnNewButton_4.setBounds(10, 328, 188, 23);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_5);
		panel_1.add(btnNewButton_4);
		panel_1.add(lblNewLabel_13);
		JLabel lblNewLabel = new JLabel("Cadastro Cliente:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		JLabel lblNewLabel_3 = new JLabel("Idade:");
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		JLabel lblNewLabel_4 = new JLabel("G\u00EAnero:");
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
		DefaultListModel modelo = new DefaultListModel();
		lista = new JList(modelo);
		lista.setBounds(10, 32, 188, 267);
		panel_1.add(lista);
		lista.setVisibleRowCount(100); // Qtd de Itens visíveis
		lista.setBounds(10, 39, 188, 260);
		panel_1.add(lista);
		JCheckBox checkbox = new JCheckBox("\u00C9 s\u00F3cio:");
		JLabel lblNewLabel_14 = new JLabel("N\u00FAmero de S\u00F3cio:");
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			/* Botão cadastrar */
			public void actionPerformed(ActionEvent arg0) {
				Controle c = new Controle();
				String nomeCadastrado = textField.getText().toUpperCase();
				String cpfCadastrado = textField_1.getText().toUpperCase();
				String idade = textField_2.getText();
				int idadeCadastrada = Integer.parseInt(idade);
				String generoCadastrado = comboBox.getSelectedItem().toString().toUpperCase();
				String numeroSocio = textField_8.getText();
				boolean socioC = checkbox.isSelected();
				boolean socio = c.validaSocio(checkbox, socioC);
				int numeroSocioCadastrado = c.tratarNumeroSocio(numeroSocio);
				Cliente cliente = new Cliente(nomeCadastrado, cpfCadastrado, idadeCadastrada, generoCadastrado, socio,
						numeroSocioCadastrado);
				if (c.validaCpf(cpfCadastrado) == true && (c.validaIdade(idadeCadastrada) == true)
						&& (c.validaNumeroSocio(bar, numeroSocio, socio) == true)) {
					bar.addCliente(cliente);
					c.popularListaClientes(panel_1, modelo, cpfCadastrado, bar);
					// atualiza dados estatísticos
					c.atualizaDadosEstatisticos(textField_4, textField_5, textField_7, bar);
					textArea_2.setText(bar.distribuicaoPorGenero());
					c.reset(textField, textField_1, textField_2, comboBox, checkbox, textField_8);


					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Confira os dados informados!");
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(panel);

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addContainerGap().addComponent(btnNewButton,
												GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addGap(10).addComponent(lblNewLabel,
												GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addGap(10).addComponent(lblNewLabel_1,
												GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addGap(10).addComponent(textField,
												GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addGap(10).addComponent(lblNewLabel_2))
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addGap(10).addComponent(textField_1,
												GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addGap(10).addComponent(lblNewLabel_3)
												.addGap(32).addComponent(lblNewLabel_4))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(10)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)
										.addGap(32).addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 103,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING,
										gl_panel.createSequentialGroup().addGap(10).addComponent(textField_8,
												GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup().addGap(10)
										.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(checkbox, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblNewLabel_14, Alignment.LEADING,
														GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE))))
						.addContainerGap(20, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(11).addComponent(lblNewLabel).addGap(18)
						.addComponent(lblNewLabel_1).addGap(6)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(11).addComponent(lblNewLabel_2).addGap(6)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
						.addGap(11)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(checkbox).addGap(18)
						.addComponent(lblNewLabel_14).addGap(11).addComponent(textField_8, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(26).addComponent(btnNewButton).addGap(39)));
		panel.setLayout(gl_panel);
		contentPane.add(panel_1);

		/* INICIO PAINEL 2 */
		contentPane.add(panel_2);
		JButton btnNewButton_3 = new JButton("Registrar sa\u00EDda do bar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controle c = new Controle();
				// remove cliente da lista do bar, registrando a saída
				c.removerCliente(clienteEncontrado, bar, modelo);
				bar.removeCliente(clienteEncontrado);
				c.resetFormularioPesquisa(modelo2, textField_3);
				c.atualizaDadosEstatisticos(textField_4, textField_5, textField_7, bar);
				JOptionPane.showMessageDialog(null, "Saída registrada!");
			}
		});

		JLabel lblNewLabel_15 = new JLabel("Resultado da pesquisa:");
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_7 = new JTextField();
		textField_7.setColumns(10);

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2
				.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup().addGroup(gl_panel_2
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(48).addComponent(lblNewLabel_6))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(10).addComponent(lblNewLabel_7))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(10)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 165,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(btnNewButton_2))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(10).addComponent(lblNewLabel_15))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(84).addComponent(lblNewLabel_8))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(10).addComponent(lblNewLabel_12))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(10).addComponent(textArea_2,
										GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup().addGap(10)
										.addGroup(gl_panel_2
												.createParallelGroup(Alignment.LEADING).addGroup(
														gl_panel_2.createSequentialGroup()
																.addComponent(textField_4, GroupLayout.PREFERRED_SIZE,
																		76, GroupLayout.PREFERRED_SIZE)
																.addGap(10).addComponent(textField_5,
																		GroupLayout.PREFERRED_SIZE, 77,
																		GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panel_2.createSequentialGroup().addComponent(lblNewLabel_9)
														.addGap(18).addComponent(lblNewLabel_10,
																GroupLayout.PREFERRED_SIZE, 41,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(6)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
												.addComponent(lblNewLabel_11, GroupLayout.DEFAULT_SIZE,
														GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 72,
														Short.MAX_VALUE)))
								.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(
										listaPesquisa, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
										.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)))
								.addContainerGap()));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_2
				.createSequentialGroup().addGap(12).addComponent(lblNewLabel_6).addGap(11).addComponent(lblNewLabel_7)
				.addGap(6)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup().addGap(1).addComponent(textField_3,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_2))
				.addGap(6).addComponent(lblNewLabel_15).addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(listaPesquisa, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnNewButton_3).addPreferredGap(ComponentPlacement.RELATED).addComponent(lblNewLabel_8)
				.addGap(11)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_9)
						.addComponent(lblNewLabel_11).addComponent(lblNewLabel_10))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(6).addComponent(lblNewLabel_12).addGap(6)
				.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)));
		panel_2.setLayout(gl_panel_2);
	}
}
