package business;

import java.util.ArrayList;

/*Vamos trabalhar o conceito de refatoração. Para isto, realize o exercício abaixo. 
Sobre este exercício, trabalharemos refatoração.
-------------------------------------------------------------------------------------------------------------
O dono de uma rede de bares da cidade nos encomendou um sistema em Java para controlar 
o acesso de clientes ao bar. O proprietário deseja que, ao entrar no bar,  cliente informe 
seu nome, CPF, idade e gênero. Alguns dos clientes pode ser sócios do bar e elegíveis a um 
programa de milhagens. Neste caso, deve-se registrar também o número do sócio.
A qualquer momento, ele deseja ser capaz de consultar quem são as pessoas que estão no bar, 
se alguém com um determinado CPF está no bar, quantas são as pessoas e qual a distribuição 
por gênero (percentual de clientes masculinos e femininos) e por status de sócio 
(quantos são sócios, e quantos não são). Ao sair, o cliente deve informar seu CPF, para 
registrar sua saída.
Modele este sistema (defina classes, com seus atributos e métodos), implemente-o e 
implemente os casos de testes usando testes unitários e JUnit.*/
public class Bar {
	/**
	 * @param clientes
	 */
	private static ArrayList<Cliente> clientes;

	public Bar() {
		clientes = new ArrayList<>();
	}

	/**
	 * Método usado pesqusiar o cliente informado já se encontra no bar. A
	 * pesquisa é realizada através do cpf informado e caso se encontre, ele
	 * retorna o cliente Senão encotrar, retorna null
	 */
	public Cliente pesquisaCliente(String cpf) {
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getCpf().equals(cpf)) {
				return clientes.get(i);
			}
		}
		return null;
	}

	/**
	 * Método valida se existe um cliente com o mesmo cpf cadastrado
	 * frequentando o bar naquele momento, caso não tenha, ele libera a entrada,
	 * se não, ele bloqueia a entrada;
	 */
	public boolean addCliente(Cliente c) {
		if (pesquisaCliente(c.getCpf()) == null) {
			clientes.add(c);
			return true;
		}
		return false;
	}

	/**
	 * Método valida se existe um cliente com o mesmo cpf cadastrado
	 * frequentando o bar se existe, ele remove
	 */
	public boolean removeCliente(Cliente c) {
		if (pesquisaCliente(c.getCpf()) == c) {
			clientes.remove(c);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return inteiro com total de clientes no bar
	 */
	public int totalPessoas() {
		return clientes.size();
	}
	/**
	 * 
	 * @return inteiro com o total de sócios no bar
	 */
	public int totalSocios() {
		int cont = 0;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getSocio() == true) {
				cont++;
			}
		}
		return cont;
	}

	/**
	 * 
	 * @return inteiro com o total de não sócios no bar
	 */
	public int totalNaoSocios() {
		int cont = 0;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getSocio() == false) {
				cont++;
			}
		}
		return cont;
	}

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}
/**
 * 
 * @return inteiro com total de mulheres no bar
 */
	public int totalMulheres() {
		int cont = 0;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getGenero().equalsIgnoreCase("FEMININO")) {
				cont++;
			}
		}
		return cont;
	}
/**
 * 
 * @return inteiro com total ed homens no bar
 */
	public int totalHomens() {
		int cont = 0;
		for (int i = 0; i < clientes.size(); i++) {
			if (clientes.get(i).getGenero().equalsIgnoreCase("MASCULINO")) {
				cont++;
			}
		}
		return cont;
	}

	/**
	 *  Percentual de homens e mulheres no bar 
	 *  */
	public String distribuicaoPorGenero() {
		double pHomens;
		double pMulheres;
		int homens = totalHomens();
		int mulheres = totalMulheres();
		int totalClientes = homens + mulheres;
		pHomens = ((totalClientes - mulheres) / totalClientes) * 100;
		System.out.println("pHomens: " + pHomens);
		pMulheres = ((totalClientes - homens) / totalClientes) * 100;
		System.out.println("pMulheres: " + pMulheres);
		return "Percentual de Homens no bar: " + pHomens + "%" + "\n" + "Percentual de Mulheres no bar: " + pMulheres
				+ "%";
	}
}