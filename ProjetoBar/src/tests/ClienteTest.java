package tests;

import org.junit.Before;
import org.junit.Test;

import business.Cliente;

public class ClienteTest {
	Cliente c;

	@Before
	public void initialize() {
		c = new Cliente("Luis", "11122255666", 25, "MASCULINO", true, 45);
	}

	@Test
	/*
	 * Inclui um número de sócio a um cliente através do método setNumeroSocio()
	 * Caso não realize a alteração Retorna false e lança uma exceção ->
	 * AssertionError
	 */
	public void testSetNumeroSocio() {
		c.setNumeroSocio(800);
		assert (c.getNumeroSocio() > 0);
	}

}
