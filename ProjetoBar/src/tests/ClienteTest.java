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
	 * Inclui um n�mero de s�cio a um cliente atrav�s do m�todo setNumeroSocio()
	 * Caso n�o realize a altera��o Retorna false e lan�a uma exce��o ->
	 * AssertionError
	 */
	public void testSetNumeroSocio() {
		c.setNumeroSocio(800);
		assert (c.getNumeroSocio() > 0);
	}

}
