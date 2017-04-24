package persistence;

import business.Cliente;
import java.util.ArrayList;

public class CadastroClientes {

	ArrayList<Cliente> clientes;

	public CadastroClientes() {
		clientes = new ArrayList<>();
	}

	/**
	 * 
	 * @param c
	 * @return true se o cliente informado j� se encontra na lista, ou false se
	 *         n�o
	 */
	public boolean buscaCliente(Cliente c) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCpf().equals(c.getCpf())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 * @return true para cliente adicionado com sucesso ou false caso n�o
	 *         consiga adicionar
	 */
	public boolean addCliente(Cliente c) {
		if (buscaCliente(c) == false) {
			clientes.add(c);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param c
	 * @return true se encontrou o cliente para remover e removeu com sucesso
	 *         false caso n�o encontre o cliente para remover
	 */
	public boolean removeCliente(Cliente c) {
		if (buscaCliente(c) == true) {
			clientes.remove(c);
			return true;
		}
		return false;

	}

	/**
	 * 
	 * @return Lista de clientes cadastrados
	 */
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < clientes.size(); i++) {
			s = s + clientes.get(i).toString() + "\n";
		}
		return s;
	}

}
