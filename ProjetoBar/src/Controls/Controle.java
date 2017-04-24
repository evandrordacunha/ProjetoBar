package Controls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.Cliente;
import persistence.CadastroClientes;
import business.Bar;

public class Controle {
	private CadastroClientes cad = new CadastroClientes();
	private ArrayList<Cliente> clientesDoBar = cad.getClientes();

	/**
	 * 
	 * @param checkbox
	 * @param socio
	 * @return true se cliente é sócio do bar ou FALSE se não
	 */
	public boolean validaSocio(JCheckBox checkbox, boolean socio) {
		if (checkbox.isSelected() == true) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param panel_1
	 *            Percorre lista de clientes e adiciona no JList (Clientes no
	 *            Bar)
	 */
	public void popularListaClientes(JPanel panel_1, DefaultListModel modelo, String cpf, Bar bar) {
		int cont = 0;
		Cliente c = null;
		for (int i = 0; i < bar.getClientes().size(); i++) {
			c = bar.getClientes().get(i);
			if (c.getCpf().equals(cpf)) {
				break;
			}
			cont++;
		}

		cad.addCliente(c);
		System.out.println(cad.toString());
		modelo.add(cont, bar.getClientes().get(cont).getNome());
	}

	/**
	 * 
	 * @param textField
	 * @param textField_1
	 * @param textField_2
	 * @param comboBox
	 * @param checkbox
	 * @param textField_8
	 *            Reseta todos os campos do formulário de cadastro
	 */
	public void reset(JTextField textField, JTextField textField_1, JTextField textField_2, JComboBox comboBox,
			JCheckBox checkbox, JTextField textField_8) {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		checkbox.setSelected(false);
		comboBox.getSelectedItem().toString().toUpperCase();
		textField_8.setText("");
	}

	/**
	 * 
	 * @param textField_4
	 * @param textField_5
	 * @param textField_7
	 * @param bar
	 *            Atualiza campos com dados estatísticos : Número de Sócios, Não
	 *            Sócios, Total de Clientes e Distribuição por Gênero
	 */
	public void atualizaDadosEstatisticos(JTextField textField_4, JTextField textField_5, JTextField textField_7,
			Bar bar) {
		textField_4.setText("" + bar.totalPessoas());
		textField_5.setText("" + bar.totalSocios());
		textField_7.setText("" + bar.totalNaoSocios());
	}

	/**
	 * 
	 * @param cpf
	 * @return true se CPF for válido ou false se for inválido
	 */
	public boolean validaCpf(String cpf) {
		// Testa CPF preenchido
		if (cpf.length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF informado inválido!");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param idade
	 * @return true se idade for válida ou false se ela for inválida
	 */
	public boolean validaIdade(int idade) {
		if (idade < 0 || idade > 120) {
			JOptionPane.showMessageDialog(null, "Idade informada inválida! ");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param numeroSocio
	 * @return numero, transformando campos em branco em numero 0, ou trazendo o
	 *         numero informado
	 */
	public int tratarNumeroSocio(String numeroSocio) {
		int numero;
		int numeroInformado = Integer.parseInt(numeroSocio);
		if (numeroSocio.equals("") || numeroInformado < 0) {
			numero = 0;
		} else {
			numero = Integer.parseInt(numeroSocio);
		}
		return numero;
	}

	/**
	 * 
	 * @param numeroSocio
	 * @param bar
	 * @return check = false se não passou nos testes ou check = true se passou
	 */
	public boolean validaNumeroSocio(Bar bar, String numeroSocio, boolean socio) {
		int nSocio = tratarNumeroSocio(numeroSocio);
		boolean check = true;
		if (validaCampoNumeroSocioVazio(numeroSocio, socio) == false) {
			check = false;
		}
		if (validaCampoNumeroSocioNegativo(nSocio) == false) {
			check = false;
		}
		if (validaCampoNumeroSocioRepetido(nSocio, bar) == false) {
			check = false;
		}
		if (check == false) {

		}

		return check;
	}

	/**
	 * 
	 * @param numeroSocio
	 * @param socio
	 * @return true caso checkbox selecionado e numero de sócio informado, ou
	 *         false se não for preenchido
	 */
	private boolean validaCampoNumeroSocioVazio(String numeroSocio, boolean socio) {
		if (socio == true) {
			if (numeroSocio.length() == 0) {
				JOptionPane.showMessageDialog(null, "Você deve informar o número de sócio!");
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param nSocio
	 * @param bar
	 * @return false se o número de sócio informado já se encontra cadastrado,
	 *         ou true se não
	 */
	private boolean validaCampoNumeroSocioRepetido(int nSocio, Bar bar) {
		ArrayList<Cliente> clientes = bar.getClientes();
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getNumeroSocio() == nSocio) {
				JOptionPane.showMessageDialog(null, "Já existe um sócio cadastrado com o número informado! ");
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param nSocio
	 * @return false se número de sócio informado for negativo, e true se
	 *         estiver OK, for positivo
	 */
	private boolean validaCampoNumeroSocioNegativo(int nSocio) {
		if (nSocio < 0) {
			JOptionPane.showMessageDialog(null, "Número de sócio não pode ser negativo: ");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param cliente
	 * @param bar
	 * @param modelo
	 * @return true se cliente foi removido e atualizado na lista de clientes do
	 *         bar ou false se não foi encontrado
	 */
	public boolean removerCliente(Cliente cliente, Bar bar, DefaultListModel modelo) {
		Cliente c = null;
		for (int i = 0; i < bar.getClientes().size(); i++) {
			c = bar.getClientes().get(i);
			if (cliente.getCpf().equals(c.getCpf())) {
				modelo.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param modelo2
	 * @param textField_3
	 *            Reseta todos campos do formulário de pesquisa de cliente por
	 *            CPF
	 */
	public void resetFormularioPesquisa(DefaultListModel modelo2, JTextField textField_3) {
		modelo2.removeAllElements();
		textField_3.setText("");
	}

	/**
	 * Gera relatório de clientes que passaram pelo bar em arquivo txt
	 */
	public void gerarAquivo() {
		Cliente c = null;
		String novaLinha="";
		try {
			File arquivo = new File("ClientesDoBar.txt");
			FileWriter fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < Bar.getClientes().size(); i++) {
				c = Bar.getClientes().get(i);
				bw.write("Cliente: " +c.getNome()+"\n");
				bw.newLine();
				bw.write("CPF: " +c.getCpf()+"\n");
				bw.newLine();
				bw.write("Idade: " +c.getIdade()+"\n");
				bw.newLine();
				bw.write("Gênero: " +c.getGenero()+"\n");
				bw.newLine();
				bw.write("Número de Sócio: " +c.getNumeroSocio()+"\n");
				bw.newLine();
				 
			}
			bw.close();
			fw.close();
			JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso!");
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Falha ao gerar o arquivo!");
		}
	}

}
		 
		
 
