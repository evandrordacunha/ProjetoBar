package business;

import javax.swing.JOptionPane;

public class Pessoa {
	private String nome, cpf, genero;
	private int idade;

	/**
	 * @param nome
	 * @param cpf
	 * @param idade
	 * @param genero
	 */
	public Pessoa(String nome, String cpf, int idade, String genero) {
		setNome(nome);
		this.cpf = cpf; // validação está sendo feita no formulario
		setIdade(idade);
		setGenero(genero);
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		try {
			if (nome.length() > 0) {
				this.nome = nome;
			} else {
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Você deve informar um nome! " + e.getMessage());
		}
	}

	/**
	 * @param idade
	 *            the idade to set
	 */
	public boolean setIdade(int idade) {
		try {
			if (idade > 0 && idade < 120) {
				this.idade = idade;
				return true;
			}
		} catch (NumberFormatException e) {

			System.out.println("Você deve informar uma idade válida entre! " + e.getMessage());
		}
		return false;
	}

	/**
	 * @param genero
	 *            the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	public int getIdade() {
		return idade;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	@Override
	public String toString() {
		String s = "Nome:" + getNome() + ";" + "CPF:" + getCpf() + ";" + "Idade:" + getIdade() + ";" + "Gênero:"
				+ getGenero() + ";";
		return s;
	}
}