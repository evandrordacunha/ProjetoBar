package business;

import java.util.ArrayList;

/*Vamos trabalhar o conceito de refatora��o. Para isto, realize o exerc�cio abaixo. 
Sobre este exerc�cio, trabalharemos refatora��o.
-------------------------------------------------------------------------------------------------------------
O dono de uma rede de bares da cidade nos encomendou um sistema em Java para controlar 
o acesso de clientes ao bar. O propriet�rio deseja que, ao entrar no bar,  cliente informe 
seu nome, CPF, idade e g�nero. Alguns dos clientes pode ser s�cios do bar e eleg�veis a um 
programa de milhagens. Neste caso, deve-se registrar tamb�m o n�mero do s�cio.
A qualquer momento, ele deseja ser capaz de consultar quem s�o as pessoas que est�o no bar, 
se algu�m com um determinado CPF est� no bar, quantas s�o as pessoas e qual a distribui��o 
por g�nero (percentual de clientes masculinos e femininos) e por status de s�cio 
(quantos s�o s�cios, e quantos n�o s�o). Ao sair, o cliente deve informar seu CPF, para 
registrar sua sa�da.
Modele este sistema (defina classes, com seus atributos e m�todos), implemente-o e 
implemente os casos de testes usando testes unit�rios e JUnit.*/
public class Bar {
	/**
	 * @param clientes
	 */
	private static ArrayList<Cliente> clientes;

	public Bar() {
		clientes = new ArrayList<>();
	}

	/**
	 * M�todo usado pesqusiar o cliente informado j� se encontra no bar. A
	 * pesquisa � realizada atrav�s do cpf informado e caso se encontre, ele
	 * retorna o cliente Sen�o encotrar, retorna null
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
	 * M�todo valida se existe um cliente com o mesmo cpf cadastrado
	 * frequentando o bar naquele momento, caso n�o tenha, ele libera a entrada,
	 * se n�o, ele bloqueia a entrada;
	 */
	public boolean addCliente(Cliente c) {
		if (pesquisaCliente(c.getCpf()) == null) {
			clientes.add(c);
			return true;
		}
		return false;
	}

	/**
	 * M�todo valida se existe um cliente com o mesmo cpf cadastrado
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
	 * @return inteiro com o total de s�cios no bar
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
	 * @return inteiro com o total de n�o s�cios no bar
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