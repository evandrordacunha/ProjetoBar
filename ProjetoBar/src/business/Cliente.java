package business;

public class Cliente extends Pessoa {

	private int numeroSocio;
	private boolean socio;

	public Cliente(String nome, String cpf, int idade, String genero, boolean socio, int numeroSocio) {
		super(nome, cpf, idade, genero);
		setSocio(socio);
		setNumeroSocio(numeroSocio);
	}

	/**
	 * @return the numeroSocio
	 */
	public int getNumeroSocio() {
		return numeroSocio;
	}

	/**
	 * @return the socio
	 */
	public boolean getSocio() {
		return socio;
	}

	/**
	 * @param socio
	 *            the socio to set
	 */
	public void setSocio(boolean socio) {
		this.socio = socio;
	}

	/**
	 * @param numeroSocio
	 *            the numeroSocio to set
	 */
	public void setNumeroSocio(int numeroSocio) {
		if (numeroSocio > 0) {
			this.numeroSocio = numeroSocio;
		} else {
			this.numeroSocio = 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = getNome() 
				+ "\n" + "CPF: " + getCpf() 
				+ "\n" + "Idade: " + getIdade() 
				+ "\n" + "Gênero: " + getGenero()
				+"\n"+ "Número de Sócio: " + getNumeroSocio() 
				+ "\n";
		return s;

	}

}